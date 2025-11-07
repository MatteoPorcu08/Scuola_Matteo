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

updateDisplay();
