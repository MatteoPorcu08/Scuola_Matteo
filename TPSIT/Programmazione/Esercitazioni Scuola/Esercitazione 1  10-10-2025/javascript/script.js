alert("Calcola");
let num1 = prompt ("Inserisci il primo numero")*1;
let num2 = prompt ("Inserisci il secondo numero")*1;

let scelta = prompt ("Se vuoi eseguire la somma premi (1)\n Se vuoi eseguire la sottrazione premi (2)\n Se vuoi eseguire la divisione premi (3)\n Se vuoi eseguire il prodotto premi (4)")*1;
let risultato;
switch(scelta){
    case 1:
        alert("Il risultato della somma è:");
        risultato=num1+num2;
        break;
    case 2:
        alert("Il risultato della sottrazione è:");
        risultato=num1-num2;
        break;
    case 3:
        alert("Il risultato della divisione è:");
        risultato=num1/num2;
        break;
    case 4:
        alert("Il risultato della moltiplicazione è:");
        risultato=num1*num2;
        break;
    default:
        alert("Operazione non valida.Riprova!");
        risultato = null;
}


