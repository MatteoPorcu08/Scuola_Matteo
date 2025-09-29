/*Crea un programma per fare i calcoli con le frazioni.
Crea un tipo di dato personalizzato, Frazione, che contiene un numeratore e un denominatore, entrambi numeri interi.
Il programma, dopo aver chiesto all'utente di inserire i valori di numeratore e denominatore delle due frazioni dovrà far scegliere all'utente di tra le seguenti operazioni:
1) Moltiplicazione delle frazioni
2) Divisione tra due frazioni
3) Addizione tra due frazioni //opzionale
4) Sottrazione tra due frazioni //opzionale

L'utente potrà scegliere se proseguire o se uscire dal programma.
ATTENZIONE: La frazione non può avere 0 come denominatore! Prevedi un sistema per evitarlo.*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct{
    int numeratore;
    int denominatore;
} Frazione;

void stampaFrazione(Frazione f){
    printf("%d/%d\n", f.numeratore, f.denominatore);
}

Frazione moltiplicaFrazioni(Frazione f1, Frazione f2){
    Frazione risultato;
    risultato.numeratore = f1.numeratore * f2.numeratore;
    risultato.denominatore = f1.denominatore * f2.denominatore;
    return risultato;
}

Frazione dividiFrazioni(Frazione f1, Frazione f2){
    Frazione risultato;
    risultato.numeratore = f1.numeratore * f2.denominatore;
    risultato.denominatore = f1.denominatore * f2.numeratore;
    return risultato;
}

Frazione sommaFrazioni(Frazione f1, Frazione f2){
    Frazione risultato;
    risultato.numeratore = (f1.numeratore * f2.denominatore) + (f2.numeratore * f1.denominatore);
    risultato.denominatore = f1.denominatore * f2.denominatore;
    return risultato;
}

Frazione sottraiFrazioni(Frazione f1, Frazione f2){
    Frazione risultato;
    risultato.numeratore = (f1.numeratore * f2.denominatore) - (f2.numeratore * f1.denominatore);
    risultato.denominatore = f1.denominatore * f2.denominatore;
    return risultato;
}


int main()
{
    Frazione f1, f2, risultato;
    int scelta;
    char continua;

    do
    {
        // Inserimento della prima frazione
        printf("Inserisci il numeratore della prima frazione: ");
        scanf("%d", &f1.numeratore);
        do
        {
            printf("Inserisci il denominatore della prima frazione (diverso da 0): ");
            scanf("%d", &f1.denominatore);
            if (f1.denominatore == 0)
            {
                printf("Il denominatore non puo' essere 0. Riprova.\n");
            }
        } while (f1.denominatore == 0);

        // Inserimento della seconda frazione
        printf("Inserisci il numeratore della seconda frazione: ");
        scanf("%d", &f2.numeratore);
        do
        {
            printf("Inserisci il denominatore della seconda frazione (diverso da 0): ");
            scanf("%d", &f2.denominatore);
            if (f2.denominatore == 0)
            {
                printf("Il denominatore non puo' essere 0. Riprova.\n");
            }
        } while (f2.denominatore == 0);

        // Scelta dell'operazione
        printf("Scegli l'operazione da eseguire:\n");
        printf("1) Moltiplicazione delle frazioni\n");
        printf("2) Divisione tra due frazioni\n");
        printf("3) Addizione tra due frazioni\n");
        printf("4) Sottrazione tra due frazioni\n");
        printf("Scelta: ");
        scanf("%d", &scelta);

        switch (scelta)
        {
        case 1:
            risultato = moltiplicaFrazioni(f1, f2);
            printf("Risultato della moltiplicazione: ");
            stampaFrazione(risultato);
            break;
        case 2:
            risultato = dividiFrazioni(f1, f2);
            printf("Risultato della divisione: ");
            stampaFrazione(risultato);
            break;
        case 3:
            risultato = sommaFrazioni(f1, f2);
            printf("Risultato dell'addizione: ");
            stampaFrazione(risultato);
            break;
        case 4:
            risultato = sottraiFrazioni(f1, f2);
            printf("Risultato della sottrazione: ");
            stampaFrazione(risultato);
            break;
        default:
            printf("Scelta non valida.\n");
            break;
        }
        printf("Vuoi eseguire un'altra operazione? (s/n): ");
        scanf(" %c", &continua);
    } while (continua == 's' || continua == 'S');
    return 0;
}