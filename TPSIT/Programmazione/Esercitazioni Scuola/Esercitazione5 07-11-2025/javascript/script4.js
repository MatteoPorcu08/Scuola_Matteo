function somma() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    let result = num1 + num2;
    alert("Risultato somma: " + result);
}

function sottrazione() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    let result = num1 - num2;
    alert("Risultato sottrazione: " + result);
}

function moltiplicazione() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    let result = num1 * num2;
    alert("Risultato moltiplicazione: " + result);
}

function divisione() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    if (num2 === 0) {
        alert("Errore: Divisione per zero!");
    } else {
        let result = num1 / num2;
        alert("Risultato divisione: " + result);
    }
}
