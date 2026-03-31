package soldi;

public class ContoCorrente {
    private double saldo;

    // Costruttore
    public ContoCorrente(double saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    // Metodo verificaSaldo(double importo)
    public void verificaSaldo(double importo) throws SaldoInsufficienteException {
        if (importo > saldo) {
            throw new SaldoInsufficienteException();
        }
    }

    // Metodo effettuaOperazione(double importo)
    public boolean effettuaOperazione(double importo) {
        try {
            verificaSaldo(importo);
            saldo -= importo;
            return true;
        } catch (SaldoInsufficienteException e) {
            System.out.println(e.toString());
            return false;
        }
    }

}