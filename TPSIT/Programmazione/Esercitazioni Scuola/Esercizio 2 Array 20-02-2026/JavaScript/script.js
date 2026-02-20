// Array vuoti per i prodotti
let nomi = [];
let prezzi = [];
let quantita = [];

// Funzione 1: Aggiungi prodotto
function aggiungiProdotto() {
    let nome = prompt("Inserisci il nome del prodotto:");
    let prezzo = prompt("Inserisci il prezzo del prodotto:");
    let qta = prompt("Inserisci la quantità disponibile:");

    // Inseriamo nei tre array
    nomi[nomi.length] = nome;
    prezzi[prezzi.length] = prezzo;
    quantita[quantita.length] = qta;

    alert("Prodotto inserito con successo!");
}

// Funzione 2: Visualizza prodotti
function visualizzaProdotti() {
    let output = document.getElementById("output");

    if (nomi.length == 0) {
        output.innerHTML = "Nessun prodotto in magazzino.";
        return;
    }

    let testo = "<h3>Elenco Prodotti:</h3>";

    for (let i = 0; i < nomi.length; i++) {
        let valoreTotale = prezzi[i] * quantita[i];
        testo += (i + 1) + ". " + nomi[i] + " - Prezzo: €" + prezzi[i] + " - Quantità: " + quantita[i] + " - Valore totale: €" + valoreTotale + "<br>";
    }

    output.innerHTML = testo;
}

// Funzione 3: Cerca prodotto
function cercaProdotto() {
    let ricerca = prompt("Inserisci il nome del prodotto da cercare:");
    let trovato = false;

    for (let i = 0; i < nomi.length; i++) {
        if (nomi[i] === ricerca) {
            let valoreTotale = prezzi[i] * quantita[i];
            let output = document.getElementById("output");
            output.innerHTML = "<h3>Prodotto trovato:</h3>" +
                "Nome: " + nomi[i] + "<br>" +
                "Prezzo: €" + prezzi[i] + "<br>" +
                "Quantità: " + quantita[i] + "<br>" +
                "Valore totale: €" + valoreTotale;
            trovato = true;
            break;
        }
    }

    if (!trovato) {
        alert("Prodotto non trovato!");
    }
}

// Funzione 4: Calcola valore totale magazzino
function calcolaValoreTotale() {
    let totale = 0;

    for (let i = 0; i < nomi.length; i++) {
        totale = totale + (prezzi[i] * quantita[i]);
    }

    alert("Valore totale magazzino: €" + totale);

    let output = document.getElementById("output");
    output.innerHTML = "<h3>Valore totale magazzino: €" + totale + "</h3>";
}