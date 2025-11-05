function prenotaFilm() {
// Fase 1: Selezione del Film
let prezzoUnitario = 0;
let nomeFilm = "";

do {
    let film = prompt(
        "Ciao! Scegli un film digitando:\n" +
        "1) Film 1 (10€)\n" +
        "2) Film 2 (12€)\n" +
        "3) Film 3 (15€)"
    );
    if (film === null) return; // uscita se annulla
    film = film.trim();

    switch (film) {
        case "1":
            prezzoUnitario = 10;
            nomeFilm = "Film 1";
            break;
        case "2":
            prezzoUnitario = 12;
            nomeFilm = "Film 2";
            break;
        case "3":
            prezzoUnitario = 15;
            nomeFilm = "Film 3";
            break;
        default:
            alert("Film non disponibile!");
            prezzoUnitario = 0;
            break;
    }
} while (prezzoUnitario === 0);

// Fase 2: Selezione della Fascia Oraria
let nomeFascia = "";

do {
    let fascia = prompt(
        "Scegli una fascia oraria:\n" +
        "1) Mattina (9:00-12:00)\n" +
        "2) Pomeriggio (12:30-16:00)\n" +
        "3) Sera (16:30-23:00)"
    );
    if (fascia === null) return; // uscita se annulla
    fascia = fascia.trim();

    switch (fascia) {
        case "1":
            nomeFascia = "Mattina";
            break;
        case "2":
            nomeFascia = "Pomeriggio";
            break;
        case "3":
            nomeFascia = "Sera";
            break;
        default:
            alert("Fascia oraria non disponibile!");
            nomeFascia = "";
            break;
    }
} while (nomeFascia === "");

// Fase 3: Quantità di Biglietti
let quantita = 0;

do {
    let inputQuantita = prompt("Quanti biglietti vuoi acquistare? (1-50)");
    if (inputQuantita === null) return; // uscita se annulla
    quantita = parseInt(inputQuantita.trim(), 10);

    if (isNaN(quantita) || quantita < 1 || quantita > 50) {
        alert("Errore nella quantità dei biglietti!");
        quantita = 0;
    }
} while (quantita === 0);

// Calcolo totale base
let totale = prezzoUnitario * quantita;

// Sconto in base alla quantità
let totaleCorrente = totale;

if (quantita > 4) {
    totaleCorrente = totale * 0.90;
} else {
    if (quantita === 1) {
        totaleCorrente = totale * 0.95;
    } else {
        totaleCorrente = totale;
    }
}

alert("Dovrai pagare " + totaleCorrente.toFixed(2) + " euro");

// Fase 4: Sconto per Età
let etaInput = prompt("Inserisci la tua età per verificare eventuali sconti età:");
if (etaInput === null) return;
let eta = parseInt(etaInput.trim(), 10);

if (!isNaN(eta)) {
    let scontoEtaApplicato = false;
    let totaleDopoEta = totaleCorrente;

    if (eta <= 12 || eta >= 65) {
        totaleDopoEta = totaleCorrente * 0.5;
        scontoEtaApplicato = true;
    } else if (eta >= 12 && eta <= 18) {
            totaleDopoEta = totaleCorrente * 0.8;
            scontoEtaApplicato = true;
    }

    if (scontoEtaApplicato) {
        alert("Sconto età applicato: il nuovo importo da pagare è " + totaleDopoEta.toFixed(2) + " euro");
        totaleCorrente = totaleDopoEta;
    } else {
        alert("Nessuno sconto età applicato");
    }
    } else {
    alert("Età non valida: nessuno sconto età applicato");
}

// Fase 5: Sconto Fascia Mattina + almeno 10 biglietti
if (nomeFascia === "Mattina" && quantita >= 10) {
    let nuovoTotale = Math.max(0, totaleCorrente - 20);
    alert("Ti informiamo che hai ricevuto un ulteriore sconto di 20EUR sul totale.\nIl nuovo importo da pagare sarà quindi " + nuovoTotale.toFixed(2) + " EUR");
    totaleCorrente = nuovoTotale;
}
}