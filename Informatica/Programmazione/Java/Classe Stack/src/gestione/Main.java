package gestione;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(2);

        try {
            stack.push(1);
            stack.push(2);

        } catch (StackFullException e) {
            System.out.println("Errore: " + e.getMessage());

        } 

        try {
            stack.push(3);

        } catch (StackFullException e) {
            System.out.println("Errore: " + e.getMessage());

        } 

        try {
            Stack.pop());
            System.out.println("Elemento estratto: " + stack.pop());
        } catch (StackEmptyException e) {
            System.out.println("Errore durante pop: " + e.getMessage());
        }
        try {
            System.out.println("Elemento estratto: " + stack.pop());
        } catch (StackEmptyException e) {
            System.out.println("Errore durante pop: " + e.getMessage());
        }
    }
}