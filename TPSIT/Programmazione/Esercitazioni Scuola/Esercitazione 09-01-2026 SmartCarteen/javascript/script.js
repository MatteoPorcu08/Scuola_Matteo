function aggiungiPiatto() {
    const nome = document.getElementById("nomePiatto").value;
    const categoria = document.getElementById("categoria").value;
    const prezzo = parseFloat(document.getElementById("prezzoPiatto").value);

    if (nome && categoria && !isNaN(prezzo)) {
        // Aggiungi il piatto al menu del giorno
        const menuElement = document.getElementById("menuDelGiorno");
        menuElement.innerHTML += `<p>${nome} - ${categoria} - €${prezzo.toFixed(2)}</p>`;

        // Aggiorna il totale
        aggiornaTotale(prezzo);

        // Pulisci i campi
        document.getElementById("nomePiatto").value = "";
        document.getElementById("categoria").value = "";
        document.getElementById("prezzoPiatto").value = "";
    } else {
        alert("Inserisci tutti i dati correttamente.");
    }
}

function svuotaMenu() {
    const menuElement = document.getElementById("menuDelGiorno");
    menuElement.innerHTML = "";
    document.getElementById("totale").textContent = "0.00";
}

function proponiSconto() {
    const totale = parseFloat(document.getElementById("totale").textContent);
    if (totale > 0) {
        const scontoProposto = totale * 0.1; // 10% di sconto
        document.getElementById("scontoProposto").textContent = "10%";
        document.getElementById("totale").textContent = (totale - scontoProposto).toFixed(2);
    }
}

function annullaSconto() {
    const scontoProposto = parseFloat(document.getElementById("scontoProposto").textContent);
    if (scontoProposto > 0) {
        const totaleConSconto = parseFloat(document.getElementById("totale").textContent);
        const totaleOriginale = totaleConSconto + (totaleConSconto * 0.1); // Riporta al totale originale
        document.getElementById("scontoProposto").textContent = "0.00%";
        document.getElementById("totale").textContent = totaleOriginale.toFixed(2);
    }
}

function aggiornaTotale(prezzo) {
    const totaleElemento = document.getElementById("totale");
    let totaleCorrente = parseFloat(totaleElemento.textContent);

    if (isNaN(totaleCorrente)) {
        totaleCorrente = 0;
    }

    totaleElemento.textContent = (totaleCorrente + prezzo).toFixed(2);
}