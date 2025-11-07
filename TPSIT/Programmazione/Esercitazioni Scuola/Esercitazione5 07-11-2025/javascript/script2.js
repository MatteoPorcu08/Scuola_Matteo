function calcolaSomma() {
    
    const num1 = Number(document.getElementById("num1").value);
    const num2 = Number(document.getElementById("num2").value);

    const somma= num1*1+num2*1;

    //se i numeri inseriti sono positivi stampa la somma
    if(num1>=0 && num2>=0){
        document.getElementById("result").innerHTML = "La somma è: " + somma;
    } else {
        document.getElementById("result").innerHTML = "Inserisci solo numeri positivi!";
    }
}