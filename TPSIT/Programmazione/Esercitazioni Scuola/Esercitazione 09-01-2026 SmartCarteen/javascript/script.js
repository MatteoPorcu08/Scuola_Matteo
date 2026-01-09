let totale = 0;
let totaleOriginale = 0;
let menuVuoto = true;

// Aggiunge un piatto al menu del giorno
function aggiungiPiatto() {
    let nome = document.getElementById("nomePiatto").value;
    let categoria = document.getElementById("categoria").value;
    let prezzo = document.getElementById("prezzoPiatto").value * 1;

    if (nome == "" || categoria == "" || prezzo <= 0) {
        alert("Inserisci tutti i dati correttamente.");
    } else {
        document.getElementById("menuDelGiorno").innerHTML +=
            "<br>" + prezzo + "EUR " + nome + " - " + categoria;

        totale += prezzo;
        totaleOriginale = totale;

        document.getElementById("totale").innerHTML = totale.toFixed(2);
        document.getElementById("scontoProposto").innerHTML = "0.00%";

        alert("Piatto aggiunto al menu!");

        document.getElementById("nomePiatto").value = "";
        document.getElementById("categoria").value = "";
        document.getElementById("prezzoPiatto").value = "";

        menuVuoto = false;
    }
}

// Svuota il menu del giorno
function svuotaMenu() {
    document.getElementById("menuDelGiorno").innerHTML = "";
    totale = 0;
    totaleOriginale = 0;
    menuVuoto = true;

    document.getElementById("totale").innerHTML = "0.00";
    document.getElementById("scontoProposto").innerHTML = "0.00%";

    alert("Menu svuotato correttamente!");
}

// Propone uno sconto sul totale del menu
function proponiSconto() {
    if (menuVuoto) {
        alert("Impossibile applicare sconto");
    } else {
        let sconto;
        do {
            sconto = prompt("Inserisci lo sconto (max 100):") * 1;
            if (sconto > 100) {
                alert("Lo sconto non può essere maggiore di 100%");
            }
        } while (sconto > 100);

        totale = totaleOriginale - (totaleOriginale * sconto / 100);
        document.getElementById("totale").innerHTML = totale.toFixed(2);
        document.getElementById("scontoProposto").innerHTML = sconto + "%";
    }
}

// Annulla lo sconto applicato
function annullaSconto() {
    if (menuVuoto) {
        alert("Il menu è già vuoto!");
    } else {
        totale = totaleOriginale;
        document.getElementById("totale").innerHTML = totale.toFixed(2);
        document.getElementById("scontoProposto").innerHTML = "0.00%";
        alert("Sconto annullato");
    }
}