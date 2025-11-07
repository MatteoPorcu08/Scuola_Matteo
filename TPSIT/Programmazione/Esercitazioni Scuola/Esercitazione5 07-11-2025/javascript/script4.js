function somma() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let result = num1*1 + num2*1;
    document.getElementById("result").innerHTML = "Risultato: " + result;
}

function sottrazione() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let result = num1*1 - num2*1;
    document.getElementById("result").innerHTML = "Risultato: " + result;
}

function moltiplicazione() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    let result = num1*1 * num2*1;
    document.getElementById("result").innerHTML = "Risultato: " + result;
}

function divisione() {
    let num1 = document.getElementById("num1").value;
    let num2 = document.getElementById("num2").value;
    if (num2 === 0) {
        document.getElementById("result").innerHTML = "Errore: Divisione per zero!";
    } else {
        let result = num1*1 / num2*1;
        document.getElementById("result").innerHTML = "Risultato: " + result;
    }
}