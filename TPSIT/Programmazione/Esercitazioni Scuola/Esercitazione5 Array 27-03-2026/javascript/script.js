let clienti = [];
let corsi = [];

// funzione di ricerca vera
function trovaCliente(nome) {
    for (let i = 0; i < clienti.length; i++) {
        if (clienti[i] === nome) {
            return i;
        }
    }
    return -1;
}

function aggiungiPrenotazione() {
    let nomeCliente = prompt("Inserisci il nome del cliente:");
    let nomeCorso = prompt("Inserisci il nome del corso:");

    if (nomeCliente === "" || nomeCorso === "") {
        alert("Errore: campi vuoti");
        return;
    }

    let risultato = trovaCliente(nomeCliente);

    if (risultato === -1) {
        clienti.push(nomeCliente);
        corsi.push(nomeCorso);
        alert("Prenotazione aggiunta");
    } else {
        alert("Cliente già prenotato");
    }
}

function ricercaPrenotazione() {
    let nomeCliente = prompt("Nome da cercare:");
    let risultato = trovaCliente(nomeCliente);

    if (risultato === -1) {
        alert("Cliente non trovato");
    } else {
        alert(clienti[risultato] + " - " + corsi[risultato]);
    }
}

function eliminaPrenotazione() {
    let nomeCliente = prompt("Nome da eliminare:");
    let risultato = trovaCliente(nomeCliente);

    if (risultato === -1) {
        alert("Cliente non trovato");
    } else {
        let conferma = prompt("Confermi eliminazione? (S/N)");
        if (conferma.toLowerCase === "S") {
            clienti.splice(risultato, 1);
            corsi.splice(risultato, 1);
            alert("Eliminato");
        }
    }
}

function visualizzaPrenotazioni() {
    let p = document.getElementById("prenotazioni");

    if (clienti.length === 0) {
        p.innerHTML = "Nessuna prenotazione presente";
        return;
    }

    p.innerHTML = "";
    for (let i = 0; i < clienti.length; i++) {
        p.innerHTML += "<li>" + clienti[i] + " - " + corsi[i] + "</li>";
    }
}