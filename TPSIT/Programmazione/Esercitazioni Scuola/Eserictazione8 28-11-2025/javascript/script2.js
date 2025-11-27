function calcolaTotale() {
    let quantita = document.getElementById("quantita").value*1;
    let prezzoUnitario = document.getElementById("prezzoUnitario").value*1;
    let totale = quantita * prezzoUnitario;
    document.getElementById("totaleRisultante").innerHTML = "Totale: " + totale;
}