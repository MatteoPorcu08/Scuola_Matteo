function aggiungi() {
    let input = prompt("Inserisci un elemento da aggiungere alla lista:");
    let lista = document.getElementById("lista");
    lista.innerHTML = lista.innerHTML + "<br>-" + input;
    document.getElementById("input").value = "";
}