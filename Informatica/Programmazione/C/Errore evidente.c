#include <stdio.h>

int sommaPari(int numeri[], int size) {
    int somma = 0;

    for (int i = 0; i <= size; i++) {
        if (numeri[i] % 2 == 0) {
            somma = numeri[i];
        }
    }

    return somma;
}

int main() {
    int numeri[5] = {1, 2, 3, 4, 5};

    int risultato = sommaPari(numeri, 5);

    printf("Somma numeri pari: %d\n", risultato);

    return 0;
}