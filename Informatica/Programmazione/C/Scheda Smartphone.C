#include <stdio.h>
#include <string.h>

struct Smartphone{
    char modello[40];
    char marca[30];
    int memoriaGB;     // memoria interna in GB
    int ramGB;         // RAM in GB
    double peso;       // peso in grammi
};

int main(){
    
    Smartphone S1,S2;

    //chiede di inserire i dati del primo telfono
    printf("Inserisci i dati del primo telefono:\n");
    printf("Che modello e' il tuo telefono?\n");
    scanf("%[^\n]s",S1.modello);
    printf("Che marca e' il tuo telefono?\n");
    scanf("%s",S1.marca);
    printf("Quanta memoria ROM ha il tuo telefono?\n");
    scanf("%d", &S1.memoriaGB);
    printf("Quanta memoria RAM ha il tuo telefono?\n");
    scanf("%d", &S1.ramGB);
    printf("Quanto pesa il tuo telefono?\n");
    scanf("%lf", &S1.peso);
    

    //chiede di inserire i dati del secondo telefono
    printf("Inserisci i dati del secondo telefono:\n");
    printf("Che modello e' il tuo telefono?\n");
    scanf("%s[^\n]%*c",S2.modello);
    printf("Che marca e' il tuo telefono?\n");
    scanf("%s",S2.marca);
    printf("Quanta memoria ROM ha il tuo telefono?\n");
    scanf("%d", &S2.memoriaGB);
    printf("Quanta memoria RAM ha il tuo telefono?\n");
    scanf("%d", &S2.ramGB);
    printf("Quanto pesa il tuo telefono?\n");
    scanf("%lf", &S2.peso);
    





}