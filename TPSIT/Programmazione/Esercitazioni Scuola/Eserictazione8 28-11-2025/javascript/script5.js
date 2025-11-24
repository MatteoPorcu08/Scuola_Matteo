function aggiungi() {
    const input = document.getElementById("input").value;
    const lista = document.getElementById("lista");
    const nuovoElemento = document.getElementById("lista");
    lista.innerHTML += "<br>-" + input.trim();
    document.getElementById("input").value = "";
}