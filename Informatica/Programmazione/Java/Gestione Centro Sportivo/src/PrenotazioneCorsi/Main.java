package PrenotazioneCorsi;

public class Main {
    public static void main(String[] args) {
        CentroSportivo centro = new CentroSportivo();

        Corso corso1 = new Corso("Yoga", "Mirko", 10, 25.50, 1);
        Corso corso2 = new Corso("Pilates", "Sedda", 15, 30.00, 1);
        Corso corso3 = new Corso("Zumba", "Daniela", 20, 35.75, 1);

        centro.aggiungiCorso(corso1);
        centro.aggiungiCorso(corso2);
        centro.aggiungiCorso(corso3);

        System.out.println("Corsi disponibili:");
        for (int i = 0; i < centro.numeroCorsi; i++) {
            System.out.println(centro.corsi[i].getNome());
        }

        centro.rimuoviPerNome("Pilates");
        System.out.println("\nCorsi disponibili dopo la rimozione:");
        for (int i = 0; i < centro.numeroCorsi; i++) {
            System.out.println(centro.corsi[i].getNome());
        }

            Corso corso4 = new Corso("Boxe", "Luca", 12, 28.00, 1);
            centro.aggiungiCorso(corso4);
            System.out.println("\nCorsi disponibili dopo l'aggiunta di Boxe:");
            for (int i = 0; i < centro.numeroCorsi; i++) {
                System.out.println(centro.corsi[i].getNome());
            }
    }
}