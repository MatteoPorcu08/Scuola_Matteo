#include <stdio.h>

void inserisciArray(int valori[],int n);
int minimo (int valori[],int n);
void stampaDispari(int valori[],int n);

int main (){
    int n, scelta, i, valori[30];

    inserisciArray (valori,n);

 do {
        printf ("\nMenu :\n");
        printf ("\n1. Trova il minimo\n");
        printf ("\n2. Stampa i valori dispari\n");
        printf ("\n3. Esci\n");
        printf ("\nCosa vuoi fare? ");
        scanf("%d", &scelta);
        switch (scelta) {
            case 1:
            printf ("Il minimo e': %d\n", minimo (valori, n));
            break;
            case 2:
            stampaDispari (valori,n);
            case 3:
            printf ("Arrivederci!\n");
            break;
            default:
            printf ("Scelta non valida!\n");
            }  
            } while (scelta != 3);  

            return 0;

            }

void inserisciArray (int valori[],int n) {
    int i,valori;
     for (i=0;i<n;i++) {
       printf ("Quanti valori vuoi inserire?");
       scanf ("%d",&valori);
    }
}



int minimo (int valori[],int n) {
    int i,min=valori[0];
    for (i=1;i<n;i++) {
        if (valori[i]<min ) {
            min=valori[i];
            }
         }
         return min;
    }


void stampaDispari(int valori[],int n){
    int dispari,i;
     for (i=1;i<n;i++) {
       if (dispari % 2 == 0) {
    
    } else {
        // Numero dispari
        printf("I numeri dispari sono", dispari);
    }
         }
    
    
}