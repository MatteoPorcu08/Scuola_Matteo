#include <stdio.h>
#include <string.h>

int main() {
    char saluto[]="Ciao";
    char nome[11];
    char eta [100];
   
    printf("%s!", saluto);
   
    printf("\nCome ti chiami?");
    scanf("%s", nome);

    printf ("\nQuanti anni hai?");
    scanf("%s", eta);
    
    printf("\n%s, %s, hai %s anni!", saluto, nome, eta);
   
  

    
   
}