/*Un'azienda desidera monitorare le vendite dei propri prodotti. Ogni vendita contiene le seguenti informazioni:
Codice della vendita (un intero)
Nome del prodotto (una stringa)
Quantità venduta (un intero)
Prezzo unitario del prodotto (un float)
Data della vendita (espressa con una struttura in cui si memorizza giorno, mese, anno)
Si desidera realizzare un programma in C che permetta di:
- Definire una struttura per memorizzare le informazioni relative a una vendita.

Specifiche:
Utilizzare una struttura con typedef per definire il tipo di dato relativo a una vendita.
Gestire la data come una sottostruttura all'interno della struttura vendita.
Prevedere un array di vendite.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
    int codice_vendita;
    char nome_prodotto;
    int quantita_venduta;
    float prezzo_prodotto;

}vendita;

typedef struct{
    int giorno;
    int mese;
    int anno;
}data;


int main(){
    vendita v1;
    data d1;


    //chiede di inserire i dati della vendita
    printf("Inserisci il codice della vendita:");
    scanf("%d",&v1.codice_vendita);
    printf("Inserisci il nome del prodotto:");
    scanf("%s",&v1.nome_prodotto);
    printf("Inserisci la quantita' della venduta:");
    scanf("%d",v1.quantita_venduta);
    printf("Inserisci il prezzo del prodotto:");
    scanf("%f",v1.prezzo_prodotto);

    //stampa i dati della vendita
    printf("Il codice della vendita e' %d:",v1.codice_vendita);
    printf("Il nome del prodotto e' %s:",v1.nome_prodotto);
    printf("La quantita della venduta e' %d:",v1.quantita_venduta);
    printf("Il prezzo del prodotto e' %f",v1.prezzo_prodotto);

    return 0;
}