#include <stdio.h>
#include <ctype.h>

int main() {
    char stringa[100];
    int i = 0;

    // Acquisizione della stringa in input
    printf("Inserisci una stringa: ");
    fgets(stringa, sizeof(stringa), stdin);

    // Verifica e trasformazione dei caratteri
    for (i = 0; stringa[i] != '\0'; i++) {
        if ((stringa[i] >= 'A' && stringa[i] <= 'Z') || (stringa[i] >= 'a' && stringa[i] <= 'z')) { // Verifica se il carattere è una lettera
            stringa[i] = tolower(stringa[i]); // Trasforma la lettera in minuscola
        }
    }

    // Stampa della stringa trasformata
    printf("Stringa trasformata: %s", stringa);

    return 0;
}