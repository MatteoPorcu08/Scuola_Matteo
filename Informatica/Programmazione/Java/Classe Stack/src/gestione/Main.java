package gestione;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(2);

        stack.push(1);
        stack.push(2);
        stack.push(3); // Stack pieno, non viene aggiunto

        try {
            
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }

        try {
            stack.push(4);
            System.out.println(stack.pop()); // Stampa 4
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}