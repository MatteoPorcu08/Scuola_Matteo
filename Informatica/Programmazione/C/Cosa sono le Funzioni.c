//LE FUNZIONI
/*Una porzione di codice che serve per eseguire una determinata operazione*/

//DICHIARAZIONE DI FUNZIONE

//Tipo di dato restituito NOME(parametri formali)

#include <stdio.h>

int somma(int a, int b); //PROTOTIPO della FUNZIONE

int main() {
    int n,m, addizione;
    printf ("Scrivi il primo addendo:");
    scanf("%d", &n);
    printf ("Scrivi il secondo addendo:");
    scanf("%d", &m);
    addizione = somma(n,m); //CHIAMATA DELLA FUNZIONE
    printf ("La somma dei due addendi e': %d\n", addizione);
}

//DEFINIZIONE DI FUNZIONE
int somma(int a, int b) { //FIRMA DELLA FUNZIONE
    int s;
    s=a+b;
    return s;
    }