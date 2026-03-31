package soldi;

public class ContoCorrente {
    private double saldo;

    // Costruttore
    public ContoCorrente(double saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    // Getter
    public double getSaldo() {
        return saldo;
    }

    // Setter
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Metodo verificaSaldo(double importo)
    public void verificaSaldo(double importo) throws SaldoInsufficienteException {
        if (importo > saldo) {
            throw new SaldoInsufficienteException();
        }
    }

    // Metodo effettuaOperazione(double importo)
    public void effettuaOperazione(double importo) throws SaldoInsufficienteException {
        verificaSaldo(importo);
        saldo -= importo;
    }
}