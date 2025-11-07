//Realizzare tramite html e Javascript una pagina web che riproduca una calcolatrice semplificata.  Nello specifico l'applicativo dovrà permettere all'utente di inserire due numeri e scegliere tramite 4 bottoni l'operazione che desidera venga effettuata (somma, prodotto, divisione, sottrazione), il risultato sarà visualizzato in pagina.
function somma() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let result = num1 + num2;
    document.getElementById("result").innerHTML = "Risultato: " + result;
}

function sottrazione() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let result = num1 - num2;
    document.getElementById("result").innerHTML = "Risultato: " + result;
}

function moltiplicazione() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let result = num1 * num2;
    document.getElementById("result").innerHTML = "Risultato: " + result;
}

function divisione() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    if (num2 === 0) {
        document.getElementById("result").innerHTML = "Errore: Divisione per zero!";
    } else {
        let result = num1 / num2;
        document.getElementById("result").innerHTML = "Risultato: " + result;
    }
}