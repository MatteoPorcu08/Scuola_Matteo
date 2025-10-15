import java.util.Scanner; // Importa la classe Scanner per l'input da tastiera
public class fattoriale {
    public static void main(String[] args){
        int fattoriale = 1;

        // Input del numero
        Scanner input = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input
        System.out.print("Inserisci un numero intero positivo: "); // Prompt per l'utente
        int varA = input.nextInt(); // Legge un numero intero dall'input

        
        // Calcolo del fattoriale
        for(int i = varA; i > 0; i--){
            fattoriale = fattoriale * i;
        }

        System.out.println("Il fattoriale di " + varA + " è: " + fattoriale);
    }
}
