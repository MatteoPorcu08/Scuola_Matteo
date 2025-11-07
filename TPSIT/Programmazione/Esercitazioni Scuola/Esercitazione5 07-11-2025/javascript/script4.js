function somma() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    document.getElementById("result").innerHTML = "Risultato somma: " + (num1 + num2);
}

function sottrai() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    document.getElementById("result").innerHTML = "Risultato sottrazione: " + (num1 - num2);
}

function moltiplica() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    document.getElementById("result").innerHTML = "Risultato moltiplicazione: " + (num1 * num2);
}

function dividi() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    if (num2 === 0) {
        document.getElementById("result").innerHTML = "Errore: divisione per zero!";
    } else {
        document.getElementById("result").innerHTML = "Risultato divisione: " + (num1 / num2);
    }
}