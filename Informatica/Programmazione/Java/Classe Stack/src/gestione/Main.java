package gestione;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(2);

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());

        } finally {
            System.out.println("Operazione terminata");
        }

        try {
            System.out.println("Elemento estratto: " + stack.pop());
            System.out.println("Elemento estratto: " + stack.pop());
            System.out.println("Elemento estratto: " + stack.pop());
        } catch (Exception e) {
            System.out.println("Errore durante pop: " + e.getMessage());
        }
    }
}