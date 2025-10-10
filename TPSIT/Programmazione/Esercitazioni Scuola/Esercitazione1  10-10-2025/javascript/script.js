alert("Calcola");
let num1 = prompt ("Inserisci il primo numero")*1;
let num2 = prompt ("Inserisci il secondo numero")*1;
let scelta = prompt ("Se vuoi eseguire la somma premi (1)\n Se vuoi eseguire la sottrazione premi (2)\n Se vuoi eseguire la divisione premi (3)\n Se vuoi eseguire il prodotto premi (4)")*1;
let risultato;
switch(scelta){
    case 1:
        risultato=num1+num2;
        alert("Il risultato della somma è:" +risultato);
        break;
    case 2:
        risultato=num1-num2;
        alert("Il risultato della sottrazione è: " +risultato);
        break;
    case 3:
        risultato=num1/num2;
        alert("Il risultato della divisione è:"+risultato);
        break;
    case 4:
        risultato=num1*num2;
        alert("Il risultato della moltiplicazione è:"+risultato);
        break;
    default:
        alert("Operazione non valida.Riprova!");
        risultato = null;
}
