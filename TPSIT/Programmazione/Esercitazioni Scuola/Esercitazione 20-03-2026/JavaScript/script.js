// Array per nomi e voti
let studenti = [];
let voti = [];
let i = 0;

// Inserimento studente
function inserisciStudente() {
    let nome = prompt("Inserisci il nome dello studente:");
    let voto = prompt("Inserisci il voto:") * 1;

    if (nome && !isNaN(voto)) {
        studenti[i] = nome;
        voti[i] = voto;
        i++;
        alert("Studente inserito con successo!");
    } else {
        alert("Dati non validi.");
    }
}

// Visualizzazione registro
function visualizzaRegistro() {
    document.getElementById("dati").innerHTML = "";

    for (let j = 0; j < studenti.length; j++) {
        alert("Studente: " + studenti[j] + " - Voto: " + voti[j]);
    }
}

// Calcolo media
function calcolaMedia() {
    if (voti.length === 0) {
        alert("Nessun voto inserito.");
        return;
    }

    let somma = 0;
    for (let j = 0; j < voti.length; j++) {
        somma += voti[j];
    }

    let media = somma / voti.length;

    alert("Media della classe: " + media.toFixed(2));
}

// Voto più alto
function trovaVotoPiuAlto() {
    if (voti.length === 0) {
        alert("Nessun voto inserito.");
        return;
    }

    let max = voti[0];
    let posizione = 0;

    for (let j = 1; j < voti.length; j++) {
        if (voti[j] > max) {
            max = voti[j];
            posizione = j;
        }
    }

    alert("Voto più alto: " + max + " (Studente: " + studenti[posizione] + ")");
}

// Insufficienze
function trovaInsufficienze() {
    let risultato = "";

    for (let j = 0; j < voti.length; j++) {
        if (voti[j] < 6) {
            risultato += studenti[j] + " : " + voti[j] + "<br/>";
        }
    }

    if (risultato === "") {
        alert("Nessuna insufficienza");
    } else {
        document.getElementById("dati").innerHTML = risultato;
    }
}