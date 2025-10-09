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
    Vendita v[N];
    char scelta;
    int s;


    printf("---Questo programma gestisce le vendite di prodotti.---\n");
    do{
        printf("Scegli quale operazione vuoi eseguire:\n");
        printf("1. Inserisci una vendita\n");
        printf("2. Visualizza tutte le vendite effetuate\n");
        printf("3. Calcola il totale delle vendite in un giorno specifico\n");
        scanf("%d", &s);
        switch(s){
            case 1:
            // Inserimento di una vendita

            case 2:
            // Visualizzazione di tutte le vendite

            case 3:
            // Calcolo del totale delle vendite in un giorno specifico
        }
   
        
        printf("Vuoi eseguire un'altra operazione? (S/N): ");
        scanf(" %c", &scelta);
    }while(scelta == 'S' || scelta == 's');


    return 0;

}

aggiungivendita(){
    // Codice per inserire una vendita
}