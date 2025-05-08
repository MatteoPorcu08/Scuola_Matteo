#include <stdio.h>
#include <string.h>

int main() {
    char s[100], c;
    int count = 0, l;

    printf("Ciao, questo programma conta i caratteri presenti in una frase.\n");
    printf("Scrivi una frase:\n");
    scanf("%s", s);
    printf("Quale carattere vuoi cercare? ");
    fflush(stdin);
    scanf(" %c", &c);

    l = strlen(s);

    for (int i = 0; i < l; i++) {
        if (s[i] == c) {
            count++;
        }
    }

    printf("Il carattere %c compare %d volte in %s.\n", c, count, s);
    printf("La stringa %s ha %d caratteri.\n", s, l);
    printf("La frequenza del carattere %c in %s è %.2f%%.\n", c, s, (float)count / l * 100);

    return 0;
}