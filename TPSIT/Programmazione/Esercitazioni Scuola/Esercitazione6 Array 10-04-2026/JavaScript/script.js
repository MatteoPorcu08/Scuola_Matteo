let titoloLibro = [];
let nomeUtente = [];
let giorniPrestito = [];

let i = 0;

function registraPrestito() {
    let libro = document.getElementById("libro");
    let nome = document.getElementById("utente");
    let giorni = document.getElementById("giorni") * 1;
    let risultatoControllo = ricercaElemento(libro);

    if (risultatoControllo != -1) {
        alert("Il libro è già stato prestato");
    } else {
    titoloLibro[i] = libro;
    nomeUtente[i] = nome;
    giorniPrestito[i] = giorni;


    i++;

    alert("Elemento inserito correttamente");

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