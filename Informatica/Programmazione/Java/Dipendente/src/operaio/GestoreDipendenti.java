package operaio;
public class GestoreDipendenti {
    public Dipendente[] dipendenti;
    public int numeroDipendenti;

    public GestoreDipendenti(int capacita) {
        dipendenti = new Dipendente[capacita];
        numeroDipendenti = 0;
    }

    // Metodo aggiungiDipendente(Dipendente d)
    public void aggiungiDipendente(Dipendente d) {
        try {

            if (numeroDipendenti >= dipendenti.length) {
                throw new Exception("Array pieno");
            }

            dipendenti[numeroDipendenti] = d;
            numeroDipendenti++;

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
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