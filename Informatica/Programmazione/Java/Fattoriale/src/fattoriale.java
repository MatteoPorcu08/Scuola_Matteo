public class fattoriale {
    public static void main(String[] args){
        int varA = 5;
        int fattoriale = 1;

        
        // Calcolo del fattoriale
        for(int i = varA; i > 0; i--){
            fattoriale = fattoriale * i;
        }

        System.out.println("Il fattoriale di " + varA + " è: " + fattoriale);
    }
}
