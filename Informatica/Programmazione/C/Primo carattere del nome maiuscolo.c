/*Se l'utente per errore inserisce il nome con la prima lettera minuscola, cambiala in maiuscolo e ristampa il nome.*/
#include <stdio.h>
#include <ctype.h> // per la funzione tolower()

int main(){
    char nome[50];

    printf("Ciao! Questo programma ti chiede di inserire il tuo nome e se sbagli inserendo il primo carattere lo cambia in maiuscolo.\n");

    printf("Inserisci il tuo nome: ");
    scanf("%s", &nome);
    if ( nome[0] >= 97 && nome[0] <= 122 ) { // controllo se la prima lettera è minuscola
        printf ("La prima lettera del tuo nome e minuscola. La trasformo in maiuscola .\n");    
        nome[0] = toupper(nome[0]); // cambio la prima lettera in maiuscola
        printf("Il tuo nome e': %s\n", nome);
        }
        else {
            printf("Il tuo nome e' stato inserito corretamente: %s\n", nome);
            }
            return 0;

}