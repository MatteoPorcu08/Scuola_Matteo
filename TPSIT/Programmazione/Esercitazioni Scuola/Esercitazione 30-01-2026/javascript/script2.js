let elencoNomi = []; // Array vuoto
let i = 0; // Indice per l'inserimento degli alimenti inizializato a 0
function aggiungiNome() {
    let nome = document.getElementById("nome").value;
    document.getElementById("nome").value = "";
    elencoNomi[i] = nome; // Aggiunge il nome all'array
    i++; // Incrementa l'indice per il prossimo inserimento
}

function mostraNomi() {
    document.getElementById("elencoNomi").innerHTML = ""; // Pulisce il contenuto precedente
    for (let j = 0; j < elencoNomi.length; j++) { // Cicla attraverso l'array
        document.getElementById("elencoNomi").innerHTML += elencoNomi[j] + "<br>"; // Aggiunge ogni nome all'elemento HTML
    }
}