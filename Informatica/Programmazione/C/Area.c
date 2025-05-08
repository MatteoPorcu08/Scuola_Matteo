/*Scrivere un programma che dato in input il raggio di un cerchio ne stampi l'area utilizzando due funzioni:
- area1(float r) che riceve il raggio dal programma principale attraverso un passaggio per valore.
- area2(float *r) la seconda che lo riceva col passaggio per indirizzo*/

#include <stdio.h>
#define PI 3.14

// creo il prototipo della funzione area1 che riceve il raggio per valore
 float area1 (float raggio); 
 // creo il prototipo della funzione area2 che riceve il raggio per indirizzo
 float area2(float *raggio);

int main () {
    float raggio;

    // chiedo il raggio
    printf ("Inserisci il raggio del cerchio: ");
    scanf ("%f", &raggio);

    // chiamo la funzione area1
    printf ("L'area del cerchio e': %.2f\n", area1(raggio ));
    // chiamo la funzione area2
    printf ("L'area del cerchio e': %.2f\n", area2(&raggio));

    return 0;
}

// creo la funzione area1 che riceve il raggio per valore
float area1 (float raggio) {
    float area = PI * raggio * raggio;
    return area;
    }

// creo la funzione area2 che riceve il raggio per indirizzo
float area2(float *raggio) {
    float area = PI * (*raggio) * (*raggio);
    return area;
}