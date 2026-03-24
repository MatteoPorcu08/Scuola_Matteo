#include <stdio.h>

int somma(int a, int b)
{
    int risultato;
    risultato = a + b;
    return risultato;
}

int main()
{
    int x = 5;
    int y = 3;
    int risultato;

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