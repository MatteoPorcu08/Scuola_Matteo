function aggiungiProdotto() {
    prompt("Inserisci il nome del prodotto:");
    const carrello = document.getElementById("carrello");
    const prodotto = document.createElement("div");
    prodotto.textContent = "Prodotto aggiunto al carrello";
    carrello.appendChild(prodotto);

}