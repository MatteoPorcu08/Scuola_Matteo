import sys
import json
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.patches import FancyArrowPatch

from PyQt6.QtWidgets import (
    QApplication, QWidget, QLabel, QPushButton,
    QVBoxLayout, QHBoxLayout, QGridLayout,
    QSpinBox, QDoubleSpinBox, QComboBox,
    QTextEdit, QScrollArea
)
from PyQt6.QtCore import QTimer
from matplotlib.backends.backend_qtagg import FigureCanvasQTAgg as FigureCanvas

plt.style.use("ggplot")  # stile professionale semplice
t = np.linspace(0, 0.06, 2000)  # intervallo temporale oscilloscopio

def crea_fasore(A, fase):
    return A * np.exp(1j * np.deg2rad(fase))

def operazione(fasori, op):
    if len(fasori) == 0:
        return 0
    res = fasori[0]
    for f in fasori[1:]:
        if op == "Somma":
            res += f
        elif op == "Sottrazione":
            res -= f
        elif op == "Moltiplicazione":
            res *= f
        elif op == "Divisione":
            if f != 0:
                res /= f
    return res

class Simulatore(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Simulatore Fasori AC Professionale")
        self.tempo = 0
        self.oscilloscopio_attivo = False  # all’avvio fermo

        # Timer animazione
        self.timer = QTimer()
        self.timer.timeout.connect(self.animazione)
        self.timer.start(15)  # aggiornamento fluido

        # linee oscilloscopio
        self.linee_osc = []
        self.linea_risultante = None

        # Layout principale
        main_layout = QGridLayout()
        main_layout.setColumnStretch(0, 1)
        main_layout.setColumnStretch(1, 2)
        main_layout.setColumnStretch(2, 4)

        # -------------------
        # Controlli
        # -------------------
        controlli = QVBoxLayout()
        top = QHBoxLayout()
        self.spin = QSpinBox()
        self.spin.setRange(1, 12)
        self.spin.setValue(3)
        genera = QPushButton("Genera Fasori")
        genera.clicked.connect(self.crea_controlli)
        top.addWidget(QLabel("Numero fasori"))
        top.addWidget(self.spin)
        top.addWidget(genera)
        controlli.addLayout(top)

        self.operazione = QComboBox()
        self.operazione.addItems(["Somma", "Sottrazione", "Moltiplicazione", "Divisione"])
        self.operazione.currentIndexChanged.connect(self.aggiorna)
        controlli.addWidget(QLabel("Operazione"))
        controlli.addWidget(self.operazione)

        self.freq = QDoubleSpinBox()
        self.freq.setRange(0.01, 10000)
        self.freq.setValue(50)
        self.freq.valueChanged.connect(self.aggiorna)
        controlli.addWidget(QLabel("Frequenza (Hz)"))
        controlli.addWidget(self.freq)

        # Scroll area fasori
        self.scroll = QScrollArea()
        self.scroll_widget = QWidget()
        self.controlli_fasori = QVBoxLayout()
        self.scroll_widget.setLayout(self.controlli_fasori)
        self.scroll.setWidget(self.scroll_widget)
        self.scroll.setWidgetResizable(True)
        controlli.addWidget(self.scroll)

        # Pulsanti oscilloscopio
        pulsanti_osc = QHBoxLayout()
        start_btn = QPushButton("Avvia Oscilloscopio")
        stop_btn = QPushButton("Ferma Oscilloscopio")
        start_btn.clicked.connect(self.avvia_osc)
        stop_btn.clicked.connect(self.ferma_osc)
        pulsanti_osc.addWidget(start_btn)
        pulsanti_osc.addWidget(stop_btn)
        controlli.addLayout(pulsanti_osc)

        main_layout.addLayout(controlli, 0, 0)

        # -------------------
        # Grafici
        # -------------------
        self.fig, self.ax = plt.subplots(1, 2, figsize=(16,6))
        self.canvas = FigureCanvas(self.fig)
        main_layout.addWidget(self.canvas, 0, 1, 1, 2)
        self.fig.tight_layout(pad=4.0)

        # -------------------
        # Risultati compatti
        # -------------------
        risultati_layout = QVBoxLayout()
        self.testo = QTextEdit()
        self.testo.setReadOnly(True)
        self.testo.setFixedHeight(180)
        risultati_layout.addWidget(QLabel("Valori Fasori + Risultato Operazione"))
        risultati_layout.addWidget(self.testo)

        salva_graf = QPushButton("Salva Grafico")
        salva_sim = QPushButton("Salva Simulazione")
        salva_graf.clicked.connect(self.salva_grafico)
        salva_sim.clicked.connect(self.salva_simulazione)
        risultati_layout.addWidget(salva_graf)
        risultati_layout.addWidget(salva_sim)

        main_layout.addLayout(risultati_layout, 1, 1, 1, 2)

        self.setLayout(main_layout)
        self.crea_controlli()

    def avvia_osc(self):
        self.oscilloscopio_attivo = True

    def ferma_osc(self):
        self.oscilloscopio_attivo = False

    def clear_layout(self, layout):
        while layout.count():
            item = layout.takeAt(0)
            widget = item.widget()
            child = item.layout()
            if widget:
                widget.deleteLater()
            elif child:
                self.clear_layout(child)

    def crea_controlli(self):
        self.clear_layout(self.controlli_fasori)
        self.amp_box = []
        self.fase_box = []

        n = self.spin.value()
        for i in range(n):
            titolo = QLabel(f"X{i+1}")
            self.controlli_fasori.addWidget(titolo)

            amp = QDoubleSpinBox()
            amp.setRange(-1e6, 1e6)
            amp.setSingleStep(0.1)
            amp.setValue(1)
            amp.valueChanged.connect(self.aggiorna)
            self.controlli_fasori.addWidget(QLabel("Ampiezza"))
            self.controlli_fasori.addWidget(amp)

            fase = QDoubleSpinBox()
            fase.setRange(-360, 360)
            fase.setSingleStep(1)
            fase.setValue(0)
            fase.valueChanged.connect(self.aggiorna)
            self.controlli_fasori.addWidget(QLabel("Fase (°)"))
            self.controlli_fasori.addWidget(fase)

            self.amp_box.append(amp)
            self.fase_box.append(fase)

        self.aggiorna()

    def animazione(self):
        if self.oscilloscopio_attivo:
            self.tempo += 0.0005
            self.aggiorna()

    def aggiorna(self):
        amps = [a.value() for a in self.amp_box]
        fasi = [f.value() for f in self.fase_box]
        fasori = [crea_fasore(a, f) for a, f in zip(amps, fasi)]

        res = operazione(fasori, self.operazione.currentText()) if len(fasori) > 1 else None

        f = self.freq.value()
        colori = plt.cm.tab10.colors

        # ---------------- Fasori fissi con frecce ----------------
        self.ax[0].clear()
        max_val = 0
        for i, fas in enumerate(fasori):
            arrow = FancyArrowPatch((0,0), (fas.real, fas.imag),
                                    color=colori[i%10], arrowstyle='->', mutation_scale=20, linewidth=2)
            self.ax[0].add_patch(arrow)
            self.ax[0].text(fas.real*1.05, fas.imag*1.05, f"X{i+1}", color=colori[i%10], fontsize=10)
            max_val = max(max_val, abs(fas))
        if res is not None:
            arrow_r = FancyArrowPatch((0,0), (res.real, res.imag),
                                      color="red", arrowstyle='->', mutation_scale=25, linewidth=2)
            self.ax[0].add_patch(arrow_r)
            self.ax[0].text(res.real*1.05, res.imag*1.05, "Risultante", color="red", fontsize=12)
        lim = max(1, max_val*1.5)
        self.ax[0].set_xlim(-lim, lim)
        self.ax[0].set_ylim(-lim, lim)
        self.ax[0].axhline(0, color="black")
        self.ax[0].axvline(0, color="black")
        self.ax[0].set_xlabel("Ampiezza Reale")
        self.ax[0].set_ylabel("Ampiezza Immaginaria")
        self.ax[0].set_title("Diagramma Fasoriale (Fisso)")
        self.ax[0].grid(True)
        self.ax[0].set_aspect("equal")
        self.ax[0].plot(0,0,'ko')

        # ---------------- Oscilloscopio animato ----------------
        self.ax[1].clear()
        self.ax[1].set_title("Oscilloscopio AC")
        self.ax[1].set_xlabel("Tempo [s]")
        self.ax[1].set_ylabel("Ampiezza")
        self.ax[1].set_xlim(0, 0.06)
        self.ax[1].grid(True)

        self.linee_osc = []
        labels = []
        for i, fas in enumerate(fasori):
            A = abs(fas)
            phi = np.angle(fas)
            line, = self.ax[1].plot(t, A*np.sin(2*np.pi*f*(t+self.tempo)+phi),
                                     linestyle="--", color=colori[i%10])
            self.linee_osc.append(line)
            labels.append(f"X{i+1}")

        if res is not None:
            A = abs(res)
            phi = np.angle(res)
            self.linea_risultante, = self.ax[1].plot(t, A*np.sin(2*np.pi*f*(t+self.tempo)+phi),
                                                     color="red", linewidth=3)
            labels.append("Risultante")

        self.ax[1].legend(labels, loc='upper right', frameon=True)

        # ---------------- Risultati compatti ----------------
        testo = f"Operazione: {self.operazione.currentText()}\n"
        for i, fas in enumerate(fasori):
            testo += f"X{i+1} = {abs(fas):.2f} ∠ {np.angle(fas, deg=True):.1f}°\n"
        if res is not None:
            testo += f"\nRisultante = {abs(res):.2f} ∠ {np.angle(res, deg=True):.1f}°\n"
        self.testo.setText(testo)
        self.canvas.draw()

    def salva_grafico(self):
        self.fig.savefig("simulazione_fasori.png", dpi=300)

    def salva_simulazione(self):
        data = {
            "ampiezze": [a.value() for a in self.amp_box],
            "fasi": [f.value() for f in self.fase_box],
            "frequenza": self.freq.value(),
            "operazione": self.operazione.currentText()
        }
        with open("simulazione.json","w") as f:
            json.dump(data,f,indent=4)

# -------------------
app = QApplication(sys.argv)
window = Simulatore()
window.resize(1500, 750)
window.show()
sys.exit(app.exec())