package gestione;

public class StackEmptyException extends Exception {
    public StackEmptyException() {
        super("Lo stack è vuoto.");
    }
}