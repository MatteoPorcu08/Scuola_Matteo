let totale = 0;
let totaleOriginale = 0;
function aggiungiPiatto() {
    let nome = document.getElementById("nomePiatto").value;
    let categoria = document.getElementById("categoria").value;
    let prezzo = document.getElementById("prezzoPiatto").value * 1;

    if (nome == "" || categoria == "" || prezzo <= 0) {
        alert("I dati non sono inseriti correttamente!");
    } else {
        document.getElementById("menuDelGiorno").innerHTML +=
            "<tr><td>" + prezzo + "EUR " + nome + " - " + categoria + "</td></tr>";

        totale += prezzo;
        totaleOriginale = totale;

        document.getElementById("totale").innerHTML = totale.toFixed(2);
        document.getElementById("scontoProposto").innerHTML = "0.00%";

        alert("Piatto aggiunto al menu!");

        document.getElementById("nomePiatto").value = "";
        document.getElementById("categoria").value = "";
        document.getElementById("prezzoPiatto").value = "";

    }
}

function svuotaMenu() {
    if (document.getElementById("menuDelGiorno").innerHTML == "") {
        alert("Il menu è già vuoto!");
    }
    else {
        document.getElementById("menuDelGiorno").innerHTML = "";
        totale = 0;
        totaleOriginale = 0;

        document.getElementById("totale").innerHTML = "0.00";
        document.getElementById("scontoProposto").innerHTML = "0.00%";

        alert("Menu svuotato correttamente!");
    }
}

function proponiSconto() {
    if (document.getElementById("menuDelGiorno").innerHTML == "") {
        alert("Impossibile applicare sconto");
    } else {
        let sconto;
        do {
            sconto = prompt("Inserisci lo sconto (max 100):") * 1;
            if (sconto > 100) {
                alert("Lo sconto non può superare il 100%");
            }
        } while (sconto > 100);

        totale = totaleOriginale - (totaleOriginale * sconto / 100);
        document.getElementById("totale").innerHTML = totale.toFixed(2);
        document.getElementById("scontoProposto").innerHTML = sconto + "%";
    }
}

function annullaSconto() {
    if (document.getElementById("menuDelGiorno").innerHTML == "") {
        alert("Il menu è vuoto, impossibile annullare lo sconto");
    } else {
        totale = totaleOriginale;
        document.getElementById("totale").innerHTML = totale.toFixed(2);
        document.getElementById("scontoProposto").innerHTML = "0.00%";
        alert("Sconto annullato");
    }
}