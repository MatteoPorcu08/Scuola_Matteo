#include <stdio.h>
//Procedura di scambio con il passaggio per indirizzo:

void scambio(int *a, int *b); // * puntatore

int main() {
    int a, b;
    printf("Scrivi il valore di a: ");
    scanf("%d", &a);
    printf("\nScrivi il valore di b: ");
    scanf("%d", &b);
   
    printf("\na=%d",a);
    printf("\nb=%d",b);
   
    scambio(&a,&b); // chiamata del passaggio per indirizzo
                    //l'operatore & è chiamato operatore indirizzo    
    printf("\n\nNel main, dopo aver effettuato lo scambio:");
    printf("\na=%d",a);
    printf("\nb=%d",b);
   
   
}

void scambio(int *a, int *b) {
    int t;
    t=*a;
    *a=*b;
    *b=t;
    printf("\n\nDentro la procedura:");
    printf("\na=%d",*a);
    printf("\nb=%d",*b);
}