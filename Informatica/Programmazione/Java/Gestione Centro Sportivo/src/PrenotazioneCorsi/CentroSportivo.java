package PrenotazioneCorsi;

public class CentroSportivo {
    Corso[] corsi = new Corso[10];
    int numeroCorsi = 0;

    //Costruttore
    public CentroSportivo() {
        for (int i = 0; i < corsi.length; i++) {
            corsi[i] = null;
        }
    }


}
