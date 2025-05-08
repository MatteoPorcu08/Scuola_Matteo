// Esempio di utilizzo di tolower e toupper
#include <stdio.h>
#include <ctype.h> // Aggiunta della libreria ctype.h

int main () {
    char c = 'A';
    char c2 = 'a';

    printf("Il carattere iniziale era : %c\n", c);
    printf("Il carattere modificato con tolower e' : %c\n", tolower(c)); // stampa 'a'

    printf("Il carattere iniziale era : %c\n", c2);
    printf("Il carattere modificato con toupper e' : %c\n", toupper(c2)); // stampa 'A'
    return 0;
}