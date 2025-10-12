#include <stdio.h>
#define N 20

typedef struct {
    int giorno, mese, anno;
} Data;

typedef struct {
    int id;
    char nome[20];
    char cognome[20];
    float stipendio;
    Data dataAssunzione;
} Dipendente;

Dipendente dipendenti[N];

void aggiungiDipendente();
void mostraDipendenti();
float sommaStipendi();

int main() {
    int scelta; char continua; float totale;
    do {
        printf("\n=== GESTIONE DIPENDENTI ===\n");
        printf("1) Aggiungi dipendente\n2) Mostra dipendenti\n3) Somma stipendi\nScelta: ");
        scanf("%d", &scelta);
        switch(scelta){
            case 1: aggiungiDipendente(); break;
            case 2: mostraDipendenti(); break;
            case 3: totale = sommaStipendi(); printf("Totale stipendi: %.2f\n", totale); break;
            default: printf("Scelta non valida\n");
        }
        printf("Continua? (S/N) "); scanf(" %c", &continua);
    } while(continua=='S'||continua=='s');
}

void aggiungiDipendente() {
    for(int i=0;i<N;i++){
        if(dipendenti[i].id==0){
            printf("ID dipendente: "); scanf("%d",&dipendenti[i].id);
            printf("Nome: "); scanf("%s", dipendenti[i].nome);
            printf("Cognome: "); scanf("%s", dipendenti[i].cognome);
            printf("Stipendio: "); scanf("%f",&dipendenti[i].stipendio);
            printf("Data assunzione (gg mm aaaa): "); scanf("%d %d %d",&dipendenti[i].dataAssunzione.giorno,&dipendenti[i].dataAssunzione.mese,&dipendenti[i].dataAssunzione.anno);
            printf("Dipendente aggiunto!\n");
            return;
        }
    }
    printf("Archivio pieno!\n");
}

void mostraDipendenti() {
    int count=0;
    for(int i=0;i<N;i++){
        if(dipendenti[i].id!=0){
            count++;
            printf("\nDipendente %d: %d %s %s %.2f %02d/%02d/%d\n", count, dipendenti[i].id, dipendenti[i].nome, dipendenti[i].cognome, dipendenti[i].stipendio, dipendenti[i].dataAssunzione.giorno, dipendenti[i].dataAssunzione.mese, dipendenti[i].dataAssunzione.anno);
        }
    }
    if(count==0) {
        printf("Nessun dipendente registrato.\n");
    }
}

float sommaStipendi() {
    float totale = 0;
    for(int i=0;i<N;i++)
        if(dipendenti[i].id!=0) {
            totale += dipendenti[i].stipendio;
        }
    return totale;
}