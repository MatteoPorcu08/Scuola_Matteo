package operaio;
public class GestoreDipendenti {
    public Dipendente[] dipendenti;
    private int numeroDipendenti;

    public GestoreDipendenti(int capacita) {
        dipendenti = new Dipendente[capacita];
        numeroDipendenti = 0;
    }

    // Metodo aggiungiDipendente(Dipendente d)
    public void aggiungiDipendente(Dipendente d) {
        if (numeroDipendenti < dipendenti.length) {
            dipendenti[numeroDipendenti] = d;
            numeroDipendenti++;
        } else {
            System.out.println("Capacità massima raggiunta. Impossibile aggiungere il dipendente.");
        }
    }

    // Metodo calcolaStipendioTotale()
    public double calcolaStipendioTotale() {
        double totale = 0;
        for (int i = 0; i < numeroDipendenti; i++) {
            totale += dipendenti[i].calcolaStipendio();
        }
        return totale;
    }

    // Metodo stampaTuttiIDipendenti()
    public void stampaTuttiIDipendenti() {
        for (int i = 0; i < numeroDipendenti; i++) {
            System.out.println(dipendenti[i]);
        }
    }
}