function click(){
    let bevanda = document.getElementById("inputbevanda").value;
    let quantita = document.getElementById("inputquantita").value;

    if(quantita >1){
        document.getElementById("lista").innerHTML =
        document.getElementById("lista").innerHTML + "<br>-" + bevanda;
        document.getElementById("inputbevanda").value = "";
    } else{
        alert=("Errore! Inserire un numero positivo.");
    }
}