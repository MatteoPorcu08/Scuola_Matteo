function aggiungi() {
    let bevanda = document.getElementById("inputbevanda").value;
    let quantita = Number(document.getElementById("inputquantita").value);

    if (quantita > 0) {
        document.getElementById("lista").innerHTML += "<br> - " + quantita + "x " + bevanda;
        document.getElementById("inputbevanda").value = "";
        document.getElementById("inputquantita").value = "";
    } else {
        alert("Errore! Inserire un numero positivo.");
    }
}
