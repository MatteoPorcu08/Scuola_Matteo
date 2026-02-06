let carrello = []; // Array vuoto per i prodotti
let i = 0; // Indice

function aggiungiProdotto() {
    let prodotto = document.getElementById("prodotto").value;

    if (prodotto != "") {
        carrello[i] = prodotto; // Inserisce il prodotto nell'array
        i++;
    }

    document.getElementById("prodotto").value = ""; // Svuota input
}

function mostraCarrello() {
    document.getElementById("elencoCarrello").innerHTML = "";

    for (let j = 0; j < carrello.length; j++) {
        document.getElementById("elencoCarrello").innerHTML += carrello[j] + "<br>";
    }
}

function cercaProdotto() {
    let nomeDaCercare = prompt("Inserisci il nome del prodotto da cercare:");
    let trovato = false;

    for (let j = 0; j < carrello.length; j++) {
        if (carrello[j] == nomeDaCercare) {
            trovato = true;
        }
    }

    if (trovato) {
        alert("Prodotto PRESENTE nel carrello");
    } else {
        alert("Prodotto NON presente nel carrello");
    }
}