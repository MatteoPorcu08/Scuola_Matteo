#include <stdio.h>

float calcolaMedia(int numeri[], int size)
{
    int somma = 0;
    int count = 0;

    for (int i = 0; i < size; i++)
    {
        if (numeri[i] > 0)
        {
            somma += numeri[i];
        }
        count++;
    }

    if (count == 0)
    {
        return 0;
    }

    return somma / count;
}

int trovaMassimo(int numeri[], int size)
{
    int massimo = 0;

    for (int i = 0; i < size; i++)
    {
        if (numeri[i] > massimo)
        {
            massimo = numeri[i];
        }
    }

    return massimo;
}

int main()
{
    int numeri[100];
    int size = 0;
    int valore;

    printf("Inserisci numeri (0 per terminare):\n");

    while (1)
    {
        printf("> ");
        scanf("%d", &valore);

        if (valore == 0)
        {
            break;
        }

        numeri[size] = valore;
        size++;
    }

    float media = calcolaMedia(numeri, size);
    int massimo = trovaMassimo(numeri, size);

    printf("Media: %.2f\n", media);
    printf("Massimo: %d\n", massimo);

    return 0;
}