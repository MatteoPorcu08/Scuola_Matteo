import tkinter as tk
from tkinter import messagebox

class BarDellaScuola:
    def __init__(self):
        self.prodotti = {
            "Caffè": 1.50,
            "The": 1.00,
            "Acqua": 0.50,
            "Coca-Cola": 2.00,
            "Panino": 3.00,
            "Pizza": 4.00
        }
        self.ordini = {}

        self.root = tk.Tk()
        self.root.title("Bar della Scuola")

        self.label_nome = tk.Label(self.root, text="Nome:")
        self.label_nome.pack()

        self.entry_nome = tk.Entry(self.root)
        self.entry_nome.pack()

        self.label_prodotto = tk.Label(self.root, text="Prodotto:")
        self.label_prodotto.pack()

        self.option_prodotto = tk.StringVar(self.root)
        self.option_prodotto.set(list(self.prodotti.keys())[0])
        self.option_menu_prodotto = tk.OptionMenu(self.root, self.option_prodotto, *self.prodotti.keys())
        self.option_menu_prodotto.pack()

        self.label_quantità = tk.Label(self.root, text="Quantità:")
        self.label_quantità.pack()

        self.entry_quantità = tk.Entry(self.root)
        self.entry_quantità.pack()

        self.button_aggiungi = tk.Button(self.root, text="Aggiungi", command=self.aggiungi_ordine)
        self.button_aggiungi.pack()

        self.button_visualizza = tk.Button(self.root, text="Visualizza ordini", command=self.visualizza_ordini)
        self.button_visualizza.pack()

        self.button_paga = tk.Button(self.root, text="Paga", command=self.paga)
        self.button_paga.pack()

    def aggiungi_ordine(self):
        nome = self.entry_nome.get()
        prodotto = self.option_prodotto.get()
        quantità = int(self.entry_quantità.get())

        if nome not in self.ordini:
            self.ordini[nome] = {}

        if prodotto not in self.ordini[nome]:
            self.ordini[nome][prodotto] = 0

        self.ordini[nome][prodotto] += quantità

        messagebox.showinfo("Ordine aggiunto", f"Ordine aggiunto per {nome}")

    def visualizza_ordini(self):
        ordini_str = ""
        for nome, prodotti in self.ordini.items():
            ordini_str += f"{nome}:\n"
            for prodotto, quantità in prodotti.items():
                ordini_str += f"- {prodotto}: {quantità} x {self.prodotti[prodotto]}€\n"
            ordini_str += "\n"

        messagebox.showinfo("Ordini", ordini_str)

    def paga(self):
        totale = 0
        for nome, prodotti in self.ordini.items():
            for prodotto, quantità in prodotti.items():
                totale += quantità * self.prodotti[prodotto]

        messagebox.showinfo("Pagamento", f"Totale: {totale}€")

        self.ordini = {}

    def run(self):
        self.root.mainloop()

if __name__ == "__main__":
    app = BarDellaScuola()
    app.run()