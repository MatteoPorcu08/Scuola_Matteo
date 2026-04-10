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
    let libro = document.getElementById("titolo").value;
    let risultatoControllo = ricercaElemento(libro);
    
    if (risultatoControllo != -1) {
        alert("Il libro " + titoloLibro[risultatoControllo] + " è in prestito a " + nomeUtente[risultatoControllo] + " per " + giorniPrestito[risultatoControllo] + " giorni");
    } else {
        alert("Il libro non è in prestito");
    }
    document.getElementById("titoloControllo").value = "";
}