function calcolaSomma() {
    
    let num1 = document.getElementsById("num1").value;
    let num2 = document.getElementsById("num2").value;

    let somma= num1*1+num2*1;

    //verifica che i valori inseriti sono numeri positivi
    if(isNaN(num1) || isNaN(num2) || num1 < 0 || num2 < 0){
        alert("Inserisci solo numeri positivi!");
        return;
    }else{
        document.getElementById("risultato").innerHTML="La somma è: " + somma;
    }
    
}