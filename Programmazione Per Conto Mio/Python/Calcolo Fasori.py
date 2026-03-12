import numpy as np
import plotly.graph_objects as go
import dash
from dash import Dash, dcc, html, Input, Output, State

# ----------------------
# PARAMETRI
# ----------------------

omega = 2*np.pi*50
t = np.linspace(0,0.04,1000)

colori = [
"blue","green","orange",
"purple","brown","cyan",
"magenta","yellow"
]

# ----------------------
# FUNZIONI MATEMATICHE
# ----------------------

def crea_fasore(A,fase):

    return A*np.exp(1j*np.deg2rad(fase))


def calcola_operazione(fasori,op):

    if len(fasori)==0:
        return 0

    res = fasori[0]

    for f in fasori[1:]:

        if op=="add":
            res = res + f

        elif op=="sub":
            res = res - f

        elif op=="mul":
            res = res * f

        elif op=="div":
            res = res / f

    return res


def corrente(f):

    A = abs(f)
    phi = np.angle(f)

    return A*np.sin(omega*t + phi)


# ----------------------
# GRAFICI
# ----------------------

def genera_grafici(amps,fasi,op):

    fasori = [crea_fasore(a,p) for a,p in zip(amps,fasi)]

    risultato = calcola_operazione(fasori,op)

    fig_fasori = go.Figure()

    for i,f in enumerate(fasori):

        fig_fasori.add_trace(go.Scatter(
            x=[0,f.real],
            y=[0,f.imag],
            mode="lines+markers+text",
            line=dict(width=4,color=colori[i%len(colori)]),
            text=[None,f"F{i+1}"],
            textposition="top right",
            name=f"F{i+1} | {abs(f):.2f} ∠ {np.angle(f,deg=True):.1f}°"
        ))

    fig_fasori.add_trace(go.Scatter(
        x=[0,risultato.real],
        y=[0,risultato.imag],
        mode="lines+markers+text",
        line=dict(width=5,color="red"),
        text=[None,"Risultato"],
        textposition="top right",
        name=f"Risultato | {abs(risultato):.2f} ∠ {np.angle(risultato,deg=True):.1f}°"
    ))

    fig_fasori.update_layout(
        title="Diagramma Fasoriale",
        xaxis=dict(scaleanchor="y",scaleratio=1,title="Parte Reale"),
        yaxis=dict(title="Parte Immaginaria"),
        height=500
    )

    fig_corrente = go.Figure()

    for i,f in enumerate(fasori):

        fig_corrente.add_trace(go.Scatter(
            x=t,
            y=corrente(f),
            mode="lines",
            line=dict(dash="dash"),
            name=f"F{i+1}"
        ))

    fig_corrente.add_trace(go.Scatter(
        x=t,
        y=corrente(risultato),
        mode="lines",
        line=dict(width=3,color="red"),
        name="Risultato"
    ))

    fig_corrente.update_layout(
        title="Segnale AC nel Tempo",
        xaxis_title="Tempo",
        yaxis_title="Ampiezza",
        height=400
    )

    return fig_fasori,fig_corrente


# ----------------------
# APP DASH
# ----------------------

app = Dash(__name__, suppress_callback_exceptions=True)

app.layout = html.Div([

html.H1("Simulatore Fasori AC"),

html.Label("Numero Fasori"),

dcc.Input(
id="n_fasori",
type="number",
value=3,
min=1,
max=8
),

html.Button("Genera Fasori",id="genera"),

html.Br(),
html.Br(),

html.Label("Operazione"),

dcc.Dropdown(
id="operazione",
options=[
{"label":"Somma","value":"add"},
{"label":"Sottrazione","value":"sub"},
{"label":"Moltiplicazione","value":"mul"},
{"label":"Divisione","value":"div"}
],
value="add"
),

html.Br(),

html.Button("Genera Sistema Trifase",id="trifase"),

html.Hr(),

html.Div(id="sliders"),

dcc.Graph(id="grafico_fasori"),

dcc.Graph(id="grafico_corrente")

])

# ----------------------
# CREAZIONE SLIDER
# ----------------------

@app.callback(

Output("sliders","children"),

Input("genera","n_clicks"),

State("n_fasori","value")

)

def genera_slider(_,n):

    if n is None:
        return []

    sliders=[]

    for i in range(n):

        sliders.append(html.Label(f"Ampiezza Fasore {i+1}"))

        sliders.append(
            dcc.Slider(
            0,10,0.1,
            value=1,
            id={"type":"amp","index":i}
            )
        )

        sliders.append(html.Label(f"Fase Fasore {i+1}"))

        sliders.append(
            dcc.Slider(
            -180,180,1,
            value=0,
            id={"type":"fase","index":i}
            )
        )

    return sliders


# ----------------------
# AGGIORNAMENTO GRAFICI
# ----------------------

@app.callback(

Output("grafico_fasori","figure"),
Output("grafico_corrente","figure"),

Input({"type":"amp","index":dash.ALL},"value"),
Input({"type":"fase","index":dash.ALL},"value"),
Input("operazione","value")

)

def aggiorna(amps,fasi,op):

    if len(amps)==0:
        return go.Figure(),go.Figure()

    return genera_grafici(amps,fasi,op)


# ----------------------

if __name__ == "__main__":

    app.run(debug=True)