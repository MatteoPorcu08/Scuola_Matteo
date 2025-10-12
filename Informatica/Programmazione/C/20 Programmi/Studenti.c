#include <stdio.h>
#define N 20

typedef struct {
    int giorno, mese, anno;
} Data;

typedef struct {
    int matricola;
    char nome[20];
    char cognome[20];
    float media;
    Data dataIscrizione;
} Studente;

Studente studenti[N];

void aggiungiStudente();
void mostraStudenti();
float mediaGenerale();

int main() {
    int scelta; char continua; float media;
    do {
        printf("\n=== GESTIONE STUDENTI ===\n");
        printf("1) Aggiungi studente\n2) Mostra studenti\n3) Media generale\nScelta: "); 
        scanf("%d",&scelta);
        switch(scelta){
            case 1: 
                aggiungiStudente(); break;
            case 2: 
                mostraStudenti(); break;
            case 3: media = mediaGenerale(); 
                printf("Media generale: %.2f\n", media); break;
            default:
                printf("Scelta non valida\n");
        }
        printf("Continua? (S/N) "); 
        scanf(" %c", &continua);
    } while(continua=='S'||continua=='s');
}

void aggiungiStudente() {
    for(int i=0;i<N;i++){
        if(studenti[i].matricola==0){
            printf("Matricola: "); 
            scanf("%d",&studenti[i].matricola);
            printf("Nome: "); 
            scanf("%s", studenti[i].nome);
            printf("Cognome: "); 
            scanf("%s", studenti[i].cognome);
            printf("Media voti: "); 
            scanf("%f",&studenti[i].media);
            printf("Data iscrizione (gg mm aaaa): "); 
            scanf("%d %d %d",&studenti[i].dataIscrizione.giorno,&studenti[i].dataIscrizione.mese,&studenti[i].dataIscrizione.anno);
            printf("Studente aggiunto!\n");
            return;
        }
    }
    printf("Archivio pieno!\n");
}

void mostraStudenti() {
    int count=0;
    for(int i=0;i<N;i++)
        if(studenti[i].matricola!=0){
            count++;
            printf("\nStudente %d: %d %s %s %.2f %02d/%02d/%d\n", count, studenti[i].matricola, studenti[i].nome, studenti[i].cognome, studenti[i].media, studenti[i].dataIscrizione.giorno, studenti[i].dataIscrizione.mese, studenti[i].dataIscrizione.anno);
        }
    if(count==0) {
        printf("Nessuno studente registrato.\n");
    }
}

float mediaGenerale() {
    float tot=0; int count=0;
    for(int i=0;i<N;i++)
        if(studenti[i].matricola!=0){
            tot += studenti[i].media;
            count++;
        }
    if(count==0) {
        printf("Nessuno studente registrato.\n");
    }
    return 0;
    return tot/count;
}