package soldi;

public class SaldoInsufficienteException extends Exception {
    // Costruttore vuoto
    public SaldoInsufficienteException() {
        super();
    }

    // Metodo ToString
    @Override
    public String toString() {
        return "Il saldo è insufficiente per completare l'operazione.";
    }

}
