#include <stdio.h>
#define N 100 

void carica(int A [], int n);
void stampa(int A [], int n);
int max (int arr[] , int n);
int min (int arr[] , int n);
float media (int arr[] , int n);
void riordinamento (int arr[] , int n);

int main() {
    int A[N];
    int n;
    int massimo,minimo;
    float Media;
    int scelta;

    printf("Quanti valori desideri inserire?:");
    scanf("%d", &n);
    
    carica(A, n);

    printf("\n\n");

    do {
        printf("\nScegli una delle seguenti opzioni:\n");
        printf("1. Stampa\n");
        printf("2. Massimo\n");
        printf("3. Minimo\n");
        printf("4. Media\n");
        printf("5. Riordinamento\n");
        printf("6. Esci\n");
        
        scanf("%d", &scelta);

        switch (scelta) {
            case 1:  
                stampa(A, n);
                break; 
            case 2: 
                massimo = max(A, n);
                printf("Il massimo elemento e': %d \n", massimo);
                break;
            case 3:
                minimo = min(A, n);
                printf("Il minimo elemento e': %d \n", minimo);
                break;
            case 4:
                Media = media(A, n);
                printf("La media degli elementi e': %.2f \n", Media);
                break;
            case 5:
                printf("Vettore ordinato: ");
                riordinamento(A, n);
                stampa(A, n);
                break;
            case 6:
                printf("Arrivederci!\n");
                break;
            default:
                printf("Scelta non valida!\n");
        }
    } while (scelta != 6);

    return 0;
}


// procedura carica che carica i valori in un array
void carica(int A [], int n) { // carica un vettore di n elementi con valori casuali
    int cont;
    for (cont=0; cont<n ; cont++) { // ciclo per caricare i valori
        printf ("\nA [%d] = ", cont); // stampa l'indice
        scanf("%d", &A[cont]); // legge il valore
    }
}

// procedura stampa che stampa i valori di un array
void stampa(int A [], int n) { // stampa i valori di un vettore di n elementi
    int cont;
    for (cont=0; cont<n ; cont++) { // ciclo per stampare i valori
        printf ("\nA [%d] = %d", cont, A[cont]); // stampa l'indice e il valore
    }
}   

// funzione max che trova il massimo elemento di un array
int max (int arr[] , int n) { // trova il massimo elemento di un vettore di n elementi
    int max = arr[0]; // inizializza max con il primo elemento
    int i; // contatore per il ciclo
    for (i=1; i<n; i++) { // ciclo per trovare il massimo elemento
        if (arr[i] > max) { // se l'elemento attuale è maggiore di max
            max = arr[i]; // allora max diventa l'elemento attuale
        } 
        else { // se l'elemento attuale non è maggiore di max
            max = max; // allora max rimane uguale
        }
    }
            return max; // restituisce il massimo elemento
} 

// funzione min che trova il minimo elemento di un array
int min (int arr[] , int n) { // trova il minimo elemento di un vettore di n elementi
    int min = arr[0]; // inizializza min con il primo elemento
    int i; // contatore per il ciclo
    for (i=1; i<n ; i++) { // ciclo per trovare il minimo elemento
        if (arr[i] > min) { // se l'elemento attuale è maggiore di min
            min = min; // allora min rimane uguale
        }
        else { // se l'elemento attuale non è maggiore di min
            min = arr[i]; // allora min diventa l'elemento attuale
        }
    }
        return min; // restituisce il minimo elemento
}

// funzione media che trova la media degli elementi di un array
float media (int arr[] , int n) { // trova la media degli elementi di un vettore di n elementi
    int totale = 0; // inizializza la somma a 0
    int i; // contatore per il ciclo
    for (i=0; i<n; i++) { // ciclo per sommare gli elementi
        totale = totale + arr[i]; // somma gli elementi
    }
        float media = (float) totale / n; // calcola la media
        return media; // restituisce la media
}

// funzione riordinamento che riordina gli elementi di un array in ordine crescente
void riordinamento (int arr[] , int n) { // riordina gli elementi
    for (int i = 0; i < n - 1; i++) { // ciclo per confrontare gli elementi
        for (int j = 0; j < n - i - 1; j++) { // ciclo per confrontare gli elementi
            if (arr[j] > arr[j + 1]) { // se l'elemento attuale è maggiore dell'elemento successivo
                int temp = arr[j]; // salva l'elemento attuale in una variabile temporanea
                arr[j] = arr[j + 1]; // sostituisce l'elemento attuale con l'elemento successivo
                arr[j + 1] = temp; // sostituisce l'elemento successivo con l'elemento temporaneo
            }
        }
    }
}