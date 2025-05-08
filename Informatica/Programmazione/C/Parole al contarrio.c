/*Crea un programma che, data una stringa s1 di N caratteri, la inverta e salvi la parola invertita nella stringa s2.*/

#include <stdio.h>
#include <string.h>

int main() {
    const int DIM= 50;
    int i, n;
    char s1[DIM], s2 [DIM];
    
    // introduzione al programma
    printf("Benvenuto nel programma che ti chiede di inserire una stringa e dopo la riscrive al contrario!!\n");

    // lettura della stringa
    printf("Inserisci il nome: ");
    gets(s1);

    // Inverti la stringa
    n = strlen(s1);

    for (i = 0; i < n; i++) {
        s2[i] = s1[n - i - 1];
        }

        s2[n] = '\0'; // Aggiunge il carattere di fine stringa


        //Stampa la stringa invertita
        printf("La stringa al contrario e': %s", s2);


    return 0;

}