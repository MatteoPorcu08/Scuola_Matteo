let utenti = [];      // Array per gli username
let password = [];   // Array per le password
let i = 0;

function registra() {
    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;

    if (user != "" && pass != "") {
        utenti[i] = user;
        password[i] = pass;
        i++;

        document.getElementById("messaggio").innerHTML = "Registrazione avvenuta con successo";
    } else {
        document.getElementById("messaggio").innerHTML = "Inserisci username e password";
    }

    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
}

function autentica() {
    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;
    let trovato = false;

    for (let j = 0; j < utenti.length; j++) {
        if (utenti[j] == user && password[j] == pass) {
            trovato = true;
        }
    }

    if (trovato) {
        document.getElementById("messaggio").innerHTML = "Autenticazione riuscita";
    } else {
        document.getElementById("messaggio").innerHTML = "Username o password non corretti";
    }
}