let c = 0; // Contatore prodotti

function aggiornaContatore() {
    document.getElementById("contatoreProdotti").textContent = "Prodotti nel carrello: " + c;
    if (c === 0) {
        document.getElementById("carrello").textContent = "Il carrello è vuoto";
    }
}

function aggiungiProdotto() {
    let nome = prompt("Inserisci il nome del prodotto:");
    if (nome === null || nome.trim() === "") return; // se vuoto o annullato esce senza nulla

    let carrello = document.getElementById("carrello");
    if (c === 0) {
        carrello.textContent = ""; // rimuove scritta "carrello vuoto" quando si aggiunge il primo prodotto
    }
    carrello.innerHTML += "<br>-" + nome.trim();
    c++;
    aggiornaContatore();
}

function svuotaCarrello() {
    let carrello = document.getElementById("carrello");
    carrello.innerHTML = "Il carrello è vuoto";
    c = 0;
    aggiornaContatore();
}

// Per far apparire il messaggio iniziale senza click
aggiornaContatore();