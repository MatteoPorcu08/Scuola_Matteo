let studenti = [];
let voti = [];
let i = 0;

// Inserimento studente
function inserisciStudente() {
    let nome = prompt("Inserisci il nome dello studente:");
    let voto = prompt("Inserisci il voto") * 1;

    if (nome && !isNaN(voto)) {
        studenti[i] = nome;
        voti[i] = voto;
        i++;
        alert("Studente inserito correttamente");
    } else {
        alert("Dati non validi");
    }
}

// Visualizzazione registro
function visualizzaRegistro() {
    document.getElementById("dati").innerHTML = "";

    for (let j = 0; j < studenti.length; j++) {
        document.getElementById("dati").innerHTML +=
            j + " - " + studenti[j] + " : " + voti[j] + "<br/>";
    }
}

// Calcolo media
function calcolaMedia() {
    if (voti.length === 0) {
        document.getElementById("messaggio").innerHTML = "Nessun voto";
        return;
    }

    let somma = 0;
    for (let j = 0; j < voti.length; j++) {
        somma += voti[j];
    }

    let media = somma / voti.length;

    document.getElementById("messaggio").innerHTML =
        "Media: " + media.toFixed(2);
}

// Voto più alto
function trovaVotoPiuAlto() {
    if (voti.length === 0) {
        document.getElementById("messaggio").innerHTML = "Nessun voto";
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

    document.getElementById("messaggio").innerHTML =
        "Voto massimo: " + max + " (" + studenti[posizione] + ")";
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
        document.getElementById("messaggio").innerHTML =
            "Nessuna insufficienza";
    } else {
        document.getElementById("messaggio").innerHTML =
            "Insufficienze:<br/>" + risultato;
    }
}

// Ricerca studente (come nell’esempio)
function cercaStudente() {
    let nome = prompt("Chi stai cercando?");
    let posizione = ricerca(nome);

    if (posizione == -1) {
        document.getElementById("messaggio").innerHTML =
            "Studente non trovato";
    } else {
        document.getElementById("messaggio").innerHTML =
            studenti[posizione] + " : " + voti[posizione];
    }
}

function ricerca(nome) {
    for (let j = 0; j < studenti.length; j++) {
        if (studenti[j] == nome) {
            return j;
        }
    }
    return -1;
}