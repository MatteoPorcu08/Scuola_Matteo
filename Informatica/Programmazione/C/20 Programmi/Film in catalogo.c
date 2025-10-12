#include <stdio.h>
#define N 20

typedef struct {
    int giorno, mese, anno;
} Data;

typedef struct {
    int id;
    char titolo[30];
    char regista[20];
    int durata;       // in minuti
    int annoUscita;
    Data dataAcquisto;
} Film;

Film catalogo[N];

void aggiungiFilm();
void mostraFilm();
float durataMedia();

int main() {
    int scelta; char continua; float media;
    do {
        printf("\n=== GESTIONE FILM ===\n");
        printf("1) Aggiungi film\n2) Mostra film\n3) Durata media\nScelta: ");
        scanf("%d",&scelta);
        switch(scelta){
            case 1: aggiungiFilm(); break;
            case 2: mostraFilm(); break;
            case 3: media = durataMedia(); printf("Durata media: %.2f minuti\n", media); break;
            default: printf("Scelta non valida\n");
        }
        printf("Continua? (S/N) "); scanf(" %c", &continua);
    } while(continua=='S'||continua=='s');
}

void aggiungiFilm() {
    for(int i=0;i<N;i++){
        if(catalogo[i].id==0){
            printf("ID film: "); scanf("%d",&catalogo[i].id);
            printf("Titolo: "); scanf("%s", catalogo[i].titolo);
            printf("Regista: "); scanf("%s", catalogo[i].regista);
            printf("Durata (minuti): "); scanf("%d",&catalogo[i].durata);
            printf("Anno uscita: "); scanf("%d",&catalogo[i].annoUscita);
            printf("Data acquisto (gg mm aaaa): "); scanf("%d %d %d",&catalogo[i].dataAcquisto.giorno,&catalogo[i].dataAcquisto.mese,&catalogo[i].dataAcquisto.anno);
            printf("Film aggiunto!\n");
            return;
        }
    }
    printf("Catalogo pieno!\n");
}

void mostraFilm() {
    int count=0;
    for(int i=0;i<N;i++)
        if(catalogo[i].id!=0){
            count++;
            printf("\nFilm %d: %d %s %s %d min Anno: %d %02d/%02d/%d\n", count, catalogo[i].id, catalogo[i].titolo, catalogo[i].regista, catalogo[i].durata, catalogo[i].annoUscita, catalogo[i].dataAcquisto.giorno, catalogo[i].dataAcquisto.mese, catalogo[i].dataAcquisto.anno);
        }
    if(count==0) printf("Nessun film registrato.\n");
}

float durataMedia() {
    float tot=0; int count=0;
    for(int i=0;i<N;i++)
        if(catalogo[i].id!=0){
            tot += catalogo[i].durata;
            count++;
        }
    if(count==0){
        printf("Nessun film registrato.\n");
    }
     return 0;
    return tot/count;
}