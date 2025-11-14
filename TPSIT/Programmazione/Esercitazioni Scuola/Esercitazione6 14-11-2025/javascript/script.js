let c = 0;// Contatore per i prodotti
function aggiungiProdotto() {
    let nome = prompt("Inserisci il nome del prodotto:");

    let carrello = document.getElementById("carrello");
    let prodotto = document.createElement("div");
    c++;
    prodotto.innerHTML = "Alimento " + c + " = " + nome;
    carrello.appendChild(prodotto); // Aggiunge il nuovo prodotto al carrello
}

function svuotaCarrello() {
    let carrello = document.getElementById("carrello");
    carrello.innerHTML = "Il carrello è vuoto";
    c = 0;
}