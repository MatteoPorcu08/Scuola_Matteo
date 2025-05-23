/*Scrivi un programma che:
    Richieda all'utente 10 numeri interi
    Li memorizzi in un array
    Calcoli quanti di questi sono maggiori della media dei valori inseriti*/

#include <stdio.h>
int main () {
    int N=10;
    int num[N];
    int somma;
    float media;
    int i,n,massimo;

    printf("Inserisci 10 numeri interi:");
    for( i=0; i<10; i++) {
        scanf("%d", &num[i]) ;
       
    }

    for (i=0;i<10; i++) {
        somma=somma+num[i];
        }
        media=somma / 10;
    printf ("La media e': %.2f\n", media);
	
	for(i=0;i<10;i++){
		 if (num[i]>media) {
                massimo++;
            }
	}
    
    printf("I numeri maggiori della media sono:%d\n",massimo);
    

    return 0;
}