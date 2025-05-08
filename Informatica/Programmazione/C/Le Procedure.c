#include <stdio.h>//prototipo della procedura:
void scambio(int a, int b);

int main() {
    int x, y;
    printf("Questo esercizio utilizza le procedure.\n");
    printf("Inserisci il primo valore: ");
    scanf("%d", &x);
    printf("Inserisci il secondo valore: ");
    scanf("%d", &y);
    printf("Adesso chiamiamo la funzione che effettua lo scambio dei valori: ");
    system("PAUSE");
    //chiamata della procedura
    scambio(x,y);
   
       
}

//definizione della procedura:
void scambio(int a, int b) {
    int t;
    printf("I valori passati sono: a=%d e b=%d.\n", a, b);
    t=a;
    a=b;
    b=t;
    printf("I valori dopo lo scambio sono: a=%d e b=%d.\n", a, b);
}