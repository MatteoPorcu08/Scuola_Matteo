let totale = 0;

function aggiungiCorso() {
    let corso = document.getElementById("nomecorso").value;
    let istruttore = document.getElementById("nomeistruttore").value;

    document.getElementById("messaggio").innerHTML = "";

    if (corso === "" || istruttore === "") return;

    document.getElementById("tabella").innerHTML +=
        "<tr><td>" + corso + "</td><td>" + istruttore + "</td></tr>";

    document.getElementById("messaggio").innerHTML =
        "Corso aggiunto correttamente!";

    document.getElementById("nomecorso").value = "";
    document.getElementById("nomeistruttore").value = "";
}

function elimina() {
    document.getElementById("messaggio").innerHTML = "";

    if (document.getElementById("tabella").innerHTML == "") {
        alert("Non ci sono corsi da eliminare!");
    } else {
        document.getElementById("tabella").innerHTML = "";
        alert("Corsi eliminati!");
    }
}

function aggiungiCosti() {
    let corso;
    let prezzo;

    if (totale > 700) {
        alert("Errore: il totale ha già superato 700 EUR");
        return;
    }

    corso = prompt("Inserisci il nome del corso:");
    if (corso === null) return;

    do {
        prezzo = prompt("Inserisci il prezzo del corso:");
        if (prezzo === null) return;

        prezzo = prezzo * 1;

        if (prezzo <= 0) {
            alert("Errore! Il prezzo deve essere maggiore di 0");
        }
    } while (prezzo <= 0);

    if (totale + prezzo > 700) {
        alert("Attenzione: il totale supererà 700 EUR");
    }

    document.getElementById("prezzo").innerHTML +=
        "<br>" + corso + ": " + prezzo + " EUR";

    totale += prezzo;
    document.getElementById("totaleinclusiva").innerHTML = totale;
}