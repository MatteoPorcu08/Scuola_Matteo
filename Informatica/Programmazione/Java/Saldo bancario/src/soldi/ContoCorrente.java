package soldi;

public class ContoCorrente {
    private double saldo;

    // Costruttore
    public ContoCorrente(double saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    // Metodo verificaSaldo(double importo)
    public boolean verificaSaldo(double importo) {
        try {
            if (importo > saldo) {
                throw new SaldoInsufficienteException();
            } else {
                return true;
            }
        } catch (SaldoInsufficienteException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    // Metodo effettuaOperazione(double importo)
    public boolean effettuaOperazione(double importo) {
        if (verificaSaldo(importo)) {
            saldo -= importo;
            return true;
        } else {
            return false;
        }
    }

}
