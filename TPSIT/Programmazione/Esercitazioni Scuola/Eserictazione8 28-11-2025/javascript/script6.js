function aggiungi() {
    input = prompt("Inserisci un elemento da aggiungere alla lista:") || "";
    const lista = document.getElementById("lista");
    lista.innerHTML += "<br>-" + input.trim();
    document.getElementById("input").value = "";
}