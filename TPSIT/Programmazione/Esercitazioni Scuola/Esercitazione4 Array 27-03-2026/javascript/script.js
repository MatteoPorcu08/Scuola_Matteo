// Array
let studenti = [];
let voti = [];
let i = 0;

// Inserisci studente
function inserisciStudente() {
    let nome = prompt("Inserisci nome studente:");
    let voto = prompt("Inserisci voto:") * 1;

    if (nome && voto == voto) {
        studenti[i] = nome;
        voti[i] = voto;
        i++;
        alert("Studente inserito!");
    } else {
        alert("Dati non validi");
    }
}

// Visualizza registro
function visualizzaRegistro() {
    document.getElementById("registro").innerHTML = "";
    let output = "";

    for (let j = 0; j < studenti.length; j++) {
        output += studenti[j] + " : " + voti[j] + "<br>";
    }

    document.getElementById("registro").innerHTML = output;
}

// Calcola media
function calcolaMedia() {
    if (voti.length === 0) {
        alert("Nessun voto");
        return;
    }
    let somma = 0;
    for (let j = 0; j < voti.length; j++) {
        somma += voti[j];
    }
    
    let media = somma / voti.length;

    alert("Media classe: " + media.toFixed(2));

    document.getElementById("mediaClasse").innerHTML = "Media classe: " + media.toFixed(2);
}

// Voto più alto
function trovaVotoPiuAlto() {
    if (voti.length === 0) {
        alert("Nessun voto");
        return;
    }

    let max = voti[0];
    let pos = 0;

    for (let j = 1; j < voti.length; j++) {
        if (voti[j] > max) {
            max = voti[j];
            pos = j;
        }
    }

    alert("Voto più alto: " + max + " - " + studenti[pos]);
}

// Insufficienze (in pagina)
function trovaInsufficienze() {
    let output = "";

    for (let j = 0; j < voti.length; j++) {
        if (voti[j] < 6) {
            output += studenti[j] + " : " + voti[j] + "<br>";
        }
    }

    if (output === "") {
        alert("Nessuna insufficienza");
    } else {
        document.getElementById("insufficienze").innerHTML = output;
    }
}

// Cerca studente
function cercaStudente() {
    let nome = prompt("Inserisci nome studente da cercare:");
    let trovato = false;
    
    for (let j = 0; j < studenti.length; j++) {
        if (studenti[j].toLowerCase() === nome.toLowerCase()) {
            alert("Voto di " + studenti[j] + ": " + voti[j]);
            trovato = true;
            break;
        }
    }
    if (!trovato) {
        alert("Alunno non presente");
    }
}

// Elimina studente
function eliminaStudente() {
    let elementoDaEliminare = prompt("Che studente vuoi eliminare?");
    
    let risultato = ricercaElemento(elementoDaEliminare);

    if (risultato == -1) {
        alert("Alunno non esiste");
    } else {
        // Elimino elemento
        alert("Alunno eliminato correttamente.")
        studenti.splice(risultato, 1);
        voti.splice(risultato, 1);

        visualizzaRegistro();
    }
}