let titoloLibro = [];
let nomeUtente = [];
let giorniPrestito = [];

let i = 0;

function registraPrestito() {
    let libro = document.getElementById("libro").value;
    let nome = document.getElementById("nome").value;
    let giorni = document.getElementById("giorni").value;

    titoloLibro[i] = libro;
    nomeUtente[i] = nome;
    giorniPrestito[i] = giorni;

    i++;

    alert("Elemento inserito correttamente");

    //Controllo se 
}