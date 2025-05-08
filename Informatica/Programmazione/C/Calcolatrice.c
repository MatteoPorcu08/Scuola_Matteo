#include <stdio.h>
#include <stdlib.h>

/*Calcolatrice con le funzioni*/

int addizione(int a, int b);  // Funzione per l'addizione
int sottrazione (int a, int b); // Funzione per la sottrazione
int moltiplicazione (int a, int b); // Funzione per la moltiplicazione
int divisione (int a, int b); // Funzione per la divisione

int main () {
    int n, m, scelta, risultato;

    printf("Bnevenuto nella calcolatrice!\n");

    printf ("Inserisci il primo numero: ");
    scanf ("%d", &n);
    printf ("Inserisci il secondo numero: ");
    scanf ("%d", &m);
    printf ("Scegli l'operazione da eseguire:\n");
    printf ("1. Somma\n");
    printf ("2. Sottrazione\n");
    printf ("3. Moltiplicazione\n");
    printf ("4. Divisione\n");

    scanf ("%d", &scelta);
    switch (scelta) {
        case 1:
        risultato = addizione (n, m);
        printf ("Il risultato della somma e': %d\n", risultato);
        break;
        case 2:
        risultato = sottrazione (n, m);
        printf ("Il risultato della sottrazione e': %d\n", risultato);
        break;
        case 3:
        risultato = moltiplicazione (n, m);
        printf ("Il risultato della moltiplicazione e': %d\n", risultato);
        break;
        case 4:
        risultato = divisione (n, m);
        printf ("Il risultato della divisione e': %d\n", risultato);
        break;
        default:
        printf ("Operazione non valida.\n");
        break;
        }
        return 0;
        }

        /* Funzioni per le operazioni aritmetiche*/
        int addizione (int a, int b) {
            int s;
            s = a + b;
            return s;
            }
            int sottrazione (int a, int b) {
                int s;
                s = a - b;
                return s;
                }
                int moltiplicazione (int a, int b) {
                    int s;
                    s = a * b;
                    return s;
                    }
                    int divisione (int a, int b) {
                        if (b != 0) {
                            int s;
                            s = a / b;
                            return s;
                        }
                        else {
                            printf("Impossibile dividere per zero.\n");
                            return 0;
                        }
                    }
