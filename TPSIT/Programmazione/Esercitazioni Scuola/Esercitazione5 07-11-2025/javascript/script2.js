function calcolaSomma() {
    const num1 = Number(document.getElementById("num1").value);
    const num2 = Number(document.getElementById("num2").value);
    const somma = num1 + num2;

    if (num1 >= 0 && num2 >= 0) {
    alert("La somma è: " + somma); // Mostra un popup alert
    } else {
    alert("Inserisci solo numeri positivi!");
    }
}
