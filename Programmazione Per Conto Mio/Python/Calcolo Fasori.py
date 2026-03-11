import numpy as np
import plotly.graph_objects as go
from dash import Dash, dcc, html, Output, Input

# --- Parametri ---
omega = 2 * np.pi * 50
t = np.linspace(0, 0.04, 1000)
colori = ['blue','green','orange','purple','brown','cyan','magenta','yellow','pink','grey']

# --- Funzioni matematiche ---
def crea_fasore(amp, fase_deg):
    fase_rad = np.deg2rad(fase_deg)
    return amp * np.exp(1j * fase_rad)

def corrente_da_fasore(fasore):
    A = abs(fasore)
    phi = np.angle(fasore)
    return A * np.sin(omega * t + phi)

def genera_figure(amps, fasi):
    fasori = [crea_fasore(a,f) for a,f in zip(amps,fasi)]
    somma = sum(fasori)

    # ----- Grafico fasori -----
    fig_fasori = go.Figure()

    for i,f in enumerate(fasori):
        fig_fasori.add_trace(go.Scatter(
            x=[0,f.real],
            y=[0,f.imag],
            mode='lines+markers+text',
            line=dict(color=colori[i % len(colori)], width=4),
            marker=dict(size=8),
            text=[None,f"F{i+1}"],
            textposition="top right",
            name=f'F{i+1} ({abs(f):.2f}∠{np.angle(f,deg=True):.1f}°)'
        ))

    fig_fasori.add_trace(go.Scatter(
        x=[0,somma.real],
        y=[0,somma.imag],
        mode='lines+markers+text',
        line=dict(color='red', width=5),
        marker=dict(size=8),
        text=[None,"Somma"],
        textposition="top right",
        name=f'Somma ({abs(somma):.2f}∠{np.angle(somma,deg=True):.1f}°)'
    ))

    fig_fasori.update_layout(
        title="Fasori (Piano Complesso)",
        xaxis=dict(scaleanchor="y", scaleratio=1, title="Parte reale"),
        yaxis=dict(title="Parte immaginaria"),
        height=500
    )

    # ----- Corrente alternata -----
    fig_corrente = go.Figure()

    i_totale = sum(corrente_da_fasore(f) for f in fasori)

    for i,f in enumerate(fasori):
        fig_corrente.add_trace(go.Scatter(
            x=t,
            y=corrente_da_fasore(f),
            mode='lines',
            line=dict(dash='dash', color=colori[i % len(colori)]),
            name=f'F{i+1}'
        ))

    fig_corrente.add_trace(go.Scatter(
        x=t,
        y=i_totale,
        mode='lines',
        line=dict(color='red', width=3),
        name='Somma'
    ))

    fig_corrente.update_layout(
        title="Corrente Alternata nel Tempo",
        xaxis_title="Tempo [s]",
        yaxis_title="Ampiezza",
        height=400
    )

    return fig_fasori, fig_corrente


# -------- Numero fasori --------
n_fasori = int(input("Quanti fasori vuoi simulare? "))

# -------- App Dash --------
app = Dash(__name__)

# Slider dinamici
sliders = []
for i in range(n_fasori):

    sliders.append(html.Label(f"Ampiezza Fasore {i+1}"))
    sliders.append(
        dcc.Slider(
            0, 10, 0.1,
            value=1,
            id=f"amp_{i}",
            tooltip={"placement":"bottom","always_visible":True}
        )
    )

    sliders.append(html.Label(f"Fase Fasore {i+1}"))
    sliders.append(
        dcc.Slider(
            -180,180,1,
            value=0,
            id=f"fase_{i}",
            tooltip={"placement":"bottom","always_visible":True}
        )
    )

# Layout
app.layout = html.Div([

    html.H1("Simulatore Fasori e Corrente AC"),

    html.Div(sliders),

    dcc.Graph(id="grafico_fasori"),
    dcc.Graph(id="grafico_corrente")

])

# Callback aggiornamento grafici
@app.callback(
    Output("grafico_fasori","figure"),
    Output("grafico_corrente","figure"),
    [Input(f"amp_{i}","value") for i in range(n_fasori)] +
    [Input(f"fase_{i}","value") for i in range(n_fasori)]
)

def aggiorna(*vals):

    amps = vals[:n_fasori]
    fasi = vals[n_fasori:]

    return genera_figure(amps,fasi)


if __name__ == "__main__":
    app.run(debug=True)