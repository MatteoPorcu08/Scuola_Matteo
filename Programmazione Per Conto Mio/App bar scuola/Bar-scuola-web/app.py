from flask import Flask, render_template, request , redirect , url_for 
from data.menu import menu
from data.ordini import aggiungi_ordine, mostra_ordini, svuota_ordini

app = Flask(__name__)

# Per andare alla homepage (studenti)

@app.route("/")
def index():
    return render_template("index.html", menu=menu)

# Per aggiungere un ordine
@app.route("/ordina", methods=["POST"])
def ordina():
    prodotto = request.form.get("prodotto")
    quantita = int(request.form.get("quantita")) #converte quantita in numero intero
    if prodotto and quantita > 0:
        aggiungi_ordine(prodotto , quantita)
    return redirect(url_for("index"))

# Rotta per il personale
@app.route("/personale")
def personale():
    ordini = mostra_ordini()
    return render_template("personale.html", ordini=ordini)

# Rotta per svuotare gli ordini
@app.route('/svuota', methods=["POST"])
def svuota():
    svuota_ordini()
    return redirect(url_for("personale"))

if __name__ == "__main__":
    app.run(debug=True)