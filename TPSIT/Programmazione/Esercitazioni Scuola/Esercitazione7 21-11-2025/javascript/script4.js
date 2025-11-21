function convertiMetriInCentimetri() {

    let metri = document.getElementById("metriInput").value;
    let centimetri = metri * 100;
    
    document.getElementById("risultato").innerHTML = centimetri + " centimetri";
}