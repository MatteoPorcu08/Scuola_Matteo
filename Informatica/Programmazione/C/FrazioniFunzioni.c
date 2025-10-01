#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Definizione della struttura per rappresentare una frazione
typedef struct{
    int numeratore;
    int denominatore;
} Frazione;

// funzioni per eseguire i calcoli


int main(){
    Frazione f1, f2, risultato;
    int scelta;
    char continua;

        // Inserimento della prima frazione
        printf("Inserisci il numeratore della prima frazione: ");
        scanf("%d", &f1.numeratore);
        do{
            printf("Inserisci il denominatore della prima frazione (diverso da 0): ");
            scanf("%d", &f1.denominatore);
            if (f1.denominatore == 0){
                printf("Il denominatore non puo' essere 0. Riprova.\n");
            }
        } while (f1.denominatore == 0);

        // Inserimento della seconda frazione
        printf("Inserisci il numeratore della seconda frazione: ");
        scanf("%d", &f2.numeratore);
        do{
            printf("Inserisci il denominatore della seconda frazione (diverso da 0): ");
            scanf("%d", &f2.denominatore);
            if (f2.denominatore == 0){
                printf("Il denominatore non puo' essere 0. Riprova.\n");
            }
        } while (f2.denominatore == 0);

    do{
        // Scelta dell'operazione
        printf("Scegli l'operazione da eseguire:\n");
        printf("1) Moltiplicazione delle frazioni\n");
        printf("2) Divisione tra due frazioni\n");
        printf("3) Addizione tra due frazioni\n");
        printf("4) Sottrazione tra due frazioni\n");
        printf("Scelta: ");
        scanf("%d", &scelta);

        // Esecuzione delle operazioni direttamente nel main
        switch (scelta){
        case 1:
            // Moltiplicazione
            risultato.numeratore = f1.numeratore * f2.numeratore;
            risultato.denominatore = f1.denominatore * f2.denominatore;
            printf("Risultato della moltiplicazione: %d/%d\n", risultato.numeratore, risultato.denominatore);
            break;
            
        case 2:
            // Divisione
            risultato.numeratore = f1.numeratore * f2.denominatore;
            risultato.denominatore = f1.denominatore * f2.numeratore;
            printf("Risultato della divisione: %d/%d\n", risultato.numeratore, risultato.denominatore);
            break;
            
        case 3:
            // Addizione
            risultato.numeratore = (f1.numeratore * f2.denominatore) + (f2.numeratore * f1.denominatore);
            risultato.denominatore = f1.denominatore * f2.denominatore;
            printf("Risultato dell'addizione: %d/%d\n", risultato.numeratore, risultato.denominatore);
            break;
            
        case 4:
            // Sottrazione
            risultato.numeratore = (f1.numeratore * f2.denominatore) - (f2.numeratore * f1.denominatore);
            risultato.denominatore = f1.denominatore * f2.denominatore;
            printf("Risultato della sottrazione: %d/%d\n", risultato.numeratore, risultato.denominatore);
            break;
            
        default:
            printf("Scelta non valida.\n");
            break;
        }
        
        printf("Vuoi eseguire un'altra operazione? (s/n): ");
        scanf("%s", &continua);
    } while (continua == 's' || continua == 'S');
    
    return 0;
}