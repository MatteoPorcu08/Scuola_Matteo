function verifica() {
    let password = document.getElementById('pass').value;
    let codice = document.getElementById('cod').value;

    if (password == "admin" && codice == "0000") {
    alert("Accesso speciale");
    }
    else if (password == "admin" && codice != "0000") {
    alert("Codice errato");
    }
    if (password != "admin") {
    alert("Accesso negato");
    }
}

