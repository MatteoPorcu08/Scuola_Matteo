function verificaCampi() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const messaggio = document.getElementById('messaggio');
    
    if (username === '' || password === '') {
        messaggio.textContent = 'Errore: Tutti i campi devono essere compilati.';
        //messaggio.style.color = 'red';
    } else {
        messaggio.textContent = 'Successo: Tutti i campi sono compilati correttamente.';
        //messaggio.style.color = 'green';
    }
}