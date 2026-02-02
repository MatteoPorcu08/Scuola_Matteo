package pacchetto;

public class CD {
    private static final int NUM_BRANI=50;
    private Brano brani[];
    private String titolo;
    private String CasaEditrice;
    private int AnnoUscita;
    private double DurataTotale;

    int numeroBrani = 0;

    // COSTRUTTORE
    public CD(String titolo, String casaEditrice, int annoUscita) {
        this.titolo = titolo;
        this.CasaEditrice = casaEditrice;
        this.AnnoUscita = annoUscita;
        this.brani = new Brano[NUM_BRANI];
    }

    //COSTRUTTORE DI COPIA
    public CD(CD c) {
        this.titolo = c.titolo;
        this.CasaEditrice = c.CasaEditrice;
        this.AnnoUscita = c.AnnoUscita;
        this.brani = new Brano[NUM_BRANI];
        for (int i = 0; i < c.AnnoUscita; i++) {
            this.brani[i] = new Brano(c.brani[i]);
        }
    }

    // METODI GET
    public String getTitolo() {
        return titolo;
    }
    public String getCasaEditrice() {
        return CasaEditrice;
    }
    public int getAnnoUscita() {
        return AnnoUscita;
    }
    public Brano getBrano(int i) {
        if (i >= 0 && i < AnnoUscita) {
            return brani[i];
        }
        return null;
    }

    // METODI SET
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setCasaEditrice(String casaEditrice) {
        CasaEditrice = casaEditrice;
    }
    public void setAnnoUscita(int annoUscita) {
        AnnoUscita = annoUscita;
    }
    public void setBrano(Brano b, int i) {
        if (i >= 0 && i < NUM_BRANI) {
            brani[i] = new Brano(b);
        }
    }

    //METODO TO STRING
    @Override
    public String toString() {
        return "CD titolo=" + titolo + ", CasaEditrice=" + CasaEditrice + ", AnnoUscita=" + AnnoUscita + "\n";
    }

    // METODO AGGIUNGI BRANO
    public String aggiungiBrano(Brano b) {
        if (numeroBrani < 50) {
            brani[numeroBrani] = b;
            numeroBrani++;
            return "Brano aggiunto correttamente";
        }
        return "Impossibile aggiungere il brano: il CD è pieno";
    }

    //METODO RICERCA BRANO
    public Brano cercaBrano(int posizione) {
        if (posizione >= 0 && posizione < numeroBrani) {
            return brani[posizione];
        }
        return null;
    }

    //METODO RIMUOVI BRANO
    public String rimuoviBrano(int posizione) {
        if (posizione >= 0 && posizione < numeroBrani) {
            for (int i = posizione; i < numeroBrani - 1; i++) {
                brani[i] = brani[i + 1];
            }
            brani[numeroBrani - 1] = null;
            numeroBrani--;
            return "Brano rimosso correttamente";
        }
        return "Impossibile rimuovere il brano: posizione non valida";
    }
    
    // METODO DURATA TOTALE
    public double durataTotale() {
        double somma = 0;
        for (int i = 0; i < numeroBrani; i++) {
            somma += brani[i].getDurata();
        }
        return somma;
    }

    // METODO BRANI SOTTO 4 MINUTI
    public int braniSotto4Minuti() {
        int contatore = 0;
        for (int i = 0; i < numeroBrani; i++) {
            if (brani[i].getDurata() < 4) {
                contatore++;
            }
        }
        return contatore;
    }
}