package PrenotazioneCorsi;

public class Corso {
    String nome;
    String istruttore;
    int durata; // in minuti
    double costoMensile;
    int numeroIscritti;
    int capMaxIscritti; //numero massimo di partecipanti

    // Costruttore
    public Corso(String nome, String istruttore, int durata, double costoMensile,int capMaxIscritti) {
        this.nome = nome;
        this.istruttore = istruttore;
        this.durata = durata;
        this.costoMensile = costoMensile;
        this.numeroIscritti = 0; // inizialmente nessuno è iscritto
        this.capMaxIscritti = capMaxIscritti;
    }

    //Costruttore di copia
}
