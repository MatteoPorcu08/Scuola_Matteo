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

Vendita v[N];

// Prototipi delle funzioni
void aggiungivendita(Vendita v[], int *num_vendite);

int main(){
    Vendita v[N];
    char scelta;
    int s;


    printf("---Questo programma gestisce le vendite di prodotti.---\n");
    do{
        printf("--Scegli quale operazione vuoi eseguire:--\n");
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

            default:
            printf("Scelta non valida. Riprova.\n");
            break;
        }
   
        
        printf("Vuoi eseguire un'altra operazione? (S/N): ");
        scanf(" %c", &scelta);
    }while(scelta == 'S' || scelta == 's');


    return 0;

}

// Funzione per aggiungere una vendita
void aggiungivendita(){
    int i;
    for(i=0; i<N; i++){
        if(v[i]=NULL){
            printf("Inserisci il codice della vendita: ");
            scanf("%d", &v[i].codice_vendita);
            printf("Inserisci il nome del prodotto: ");
            scanf("%s", v[i].nome_prodotto);
            printf("Inserisci il prezzo del prodotto: ");
            scanf("%f", &v[i].prezzo_prodotto);
            printf("Inserisci la quantita venduta: ");
            scanf("%d", &v[i].quantita_venduta);
            printf("Inserisci la data della vendita (gg mm aaaa): ");
            scanf("%d %d %d", &v[i].data_vendita.giorno, &v[i].data_vendita.mese, &v[i].data_vendita.anno);
        }

}