#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 100

// Strutture dati
typedef struct{
    int giorno;
    int mese;
    int anno;
} Data;

// Struttura per rappresentare un prodotto venduto
typedef struct{ 
    int codice_vendita;
    char nome_prodotto[N];
    float prezzo_prodotto;
    int quantita_venduta;
    Data data_vendita;
} Vendita;

int main(){

}