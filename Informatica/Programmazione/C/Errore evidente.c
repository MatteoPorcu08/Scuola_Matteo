#include <stdio.h>

int somma(int a, int b)
{
    int risultato;
    risultato = a + b;
    return risultato;
}

int main()
{
    int x = 0;
    int y = 0;
    int risultato;

    printf("Questo programma calcola la somma di due numeri. La somma deve dare 8\n");
    printf("Inserisci il primo numero: ");
    scanf("%d", &x);
    printf("Inserisci il secondo numero: ");
    scanf("%d", &y);

    risultato = somma(x, y);

    if (risultato == 8)
    {
        printf("La somma è corretta\n");
    }
    else
    {
        printf("Errore\n");
    }

    return 0;
}