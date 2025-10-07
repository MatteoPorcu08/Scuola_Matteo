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
    int vendita;
    float prezzo_prodotto;

}vendita;


int main(){


}