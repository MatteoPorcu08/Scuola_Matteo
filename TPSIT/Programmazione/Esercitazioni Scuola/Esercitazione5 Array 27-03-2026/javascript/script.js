let clienti = [];
let corsi = [];
function aggiungiPrenotazione() {
    let nomeCliente = document.getElementById("nomeCliente").value;
    let nomeCorso = document.getElementById("nomeCorso").value;
    
    if (nomeCliente === "" || nomeCorso === "") {
        alert("Errore: Il nome del cliente e del corso non possono essere vuoti.");
        return;
    }else{
        let risultato = ricercaPrenotazione(nomeCliente);
        if (risultato == -1) {
            clienti[i]= nomeCliente;
            corsi[i]= nomeCorso;
            i++;
            alert("Prenotazione aggiunta: " + nomeCliente + " - " + nomeCorso);
        } else {
            alert("Cliente già prenotato.");
        }
    }
}

// Funzione per cercare l'indice di una prenotazione
function ricercaPrenotazione(chiave) {
    for (let i = 0; i < clienti.length; i++) {
        if (clienti[i] === chiave) {
            return i;
        }
    }
    return -1;
}

// Funzione per cercare una prenotazione
function cercaPrenotazione() {
    let nomeCliente = prompt("Inserisci il nome del cliente da cercare:");
    let risultato = ricercaPrenotazione(nomeCliente);
    if (risultato == -1) {
        alert("Cliente non trovato.");
    } else {
        alert("Cliente trovato: " + clienti[risultato] + " - " + corsi[risultato]);
    }
}

// Funzione per eliminare una prenotazione
function eliminaPrenotazione() {
    let nomeCliente = prompt("Inserisci il nome del cliente da eliminare:");
    let risultato = ricercaPrenotazione(nomeCliente);
    if (risultato == -1) {
        alert("Cliente non trovato.");
    } else {
        clienti.splice(risultato, 1);
        corsi.splice(risultato, 1);
        alert("Prenotazione eliminata: " + nomeCliente);
    }
}

// Funzione per visualizzare tutte le prenotazioni
function visualizzaPrenotazioni() {
    let prenotazioni = document.getElementById("prenotazioni");
    
    for (let i = 0; i < clienti.length; i++) {
        let prenotazione = document.createElement("li");
        prenotazione.textContent = clienti[i] + " - " + corsi[i];
        prenotazioni.appendChild(prenotazione);
    }
}