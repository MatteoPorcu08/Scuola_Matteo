let nomi = []; // Array vuoto per i nomi
function aggiungiNome() {
    let nomeInput = document.getElementById("nome");
    document.getElementById("nome").value = "";
    let nome = nomeInput.value;
    nome[i] = nome; // Aggiunge il nome all'array
    i++; // Incrementa l'indice per il prossimo inserimento
}

function mostraNomi() {
    let elencoNomi = document.getElementById("elencoNomi");
    elencoNomi.innerHTML = ""; // Pulisce il contenuto precedente
    for (let j = 0; j < nomi.length; j++) { // Cicla attraverso l'array
        elencoNomi.innerHTML += nomi[j] + "<br>"; // Aggiunge ogni nome all'elemento HTML
    }
}
