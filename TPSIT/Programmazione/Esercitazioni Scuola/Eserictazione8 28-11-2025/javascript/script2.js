function calcolaTotale() {
    let quantita = document.getElementById("quantita").value;
    let prezzoUnitario = document.getElementById("prezzoUnitario").value;
    let totale = quantita * prezzoUnitario;
    document.getElementById("totaleRisultante").innerHTML = "Totale: " + totale;
}