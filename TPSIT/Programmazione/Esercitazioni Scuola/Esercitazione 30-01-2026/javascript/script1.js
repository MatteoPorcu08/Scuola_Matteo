let i = 5; // Indice per l'inserimento del numero inizializato a 0
function salvaNumero() {
    let numero = document.getElementById("numeroInput").value;
    document.getElementById("numeroInput").value = "";
    for (let j = 0; j < i; j++) {
        numeroSalvato = numero; // Salva il numero in una variabile
        i++; // Incrementa l'indice per il prossimo inserimento
    }
}

function mostraNumero() {
    let numeroSalvato = localStorage.getItem("numeroSalvato");
    if (numeroSalvato !== null) {
        document.getElementById("numeroVisualizzato").innerHTML = numeroSalvato;
    } else {
        document.getElementById("numeroVisualizzato").innerHTML = "Nessun numero salvato.";
    }
}