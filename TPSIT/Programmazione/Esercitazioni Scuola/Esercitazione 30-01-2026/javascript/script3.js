let elencoPrezzi = []; // Array vuoto
let i = 0; // Indice per l'inserimento degli alimenti inizializato a 0
function salvaPrezzo() {
    let numero = document.getElementById("numero").value * 1; // Prende il valore dall'input e lo converte in numero
    document.getElementById("numero").value = "";
    elencoPrezzi[i] = numero; // Aggiunge il prezzo all'array
    i++; // Incrementa l'indice per il prossimo inserimento
}

function mostraPrezzo() {
    document.getElementById("elencoPrezzi").innerHTML = ""; // Pulisce il contenuto precedente
    for (let j = 0; j < elencoPrezzi.length; j++) { // Cicla attraverso l'array
        document.getElementById("elencoPrezzi").innerHTML += "€" + elencoPrezzi[j] + "<br>"; // Aggiunge ogni prezzo all'elemento HTML
    }
}
