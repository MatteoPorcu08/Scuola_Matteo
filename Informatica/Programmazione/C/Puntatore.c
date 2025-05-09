#include <stdio.h>

int main () {

    int*pi; // dichiara un puntatore a intero
    int num = 255L; // dichiara una variabile intera
    pi = &num; // assegna l'indirizzo di num a PI al puntatore pi

    printf ("contenuto della variabile num: %d\n", num); // stampa il contenuto di num
    printf ("indirizzo della variabile num: %x\n", &num); // stampa l'indirizzo di num
    printf ("contenuto della variabile *&num : %d\n", *&num); // stampa il contenuto di num

    printf ("valore del puntatore da  *pi: %d\n", *pi); // stampa l'indirizzo di num
    printf ("valore del contenuto di pi: %x\n", pi); // stampa il contenuto  di num

    return 0;
}