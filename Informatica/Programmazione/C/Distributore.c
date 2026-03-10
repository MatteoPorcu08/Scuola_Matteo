#include <stdio.h>

int main()
{
    int M;
    printf("Ciao!Inserisci un euro: ");
    scanf("%d", &M);
    if (M >= 1)
    {
        printf("Ecco a te la bevanda\n");
    }
    else
    {
        printf("Errore, devi inserire almeno un euro\n");
    }
    return 0;
}