package gestione;

public class StackFullException extends Exception {
    public StackFullException() {
        super("Lo stack è pieno.");
    }
    public String toString() {
        return "Lo stack è pieno.";
    }
}