#include <stdio.h>
#define N 20

typedef struct {
    int giorno, mese, anno;
} Data;

typedef struct {
    int codice;
    char titolo[20];
    char autore[20];
    int copie;
    float prezzo;
    Data dataVendita;
} Libro;

Libro libri[N];

void aggiungiLibro();
void mostraLibri();
float totaleVenduto();

int main() {
    int scelta; char continua; float tot;
    do {
        printf("\n=== GESTIONE LIBRERIA ===\n");
        printf("1) Aggiungi libro\n2) Mostra libri\n3) Totale venduto anno\nScelta: "); 
        scanf("%d",&scelta);
        switch(scelta){
            case 1: 
            aggiungiLibro(); break;
            case 2: 
            mostraLibri(); break;
            case 3: 
            tot = totaleVenduto(); printf("Totale venduto: %.2f\n", tot); break;
            default: 
            printf("Scelta non valida\n");
        }
        printf("Continua? (S/N) "); 
        scanf(" %c", &continua);
    } while(continua=='S'||continua=='s');
}

void aggiungiLibro() {
    for(int i=0;i<N;i++){
        if(libri[i].codice==0){
            printf("Codice libro: "); 
            scanf("%d",&libri[i].codice);
            printf("Titolo: "); 
            scanf("%s", libri[i].titolo);
            printf("Autore: "); 
            scanf("%s", libri[i].autore);
            printf("Copie vendute: "); 
            scanf("%d",&libri[i].copie);
            printf("Prezzo unitario: "); 
            scanf("%f",&libri[i].prezzo);
            printf("Data vendita (gg mm aaaa): "); 
            scanf("%d %d %d",&libri[i].dataVendita.giorno,&libri[i].dataVendita.mese,&libri[i].dataVendita.anno);
            printf("Libro aggiunto!\n");
            return;
        }
    }
    printf("Archivio pieno!\n");
}

void mostraLibri() {
    int count=0;
    for(int i=0;i<N;i++)
        if(libri[i].codice!=0){
            count++;
            printf("\nLibro %d: %d %s %s %d %.2f %02d/%02d/%d\n", count, libri[i].codice, libri[i].titolo, libri[i].autore, libri[i].copie, libri[i].prezzo, libri[i].dataVendita.giorno, libri[i].dataVendita.mese, libri[i].dataVendita.anno);
        }
    if(count==0) {
        printf("Nessun libro registrato.\n");
    }
}

float totaleVenduto() {
    int anno; float tot=0;
    printf("Inserisci anno: ");     
    scanf("%d",&anno);
    for(int i=0;i<N;i++){
        if(libri[i].codice!=0 && libri[i].dataVendita.anno==anno) tot += libri[i].copie * libri[i].prezzo;
    }
    return tot;
}