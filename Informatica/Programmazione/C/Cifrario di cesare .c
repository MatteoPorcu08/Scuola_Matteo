/*Crea un programma per criptare una parola con la trasposizione +3 (Cifrario di Cesare).
Iniziate a predisporre un algoritmo per criptare le singole lettere:
A  -> D
B  -> E
...
X  -> Z
Y  -> A
W -> B
Z  -> C

Successivamente, applicatelo ad una parola intera.*/

#include <stdio.h>
#include <string.h>

int main() {
    char s1[100];
    int i,n;


    printf("Inserisci una parola: ");
    gets (s1);

    n= strlen(s1);
    for (i = 0; i < n; i++) {
        if( s1>97 && s1<122 ) {
            s1 [i] = s1[i] -26;
        }
        else {
            s1 [i] = s1[i] +3;
        }
        if (s1[i] > 122) {
            s1[i] = s1[i] - 26;
            }
            else if (s1[i] < 97) {
                s1[i] = s1[i] + 26;
                }
        }

        printf("La parola criptata e': %s\n",s1);

        return 0;
    }



