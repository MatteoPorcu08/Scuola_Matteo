let totale = 0;
function aggiungi() {
    let bevanda = document.getElementById("inputbevanda").value;
    let quantita = document.getElementById("inputquantita").value * 1;

    if (quantita > 0) {
        document.getElementById("lista").innerHTML += "<br>-" + bevanda + " x " + quantita;
        document.getElementById("inputbevanda").value = "";
    } else {
        alert("Errore! Inserire un numero positivo.");
        return;
    }

    const prezzo = 1.20;
    let prezzoBevanda = quantita * prezzo;
    totale += prezzoBevanda;
    document.getElementById("prezzo").innerHTML = "Totale: " + totale + " Eur";
}

function conferma(){
    let conferma=prompt("Vuoi confermare l’ordine? (s/n)");
    if (conferma== "s" ){
        alert("Il numero dei prodotto selezionati e:"+quantita+
            "Il prezzo totale e:"+totale
        )
    } else if(conferma == "n"){
        alert("Ordine Anullato!");
    }

    //reset
    document.getElementById("lista").innerHTML
}