// Dichiarazione delle variabili
var COST = 5;
var vettore = new Array(COST);
//Inserimento dati
for (var i = 0; i < COST; i++) {
    vettore[i] = prompt("Inserisci un numero intero:") * 1;
}
//Visualizzazione dei dati
for (var i = 0; i < COST; i++) {
    document.write("Posizione " + i + ": " + vettore[i] + "<br>");
}