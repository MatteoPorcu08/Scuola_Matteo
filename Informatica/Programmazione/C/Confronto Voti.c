/*Immagina di dover sviluppare un programma per gestire i voti di una classe. 

Utilizzerai un vettore di interi per memorizzare i voti degli studenti e implementerai diverse funzioni per analizzare i dati raccolti.

Crea un programma che consenta di caricare un vettore di interi rappresentante i voti degli studenti. Il numero di studenti sarà definito dall'utente.

Il programma deve contenere le seguenti funzionalità: 
Crea una funzione che permetta di caricare i voti degli studenti all'interno del vettore.
Crea una funzione che visualizzi tutti i voti caricati.
Crea una funzione che calcoli e restituisca il voto più alto ottenuto dagli studenti.
Crea una funzione che calcoli e restituisca il voto più basso ottenuto dagli studenti.
Crea una funzione che calcoli la media dei voti.
Nel main, crea un menù che permetta all'utente di scegliere quale delle funzioni eseguire (caricamento voti, stampa voti, massimo, minimo, media).
Inserisci il menù in un ciclo che permetta all'utente di eseguire più operazioni senza dover riavviare il programma.
Ulteriore richiesta:
Aggiungi una funzionalità extra a tua scelta.*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void carica (int voti[],int n);
void stampa (int voti[],int n);
int massimo (int voti[],int n);
int minimo (int voti[],int n);
float media (int voti[],int n);

int main() {
    int n, scelta, i, voti[30];
    float mediaVoti;

    srand (time(NULL)); // Inizializza il generatore di numeri casuali
    printf("Da quanti studenti e' composta la classe? ");
    scanf("%d", &n);

    carica (voti, n);
    do {
        printf ("\nMenu :\n");
        printf ("\n1. Stampa voti\n");
        printf ("\n2. Trova il massimo\n");
        printf ("\n3. Trova il minimo\n");
        printf ("\n4. Calcola la media\n");
        printf ("\n5. Esci\n");
        printf ("\nCosa vuoi fare? ");
        scanf("%d", &scelta);
        switch (scelta) {
            case 1:
            stampa (voti, n) ;
            break;
            case 2:
            printf ("Il massimo e': %d\n", massimo (voti, n));
            break;
            case 3:
            printf ("Il minimo e': %d\n", minimo (voti, n));
            break;
            case 4:
            mediaVoti = media (voti, n);
            printf ("La media e': %.2f\n", mediaVoti);
            break;
            case 5:
            printf ("Arrivederci!\n");
            break;
            default:
            printf ("Scelta non valida!\n");
            }  
            } while (scelta != 5);  

            return 0;

            }


// Funzione per caricare i voti degli studenti
void carica (int voti[],int n) {
    int i;
     for (i=0;i<n;i++) {
       voti [i]=rand()%10+1;
    }
}

// Funzione per stampare i voti
void stampa (int voti[],int n) {
    int i;
    for (i=0;i<n;i++) {
        printf("%d ",voti[i]);
    }
}

// funzione che trova il massimo
int massimo (int voti[],int n) {
    int i,max=voti[0];
    for (i=1;i<n;i++) {
        if (voti[i]> max) {
            max=voti[i];
            }
    }
    return max;
    }

// funzione per trovare il minimo
int minimo (int voti[],int n) {
    int i,min=voti[0];
    for (i=1;i<n;i++) {
        if (voti[i]<min ) {
            min=voti[i];
            }
         }
         return min;
    }

// funzione media
float media (int voti[],int n) {
    int i;
    float somma=0;
    for (i=0;i<n; i++) {
        somma=somma+voti[i];
        }
        return somma /n;
}