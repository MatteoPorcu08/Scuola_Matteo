let numeri = [];
function calcola() {
    let somma = 0;
    for (let i = 0; i < 5; i++) {
        let numero = prompt("Inserisci un numero da sommare:") * 1;
        numeri[i] = numero;

    }
    for (let i = 0; i < 5; i++) {
        somma += numeri[i];
    }
    document.getElementById("somma").innerHTML = "La somma è: " + somma;
}