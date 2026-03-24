#include <stdio.h>

float media(int numeri[], int size)
{
    int somma = 0;

    for (int i = 0; i < size; i++)
    {
        somma += numeri[i];
    }

    return somma / size;
}

int filtraPositivi(int input[], int output[], int size)
{
    int j = 0;

    for (int i = 0; i < size; i++)
    {
        if (input[i] > 0)
        {
            output[j] = input[i];
            j++;
        }
    }

    return j;
}

int massimo(int numeri[], int size)
{
    int max = numeri[0];

    for (int i = 1; i < size; i++)
    {
        if (numeri[i] > max)
        {
            max = numeri[i];
        }
    }

    return max;
}

int main()
{
    int numeri[6] = {4, -2, 7, 0, -5, 3};
    int positivi[6];
    int size = 6;

    int count = filtraPositivi(numeri, positivi, size);

    float m = media(positivi, size);
    int max = massimo(positivi, count);

    printf("Media positivi: %.2f\n", m);
    printf("Massimo positivi: %d\n", max);

    return 0;
}