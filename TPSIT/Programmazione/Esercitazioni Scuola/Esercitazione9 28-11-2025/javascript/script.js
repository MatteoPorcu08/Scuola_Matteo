function aggiungi(){
    let bevanda = document.getElementById("inputbevanda").value;
    let quantita = document.getElementById("inputquantita").value*1;

    if(quantita > 0){
        document.getElementById("lista").innerHTML =
        document.getElementById("lista").innerHTML + "<br>-" + bevanda+ " x " +quantita;
        document.getElementById("inputbevanda").value = "";
    } else{
        alert("Errore! Inserire un numero positivo.");
    }
}