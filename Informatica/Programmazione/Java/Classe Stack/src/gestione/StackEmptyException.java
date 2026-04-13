package gestione;

public class StackEmptyException extends Exception {
    public StackEmptyException (){
        super("Stack vuoto: impossibile eseguire pop");
    }
    public String toString() {
        return "Stack vuoto: impossibile eseguire pop";
    }
}