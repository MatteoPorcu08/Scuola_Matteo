package gestione;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(2);

        stack.push(1);
        stack.push(2);
        stack.push(3); // Stack pieno, non viene aggiunto
    }
}