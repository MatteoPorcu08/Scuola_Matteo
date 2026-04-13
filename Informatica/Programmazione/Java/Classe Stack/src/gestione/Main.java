package gestione;

public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack(2);

        try {
            stack.push(1);
            System.out.println("Elemento 1 inserito nello stack.");
            stack.push(2);
            System.out.println("Elemento 2 inserito nello stack.");
        } catch (StackFullException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        try {
            stack.push(3);
            System.out.println("Elemento 3 inserito nello stack.");
        } catch (StackFullException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        try {
            stack.pop();
            System.out.println("Elementi estratti dallo stack.");
            stack.pop();
            System.out.println("Elementi estratti dallo stack.");
        } catch (StackEmptyException e) {
            System.out.println("Errore durante pop: " + e.getMessage());
        }

        try {
            stack.pop();
            System.out.println("Elementi estratti dallo stack.");
        } catch (StackEmptyException e) {
            System.out.println("Errore durante pop: " + e.getMessage());
        }
    }
}