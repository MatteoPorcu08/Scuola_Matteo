#include <stdio.h>
#define N 20

typedef struct {
    int giorno, mese, anno;
} Data;

typedef struct {
    int codice;
    char nome[20];
    int quantita;
    float prezzo;
    Data data;
} Prodotto;

Prodotto p[N];

void aggiungi();
void mostra();
float totaleAnno();

int main() {
    int scelta; char continua; float tot;
    do {
        printf("\n=== GESTIONE VENDITE ===\n");
        printf("1) Aggiungi vendita\n2) Mostra vendite\n3) Totale anno\nScelta: "); 
        scanf("%d",&scelta);
        switch(scelta){
            case 1: aggiungi(); break;
            case 2: mostra(); break;
            case 3: tot=totaleAnno(); 
            printf("Totale venduto nell'anno: %.2f\n",tot); break;
            default: 
            printf("Scelta non valida\n");
        }
        printf("Continua? (S/N) "); 
        scanf(" %c",&continua);
    } while(continua=='S'||continua=='s');
}

void aggiungi(){
    for(int i=0;i<N;i++){
        if(p[i].codice==0){
            printf("Codice prodotto: "); 
            scanf("%d",&p[i].codice);
            printf("Nome prodotto: "); 
            scanf("%s",p[i].nome);
            printf("Quantita': "); 
            scanf("%d",&p[i].quantita);
            printf("Prezzo: "); 
            scanf("%f",&p[i].prezzo);
            printf("Data vendita (gg mm aaaa): "); 
            scanf("%d %d %d",&p[i].data.giorno,&p[i].data.mese,&p[i].data.anno);
            printf("Vendita aggiunta!\n");
            return;
        }
    }
    printf("Archivio pieno!\n");
}

void mostra(){
    int count=0;
    for(int i=0;i<N;i++)
        if(p[i].codice!=0){
            count++;
            printf("\nVendita %d: %d %s %d %.2f %02d/%02d/%d\n",count,p[i].codice,p[i].nome,p[i].quantita,p[i].prezzo,p[i].data.giorno,p[i].data.mese,p[i].data.anno);
        }
    if(count==0) printf("Nessuna vendita registrata.\n");
}

float totaleAnno(){
    int anno; float tot=0;
    printf("Inserisci anno: "); 
    scanf("%d",&anno);
    for(int i=0;i<N;i++)
        if(p[i].codice!=0 && p[i].data.anno==anno) {
            tot += p[i].quantita*p[i].prezzo;
        }
    return tot;
}