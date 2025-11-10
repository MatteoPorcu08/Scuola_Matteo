package Piattaforma;
public class ContenutoMultimediale {
    private String titolo;
    private String genere;
    private int durata;//durata in minuti
    private int annoUscita;
    private double valutazione;//un punteggio da 0.0 a 5.0 che rappresenta la qualità del contenuto

    //costruttore principale
    public ContenutoMultimediale(String titolo, String genere, int durata, int annoUscita, double valutazione) {
        this.titolo = titolo;
        this.genere = genere;
        this.durata = durata;
        this.annoUscita = annoUscita;
        this.valutazione = valutazione;
    }

    //costruttore di copia
    public ContenutoMultimediale(ContenutoMultimediale altro) {
        this.titolo = altro.titolo;
        this.genere = altro.genere;
        this.durata = altro.durata;
        this.annoUscita = altro.annoUscita;
        this.valutazione = altro.valutazione;
    }

    //metodi getter
    public String getTitolo() {
        return titolo;
    }
    public String getGenere() {
        return genere;
    }
    public int getDurata() {
        return durata;
    }
    public int getAnnoUscita() {
        return annoUscita;
    }
    public double getValutazione() {
        return valutazione;
    }

    //metodi setter
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }
    public void setAnnoUscita(int annoUscita) {
        this.annoUscita = annoUscita;
    }
    public void setValutazione(double valutazione) {
        this.valutazione = valutazione;
    }
    
    //metodo toString
    public String toString() {
        return "Titolo: " + titolo + ", Genere: " + genere + ", Durata: " + durata + " min, Anno di Uscita: " + annoUscita + ", Valutazione: " + valutazione + "/5.0";
    }

    //metodo ottieniCategoria()
    public String ottieniCategoria() {
       if (this.annoUscita == 2025) {
           return "Nuova Uscita";
       } else if (this.annoUscita ) {
           return "Consigliato";
       } else {
           return "Standard";
       }





}