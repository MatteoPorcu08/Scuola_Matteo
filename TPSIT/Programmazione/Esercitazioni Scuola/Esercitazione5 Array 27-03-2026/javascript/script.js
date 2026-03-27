let clienti = [];
let corsi = [];
function aggiungiPrenotazione() {
    let nomeCliente = document.getElementById("nomeCliente").value;
    let nomeCorso = document.getElementById("nomeCorso").value;
    
    if (nomeCliente === "" || nomeCorso === "") {
        alert("Errore: Il nome del cliente e del corso non possono essere vuoti.");
        return;
    }
    if (clienti[](nomeCliente)) {
        alert("Cliente già prenotato.");
        return;
    }
    
    clienti[i]= nomeCliente;
    corsi[i]= nomeCorso;
    
    alert("Prenotazione aggiunta correttamente.");
    
    document.getElementById("nomeCliente").value = "";
    document.getElementById("nomeCorso").value = "";
}

function ricercaPrenotazione(chiave) {
    for (let i = 0; i < clienti.length; i++) {
        if (clienti[i] === chiave) {
            return i;
        }
    }
    return -1;
}

function cercaPrenotazione() {
    let nomeCliente = prompt("Inserisci il nome del cliente da cercare:");
    let risultato = ricercaPrenotazione(nomeCliente);


function eliminaPrenotazione() {
    let nomeCliente = prompt("Inserisci il nome del cliente da eliminare:");
    
    let index = clienti.indexOf(nomeCliente);
    
    if (index !== -1) {
        let conferma = prompt("Sei sicuro di voler eliminare la prenotazione di " + nomeCliente + "? (S/N)");
        
        if (conferma.toUpperCase() === "S") {
            clienti.splice(index, 1);
            corsi.splice(index, 1);
            alert("Prenotazione eliminata.");
        }
    } else {
        alert("Cliente non trovato.");
    }
}

function visualizzaPrenotazioni() {
    let prenotazioni = document.getElementById("prenotazioni");
    
    if (clienti.length === 0) {
        prenotazioni.innerHTML = "Nessuna prenotazione presente.";
    } else {
        prenotazioni.innerHTML = "";
        for (let i = 0; i < clienti.length; i++) {
            prenotazioni.innerHTML += clienti[i] + " - " + corsi[i] + "<br>";
        }
    }
}
