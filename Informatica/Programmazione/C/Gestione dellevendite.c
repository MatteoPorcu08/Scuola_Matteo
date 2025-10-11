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
void aggiungivendita();
void visualizzavendite();
void calcolatotalevendite();


int main(){
    Vendita v[N];
    char scelta;
    int s;


    printf("---Questo programma gestisce le vendite di prodotti.---\n");
    printf("\n");
    do{
        printf("--Scegli quale operazione vuoi eseguire:--\n");
        printf("1. Inserisci una vendita\n");
        printf("2. Visualizza tutte le vendite effetuate\n");
        printf("3. Calcola il totale delle vendite in un giorno specifico\n");
        scanf("%d", &s);
        switch(s){
            case 1:
            // Inserimento di una vendita
            aggiungivendita(v, N);
            break;

            case 2:
            // Visualizzazione di tutte le vendite
            visualizzavendite(v, N);
            break;

            case 3:
            // Calcolo del totale delle vendite in un giorno specifico
            calcolatotalevendite(v, N);
            break;

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
        if(v[i].codice_vendita == 0){ // Trova la prima posizione libera
            printf("Inserisci il codice della vendita: ");
            scanf("%d", &v[i].codice_vendita);
            printf("Inserisci il nome del prodotto: ");
            scanf("%s", v[i].nome_prodotto);
            printf("Inserisci il prezzo del prodotto: ");
            scanf("%f", &v[i].prezzo_prodotto);
            printf("Inserisci la quantita' venduta (Kg): ");
            scanf("%d", &v[i].quantita_venduta);
            printf("Inserisci la data di acquisto. Giorno: ");
            scanf("%d", &v[i].data_vendita.giorno);
            printf("Mese: ");
            scanf("%d", &v[i].data_vendita.mese);
            printf("Anno: ");
            scanf("%d", &v[i].data_vendita.anno);
            break; // Esci dal ciclo dopo aver inserito una vendita
        
        }
}
}

// Funzione per visualizzare tutte le vendite
void visualizzavendite(){
    int i;
    for(i=0; i<N; i++){
        if(v[i].codice_vendita != 0){ // Visualizza solo le vendite inserite
            printf("-----Vendita %d-----\n", i+1);
            printf("Codice vendita: %d\n", v[i].codice_vendita);
            printf("Nome prodotto: %s\n", v[i].nome_prodotto);
            printf("Prezzo prodotto: %.2f\n", v[i].prezzo_prodotto);
            printf("Quantita' venduta: %d Kg\n", v[i].quantita_venduta);
            printf("Data vendita: %d/%d/%d", v[i].data_vendita.giorno, v[i].data_vendita.mese, v[i].data_vendita.anno);
            printf("\n-------------------\n");
        }
}
}

// Funzione per calcolare il totale delle vendite in un giorno specifico
void calcolatotalevendite(){
    int giorno, mese, anno;
    float totale = 0.0;
    printf("Inserisci la data per calcolare il totale delle vendite. Giorno: ");
    scanf("%d", &giorno);
    printf("Mese: ");
    scanf("%d", &mese);
    printf("Anno: ");
    scanf("%d", &anno);
    for(int i=0; i<N; i++){
        if(v[i].codice_vendita != 0 && v[i].data_vendita.giorno == giorno && v[i].data_vendita.mese == mese && v[i].data_vendita.anno == anno){
            totale += v[i].prezzo_prodotto * v[i].quantita_venduta;
        }
    }
    printf("Il totale delle vendite del %02d/%02d/%04d e': %.2f\n", giorno, mese, anno, totale);
}

