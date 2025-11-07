//Realizzare, sfruttando HTML e Javascript, l'applicativo "Contatore": si avranno due bottoni "conta sinistra" e "conta destra". Al click del bottone "conta destra" si incrementerà un contatore visibile schermo; al click del bottone "conta sinistra" si incrementerà un altro contatore anch'esso visibile a schermo. Sarà inoltre disponibile un contatore che tenga memoria dell'incremento totale.
let countLeft = 0;
let countRight = 0;

function incrementLeft() {
    countLeft++;
    alert("Contatore Sinistro: " + countLeft);
    updateDisplay();
}

function incrementRight() {
    countRight++;
    alert("Contatore Destro: " + countRight);
    updateDisplay();
}

function updateDisplay() {
    document.getElementById("leftCount").innerText = countLeft;
    document.getElementById("rightCount").innerText = countRight;
    document.getElementById("totalCount").innerText = countLeft + countRight;
}

// Inizializza i contatori a 0 all'avvio della pagina
updateDisplay();