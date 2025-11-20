import java.util.Scanner; // Importa la classe Scanner per la lettura dell'input

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input da console

        System.out.print("Qual è il tuo nome? ");
        String name = scanner.nextLine(); // Legge una linea di testo dall'input

        System.out.print("Qual è la tua età? ");
        int age = scanner.nextInt(); // Legge un intero dall'input

        System.out.println("Ciao " + name + ", hai " + age + " anni.");

        scanner.close(); // Chiude lo scanner per liberare le risorse
    }
}