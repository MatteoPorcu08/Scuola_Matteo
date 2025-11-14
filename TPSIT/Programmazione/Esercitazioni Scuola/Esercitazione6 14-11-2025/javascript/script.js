let c = 0;// Contatore per i prodotti
function aggiungiProdotto() {
    let nome = prompt("Inserisci il nome del prodotto:");

    let carrello = document.getElementById("carrello");
    let prodotto = document.createElement("div");
    c++;
    document.getElementById("carrello").innerHTML =
    document.getElementById("carrello").innerHTML +"<br>"+"-" + nome;

}

function svuotaCarrello() {
    let carrello = document.getElementById("carrello").innerHTML = "Il carrello è vuoto";
    c = 0;
}