let titoloLibro = [];
let nomeUtente = [];
let giorniPrestito = [];

let i = 0;

function registraPrestito() {
    let libro = document.getElementById("titolo").value;
    let nome = document.getElementById("utente").value;
    let giorni = document.getElementById("giorni").value * 1;
    let risultatoControllo = ricercaElemento(libro);

    if (risultatoControllo != -1) {
        alert("Libro gia in prestito");
        document.getElementById("titolo").value = "";
        document.getElementById("utente").value = "";
        document.getElementById("giorni").value = "";
    } else {
    titoloLibro[i] = libro;
    nomeUtente[i] = nome;
    giorniPrestito[i] = giorni;

    i++;

    alert("Prestito registrato correttamente");

    document.getElementById("titolo").value = "";
    document.getElementById("utente").value = "";
    document.getElementById("giorni").value = "";

    }
}

function ricercaElemento(valore) {
    for (let j = 0; j < titoloLibro.length; j++) {
        if (titoloLibro[j] == valore) {
            return j;
        }
    }
    return -1;
}

function controllaPrestito() {
    let libro = prompt("Inserisci il titolo del libro da controllare");
    let risultatoControllo = ricercaElemento(libro);

    if (risultatoControllo != -1) {
        alert("Il libro è in prestito a " + nomeUtente[risultatoControllo] + " per " + giorniPrestito[risultatoControllo] + " giorni");
    } else {
        alert("Libro non presente");
    }
}

function restituisciLibro() {
    let libro = prompt("Inserisci il titolo del libro da restituire");
    let risultatoControllo = ricercaElemento(libro);

    if (risultatoControllo != -1) {
        for (let j = risultatoControllo; j < titoloLibro.length - 1; j++) {
            titoloLibro[j] = titoloLibro[j + 1];
            nomeUtente[j] = nomeUtente[j + 1];
            giorniPrestito[j] = giorniPrestito[j + 1];
        }
        titoloLibro.pop();
        nomeUtente.pop();
        giorniPrestito.pop();

        alert("Libro restituito correttamente");
    } else {
        alert("Libro non presente");
    }
}

function elencoPrestiti() {
    let elenco = "";
    for (let j = 0; j < titoloLibro.length; j++) {
        elenco += "Elenco Libri:\n  Libro: " + titoloLibro[j] + " - Utente: " + nomeUtente[j] + " - Giorni: " + giorniPrestito[j] + "\n";
    }
    document.getElementById("output").innerText = elenco;
}