#include <stdio.h>

int max(int a, int b, int c);
int min(int a, int b, int c);
float media(int a, int b, int c);

int main() {
    int x, y, z, massimo, minimo, scelta;
    float avg;
    char n;
    printf("Questo programma calcola il massimo, il minimo e la media tra 3 numeri");

do {
   
    printf("\nInserisci il primo numero: ");
    scanf("%d", &x);
    printf("\nInserisci il secondo numero: ");
    scanf("%d", &y);
    printf("\nInserisci il terzo numero: ");
    scanf("%d", &z);
    do {
        printf("\nScegli cosa vuoi visualizzare:\n");
        printf( "1) Max");
        printf( "2) Min");
        printf( "3) Media");
        scanf("%d", &scelta);
   
        switch(scelta) {
            case 1:
                massimo=max(x, y, z);
                printf("\nIl massimo tra i 3 numeri e' %d", massimo);
                break;
            case 2:
                minimo=min(x, y, z);
                printf("Il minimo tra i 3 numeri e' %d", minimo);
                break;    
            case 3:
                avg=media(x, y, z);
                printf("\nLa media tra i 3 numeri e' %.2f", avg);
                break;        
            default:
                printf("\nHai sbagliato inserendo la scelta.");    
                break;
    }
    printf("\nVuoi visualizzare un altro dato? S/N");
    scanf(" %c", &n);
    } while(n=='s'||n=='S');
   
    printf("\nVuoi inserire altri numeri? S/N");
    scanf(" %c", &n);
}    while(n=='s'||n=='S');
   
}


//Definizione Funzione max

int max(int a, int b, int c) {
     int s;
     if(a>=b&&a>=c) {
         s=a;
     }
    else if (b>=a&&b>=c) {
        s=b;
    }
    else {
        s=c;    
    }
   
    return s;
}

//Definizione Funzione min

int min(int a, int b, int c) {
    int min_val=a;
    if (b<min_val) {
        min_val=b;
    }
    if(c<min_val) {
        min_val=c;
    }
    return min_val;
}

//Definizione Funzione min

float media(int a, int b, int c) {
    float m=(float)(a+b+c)/3;
    return m;
}