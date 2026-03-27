// Array vuoti per i prodotti
let nomi = [];
let prezzi = [];
let quantita = [];
let i = 0;  // Contatore per la posizione negli array

// Funzione 1: Aggiungi prodotto
function aggiungiProdotto() {
    let nome = prompt("Inserisci il nome del prodotto:");
    let prezzo = prompt("Inserisci il prezzo del prodotto:");
    let qta = prompt("Inserisci la quantità disponibile:");

    if (nome != "" && prezzo != "" && qta != "") {
        nomi[i] = nome;
        prezzi[i] = prezzo;
        quantita[i] = qta;
        i++;

        alert("Prodotto inserito con successo!");
    } else {
        alert("Inserisci tutti i dati del prodotto!");
    }
}

// Funzione 2: Visualizza prodotti
function visualizzaProdotti() {
    document.getElementById("dati").innerHTML = "";
    let output = document.getElementById("output");

    if (nomi.length == 0) {
        output.innerHTML = "Nessun prodotto in magazzino.";
        return;
    }

    let testo = "<h3>Elenco Prodotti:</h3>";

    for (let j = 0; j < nomi.length; j++) {
        let valoreTotale = prezzi[j] * quantita[j];
        testo = testo + (j + 1) + ". " + nomi[j] + " - Prezzo: €" + prezzi[j] + " - Quantità: " + quantita[j] + " - Valore totale: €" + valoreTotale + "<br>";
    }

    output.innerHTML = testo;
}

// Funzione 3: Cerca prodotto
function cercaProdotto() {
    let ricerca = prompt("Inserisci il nome del prodotto da cercare:");
    let trovato = false;
    let posizione = -1;

    for (let j = 0; j < nomi.length; j++) {
        if (nomi[j] == ricerca) {
            trovato = true;
            posizione = j;
        }
    }

    if (trovato == true) {
        let valoreTotale = prezzi[posizione] * quantita[posizione];
        let output = document.getElementById("output");
        output.innerHTML = "<h3>Prodotto trovato:</h3>" +
            "Nome: " + nomi[posizione] + "<br>" +
            "Prezzo: €" + prezzi[posizione] + "<br>" +
            "Quantità: " + quantita[posizione] + "<br>" +
            "Valore totale: €" + valoreTotale;
    } else {
        alert("Prodotto non trovato!");
    }
}

// Funzione 4: Calcola valore totale magazzino
function calcolaValoreTotale() {
    let totale = 0;

    for (let j = 0; j < nomi.length; j++) {
        totale = totale + (prezzi[j] * quantita[j]);
    }

    alert("Valore totale magazzino: €" + totale);

    let output = document.getElementById("output");
    innerHTML = "<h3>Valore totale magazzino: €" + totale + "</h3>";
}

// Funzione 5: Rimuovi prodotto
function rimuoviElemento() {
    let ricerca = prompt("Inserisci il nome del prodotto da rimuovere:"); // Chiedi all'utente il nome del prodotto da rimuovere
    let trovato = false; // Variabile per tenere traccia se il prodotto è stato trovato
    let posizione = -1; // Variabile per memorizzare la posizione del prodotto negli array
    for (let j = 0; j < nomi.length; j++) { // Ciclo per cercare il prodotto negli array
        if (nomi[j] == ricerca) { // Se il nome del prodotto corrisponde a quello cercato
            trovato = true; // Imposta trovato a true
            posizione = j; // Memorizza la posizione del prodotto negli array
        }
    }

    if (trovato == true) { // Se il prodotto è stato trovato, rimuovilo dagli array
        nomi.splice(posizione, 1); // Rimuove il prodotto dall'array nomi alla posizione trovata
        prezzi.splice(posizione, 1); // Rimuove il prodotto dall'array prezzi alla posizione trovata
        quantita.splice(posizione, 1); // Rimuove il prodotto dall'array quantita alla posizione trovata
        alert("Prodotto rimosso con successo!"); // Mostra un messaggio di conferma
    } else { // Se il prodotto non è stato trovato, mostra un messaggio di errore
        alert("Prodotto non trovato!"); // Mostra un messaggio di errore se il prodotto non è stato trovato
    }
}