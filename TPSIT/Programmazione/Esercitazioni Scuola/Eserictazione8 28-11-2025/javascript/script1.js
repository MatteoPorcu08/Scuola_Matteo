function calcolaDoppio() {
    let numeroInput = document.getElementById("numero");
    let numero = document.getElementById("numero").value;
    let doppio = numero * 2;
    let risultato = document.getElementById("risultato");
    risultato.innerHTML = "Il doppio di " + numero + " è " + doppio;
}