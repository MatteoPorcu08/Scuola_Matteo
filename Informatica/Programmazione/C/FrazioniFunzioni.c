#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct {
    int numeratore;
    int denominatore;
} Frazione;

/* Funzioni aritmetiche */
Frazione moltiplica(Frazione a, Frazione b) {
    Frazione r;
    r.numeratore = a.numeratore * b.numeratore;
    r.denominatore = a.denominatore * b.denominatore;
    return r;
}

Frazione dividi(Frazione a, Frazione b) {
    Frazione r;
    r.numeratore = a.numeratore * b.denominatore;
    r.denominatore = a.denominatore * b.numeratore;
    return r;
}

Frazione somma(Frazione a, Frazione b) {
    Frazione r;
    r.numeratore = a.numeratore * b.denominatore + b.numeratore * a.denominatore;
    r.denominatore = a.denominatore * b.denominatore;
    return r;
}

Frazione sottrai(Frazione a, Frazione b) {
    Frazione r;
    r.numeratore = a.numeratore * b.denominatore - b.numeratore * a.denominatore;
    r.denominatore = a.denominatore * b.denominatore;
    return r;
}

/* Funzioni basilari di I/O */
Frazione inserisci_frazione(const char *nome) {
    Frazione f;
    printf("Inserisci il numeratore della %s frazione: ", nome);
    scanf("%d", &f.numeratore);
    do {
        printf("Inserisci il denominatore della %s frazione (diverso da 0): ", nome);
        scanf("%d", &f.denominatore);
        if (f.denominatore == 0) {
            printf("Il denominatore non puo' essere 0. Riprova.\n");
        }
    } while (f.denominatore == 0);
}

void stampa_frazione(const char *msg, Frazione f) {
    printf("%s%d/%d\n", msg, f.numeratore, f.denominatore);
}

int main(void) {
    Frazione f1, f2, risultato;
    int scelta;
    char continua;

    /* Inserimento frazioni */
    f1 = inserisci_frazione("prima");
    f2 = inserisci_frazione("seconda");

    do {
        /* Menu */
        printf("Scegli l'operazione da eseguire:\n");
        printf("1) Moltiplicazione delle frazioni\n");
        printf("2) Divisione tra due frazioni\n");
        printf("3) Addizione tra due frazioni\n");
        printf("4) Sottrazione tra due frazioni\n");
        printf("Scelta: ");
        scanf("%d", &scelta);

        /* Operazioni */
        switch (scelta) {
            case 1:
                risultato = moltiplica(f1, f2);
                stampa_frazione("Risultato della moltiplicazione: ", risultato);
                break;
            case 2:
                risultato = dividi(f1, f2);
                stampa_frazione("Risultato della divisione: ", risultato);
                break;
            case 3:
                risultato = somma(f1, f2);
                stampa_frazione("Risultato dell'addizione: ", risultato);
                break;
            case 4:
                risultato = sottrai(f1, f2);
                stampa_frazione("Risultato della sottrazione: ", risultato);
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
