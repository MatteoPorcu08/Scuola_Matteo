package gestione;

public class StackEmptyException extends Exception {
    public String toString() {
        return "Stack vuoto: impossibile eseguire pop";
    }
}