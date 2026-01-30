let carrello = []; // Array vuoto
let i = 0; // Indice per l'inserimento degli alimenti inizializato a 0
function aggiungi() {
    let alimento = document.getElementById("alimento").value;
    document.getElementById("alimento").value = "";
    carrello[i] = alimento; // Aggiunge l'alimento all'array
    i++; // Incrementa l'indice per il prossimo inserimento
}

function aggiornaCarrello() {
    document.getElementById("carrello").innerHTML = ""; // Pulisce il contenuto precedente
    for (let j = 0; j < carrello.length; j++) { // Cicla attraverso l'array
        document.getElementById("carrello").innerHTML += carrello[j] + "<br>"; // Aggiunge ogni alimento all'elemento HTML
    }
}