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
    private String getTitolo() {
        return titolo;
        return genere;
        return durata;
        return annoUscita;
        return valutazione;
    }





}