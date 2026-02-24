package gestione;

/**
 * Gestione di una libreria di videogiochi
 * @author Matteo
 * @version 3.1
 * Data 23/02/2026
 */
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
        if (this.titolo !=null){
            this.titolo = titolo;
        }else {
            System.out.println("Il titolo non può essere null");
        }
        
    }
    public void setGenere(String genere) {
        if (this.genere != null) {
            this.genere = genere;
        } else {
            System.out.println("Il genere non può essere null");
        }
    }
    public void setAnnoUscita(int annoUscita) {
        if (annoUscita > 0) {
            this.annoUscita = annoUscita;
        } else {
            System.out.println("L'anno di uscita non può essere 0 o negativo");
        }
    }
    public void setPrezzo(double prezzo) {
        if (prezzo >= 0) {
            this.prezzo = prezzo;
        } else {
            System.out.println("Il prezzo non può essere negativo");
        }
    }
    public void setMultiplayer(boolean multiplayer) {
        if (this.multiplayer != multiplayer) {
            this.multiplayer = multiplayer;
        } else {
            System.out.println("Il valore di multiplayer è già impostato su " + multiplayer);
        }
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Videogioco" +"titolo='" + titolo + '\'' +", genere='" + genere + '\'' +", annoUscita=" + annoUscita +", prezzo=" + prezzo +", multiplayer=" + multiplayer +'}';

    }

    /**
     * Applica uno sconto al prezzo del videogioco
     * @param percentuale percentuale di sconto da applicare (0-100)
     * @return restituisce il nuovo prezzo dopo l'applicazione dello sconto
     */
    public void applicaSconto(double percentuale) {
        if (percentuale < 0 || percentuale > 100) {
            System.out.println("Percentuale non valida. Deve essere compresa tra 0 e 100.");
            return;
        }
        double sconto = prezzo * (percentuale / 100);
        prezzo -= sconto;
    }

    /**
     * Determina se il videogioco è recente (uscito negli ultimi 4 anni)
     * @return restituisce true se il videogioco è recente, false altrimenti
     */
    public boolean isRecente() {
        if(this.annoUscita >= 2020) {
            return true;
        } else {
            return false;
        }
    }
}