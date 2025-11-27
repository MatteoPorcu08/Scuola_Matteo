function aggiungi() {
    let input = document.getElementById("input").value;
    document.getElementById("lista").innerHTML =
        document.getElementById("lista").innerHTML + "<br>-" + input;
    document.getElementById("input").value = "";
}