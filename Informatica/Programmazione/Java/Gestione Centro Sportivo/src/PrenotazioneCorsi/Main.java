package PrenotazioneCorsi;

public class Main {
    public static void main(String[] args) {
        CentroSportivo centro = new CentroSportivo();

        Corso corso1 = new Corso("Yoga", "Lunedì", 10, 25.50, 1);
        Corso corso2 = new Corso("Pilates", "Martedì", 15, 30.00, 1);
        Corso corso3 = new Corso("Zumba", "Mercoledì", 20, 35.75, 1);

        centro.aggiungiCorso(corso1);
        centro.aggiungiCorso(corso2);
        centro.aggiungiCorso(corso3);

        System.out.println("Corsi disponibili:");
        for (int i = 0; i < centro.numeroCorsi; i++) {
            System.out.println(centro.corsi[i].getNome());
        }
    }
}