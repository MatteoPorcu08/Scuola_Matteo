package pacchetto;

public class Brano {

    // ATTRIBUTI
    private String titolo;
    private String autore;
    private float durata;
    private int NumeroTraccia;

    // COSTRUTTORE
    public Brano(String titolo, String autore, float durata, int numero_traccia) {
        this.titolo = titolo;
        this.autore = autore;
        this.durata = durata;
        this.NumeroTraccia = numero_traccia;
    }

    // COSTRUTTORE DI COPIA
    public Brano(Brano b) {
        this.titolo = b.titolo;
        this.autore = b.autore;
        this.durata = b.durata;
        this.NumeroTraccia = b.NumeroTraccia;
    }

    // METODI GET
    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    public float getDurata() {
        return durata;
    }
    public int getNumeroTraccia() {
        return NumeroTraccia;
    }

    // METODO SET
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public void setDurata(float durata) {
        this.durata = durata;
    }
    public void setNumeroTraccia(int numero_traccia) {
        this.NumeroTraccia = numero_traccia;
    }
    
    // METODO TO STRING
    @Override
    public String toString() {
        return "Brano titolo=" + titolo + ", autore=" + autore + ", durata=" + durata + ", numero_traccia=" + NumeroTraccia + "\n";
    }
}