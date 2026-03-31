package soldi;

public class Main {
    public static void main(String[] args) {
        ContoCorrente conto = new ContoCorrente(100); // Saldo iniziale di 100

        try {
            conto.verificaSaldo(150); // Verifica se è possibile effettuare un'operazione di 150
            conto.effettuaOperazione(150); // Effettua l'operazione di 150
        } catch (SaldoInsufficienteException e) {
            System.out.println(e.toString()); // Stampa il messaggio di eccezione se il saldo è insufficiente
        }

        finally {
            System.out.println("Operazione completata.");
        }
    }
}