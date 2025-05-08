/*Ci sono 3 giocatori che devono lanciare un dado.
Memorizza i nomi di ciascun giocatore e il relativo risultato.
Dopo aver stampato i risultati, scrivi chi è il giocatore vincitore (vince chi ha ottenuto il risultato maggiore).*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#include <ctype.h>

int main () {
    
    char giocatori [3][20];
    int risultati [3];
    int max = 0;
    int vincitori [3];
    int num_vincitori = 0;
    int i;

    srand(time(NULL)); // Inizializza il generatore di numeri casuali

    printf("Hey!! Benvenuto al gioco dei dadi!\n"); // stampa un messaggio di benvenuto

    printf("Inserisci i nomi dei 3 giocatori:\n"); // chiede i nomi dei giocatori

    for (i = 0; i < 3; i++) { // ciclo per inserire i nomi dei giocatori
        printf("Giocatore %d: ", i + 1); 
        gets (giocatori[i]); // legge il nome del giocatore
        printf("\n");
        if ( giocatori [i] [0]>= 97 && giocatori[i] [0] <= 122 ) { // controllo se la prima lettera è minuscola
            printf ("La prima lettera del tuo nome e minuscola. La trasformo in maiuscola .\n");    
            giocatori[i] [0]= toupper(giocatori[i][0]); // cambio la prima lettera in maiuscola
            printf("Il tuo nome e': %s\n", giocatori[i]);
            }
            else {
                printf("Il tuo nome e' stato inserito corretamente: %s\n", giocatori);
                }
        }
        
        

        for (i = 0; i < 3; i++) { // ciclo per generare un numero randomico per ogni giocatore
            risultati[i] = rand() % 6 + 1; // genera un numero random
            }
            for (i = 0; i < 3; i++) { // ciclo per stampare i risultati dei giocatori
                printf("%s ha ottenuto %d\n", giocatori[i], risultati[i]);
                if (risultati[i] > max) { // ciclo per trovare il giocatore con il risultato più alto o il pareggio
                    max = risultati[i]; // se il risultato è più alto lo salva
                    num_vincitori = 1; // resetta il numero di vincitori
                    vincitori[0] = i; // salva la posizione del giocatore con il risultato più alto
                    }
                else if (risultati[i] == max) { // se il risultato è uguale al massimo
                    vincitori[num_vincitori] = i; // salva la posizione del giocatore con il risultato più alto
                    num_vincitori++; // incrementa il numero di vincitori
                    }
        
                    }
                    if (num_vincitori == 1) { // se c'è un solo vincitore
                        printf("Il vincitore e' %s con %d\n", giocatori[vincitori[0]], max ); // stampa il vincitore
                    }
                    else { // se ci sono più vincitori
                        printf("I vincitori sono: \n"); // stampa i vincitori
                        for (i = 0; i < num_vincitori; i++) {
                            printf("%s con %d\n", giocatori[vincitori[i]], max );
                        }
                    }
                    
                    return 0;

}