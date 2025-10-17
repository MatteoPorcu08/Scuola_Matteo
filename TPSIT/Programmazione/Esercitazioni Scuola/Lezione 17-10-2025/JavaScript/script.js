function verifica() {
    let password = prompt("Inserisci la password:");
    let codice = prompt("Inserisci il codice segreto:");

    if (password == "admin" && codice == "0000") {
    alert("Accesso speciale");
    }
    if (password == "admin" && codice != "0000") {
    alert("Codice errato");
    }
    if (password != "admin") {
    alert("Accesso negato");
    }
}

