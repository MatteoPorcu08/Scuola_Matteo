public class fattoriale {
    public static void main(String[] args){
        int varA;
        int fattoriale = 1;

        // Input del numero
        varA = input.nextInt("Inserisci un numero intero positivo: ");
        
        // Calcolo del fattoriale
        for(int i = varA; i > 0; i--){
            fattoriale = fattoriale * i;
        }

        System.out.println("Il fattoriale di " + varA + " è: " + fattoriale);
    }
}
