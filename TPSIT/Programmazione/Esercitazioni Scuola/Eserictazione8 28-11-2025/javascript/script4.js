function verificaCampi() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let messaggio = document.getElementById('messaggio');
    
    if (username === '' || password === '') {
        document.getElementById("messaggio").innerText = "Errore: Tutti i campi devono essere compilati.";

    } else {
        document.getElementById("messaggio").innerText = "Successo: Tutti i campi sono compilati correttamente.";
    }
}