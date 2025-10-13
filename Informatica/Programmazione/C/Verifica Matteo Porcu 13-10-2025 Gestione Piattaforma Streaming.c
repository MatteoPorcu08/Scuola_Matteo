#include <stdio.h>
#include <string.h>

//struttura per memorizzare la data 
typedef struct{
	int giorno;
	int mese;
	int anno;
}Data;

//struttura per memorizzare le Informazioni
 typedef struct{
	int id;
	char titolo_contenuto[50];
	int durata;
	Data data_visualizzazione;
	
}Informazioni;



int main(){
	Informazioni i1;
	int i;
	float ore;
	char scelta;
	
	
	//presentazione del programma
	printf("----Ciao! Questo programma serve per Gestire una Piattaforma Streaming----\n");
	
	//printf per inserire uno spazio
	printf("\n");
	
	// inserimento delle Informazioni
	printf("Inserisci l'id della visualizzazione:\n");
	scanf("%d",&i1.id);
	printf("Inserisci il titolo del contenuto:\n");
	scanf(" %s",i1.titolo_contenuto);
	printf("Inserisci la durata del della visualizzazione (min)\n");
	scanf("%d",&i1.durata);
	
	//inserimento della Data di vilualizzazione
	printf("Inserisci la data di visualizzazione:\n");
	printf("Giorno:");
	scanf("%d",&i1.data_visualizzazione.giorno);
	printf("Mese:");
	scanf("%d",&i1.data_visualizzazione.mese);
	printf("Anno:");
	scanf("%d",&i1.data_visualizzazione.anno);
	
	//calcolo da minuti a ore e minuti
	ore=(float)i1.durata/60;
	
	//printf per inserire uno spazio
	printf("\n");
	
	//inizializzazione i a 0
	i=0;
	
	//stampa dei dati inseriti
	printf("\n===Dati Streaming %d===\n",i+1);
	printf("L'id della visualizzazione e' %d:\n",i1.id);
	printf("Il titolo del contenuto e' %s:\n",i1.titolo_contenuto);
	printf("La durata della visualizzazione in minuti e' di %d \n",i1.durata);
	printf("La durata della visualizzazione in ore e minuti e' di %.2f \n",ore);
	printf("La data di visualizzazione e' il %d/%d/%d\n",i1.data_visualizzazione.giorno,i1.data_visualizzazione.mese,i1.data_visualizzazione.anno);
	printf("=====================");
	
	
	return 0;
	
}