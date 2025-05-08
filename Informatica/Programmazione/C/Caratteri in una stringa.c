#include <stdio.h>
#include <string.h>

#define DIM 25

int main() {
    int n, x;
    char s[DIM];
    char app[DIM]; // Deve essere un array per poter contenere la stringa originale

    printf("Inserisci il nome: ");
    scanf("%s", s);

    n = strlen(s);

    printf("La parola contiene %d caratteri\n", n);

    // Copia la stringa originale in app
    strcpy(app, s);

    // Inverte la stringa s
    for (x = 0; x < n / 2; x++) {
        char temp = s[x];
        s[x] = s[n - x - 1];
        s[n - x - 1] = temp;
    }

    printf("La parola invertita e' %s\n", s);
    printf(" La stringa originale e' %s\n", app);

    return 0;
}