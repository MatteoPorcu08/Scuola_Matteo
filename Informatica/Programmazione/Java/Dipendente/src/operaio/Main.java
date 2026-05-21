package operaio;
public class Main {
    public static void main(String[] args) {
        Dipendente d1 = new DipendenteStipendiato("Mario Rossi", 2000);
        Dipendente d2 = new DipendenteOrario("Luigi Bianchi", 160, 15);
        Dipendente d3 = new DipendenteCommissione("Giovanni Verdi", 10000, 5.0);

        // Aggiungo i dipendenti a un array
        GestoreDipendenti gestore = new GestoreDipendenti(10);
        gestore.aggiungiDipendente(d1);
        gestore.aggiungiDipendente(d2);
        gestore.aggiungiDipendente(d3);

        // Stampo tutti i dipendenti
        System.out.println("Tutti i dipendenti:");
        gestore.stampaTuttiIDipendenti();

        // Calcolo e stampo lo stipendio totale
        double stipendioTotale = gestore.calcolaStipendioTotale();
        System.out.println("Stipendio totale: " + stipendioTotale);

        // Calcolo lo stipendi totale
        double stipendioTotale2 = gestore.calcolaStipendioTotale();
        System.out.println("Stipendio totale: " + stipendioTotale2);
    }
}