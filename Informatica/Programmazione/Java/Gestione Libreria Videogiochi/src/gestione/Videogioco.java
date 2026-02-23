package gestione;
public class Videogioco {

    private String titolo;
    private String genere;
    private int annoUscita;
    private double prezzo;
    private boolean multiplayer;

    //Costruttore
    public Videogioco(String titolo, String genere, int annoUscita, double prezzo, boolean multiplayer) {
        this.titolo = titolo;
        this.genere = genere;
        this.annoUscita = annoUscita;
        this.prezzo = prezzo;
        this.multiplayer = multiplayer;
    }

    //Costruttore di copia
    public Videogioco(Videogioco altro) {
        this.titolo = altro.titolo;
        this.genere = altro.genere;
        this.annoUscita = altro.annoUscita;
        this.prezzo = altro.prezzo;
        this.multiplayer = altro.multiplayer;
    }

    //Metodi getter
    public String getTitolo() {
        return titolo;
    }
    public String getGenere() {
        return genere;
    }
    public int getAnnoUscita() {
        return annoUscita;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public boolean isMultiplayer() {
        return multiplayer;
    }

    //Metodo setter
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }
    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Videogioco" +"titolo='" + titolo + '\'' +", genere='" + genere + '\'' +", annoUscita=" + annoUscita +", prezzo=" + prezzo +", multiplayer=" + multiplayer +'}';

    }

    //Metodo applicaSconto
    public void applicaSconto(double percentuale) {
        if (percentuale < 0 || percentuale > 100) {
            System.out.println("Percentuale non valida. Deve essere compresa tra 0 e 100.");
            return;
        }
        double sconto = prezzo * (percentuale / 100);
        prezzo -= sconto;
    }

    //Metodo isRecente

}