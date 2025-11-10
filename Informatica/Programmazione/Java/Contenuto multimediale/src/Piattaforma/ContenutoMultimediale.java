package Piattaforma;
public class ContenutoMultimediale {
    private String titolo;
    private String genere;//il genere del contenuto (es. "Azione", "Commedia")
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
        return "Titolo: " + titolo + "\n Genere: " + genere + "\n Durata: " + durata + " min\n Anno di Uscita: " + annoUscita + "\n Valutazione: " + valutazione + "/5.0";
    }

    //metodo ottieniCategoria()
    public String ottieniCategoria() {
    if (this.annoUscita == 2025) {
        return "Nuova Uscita";
    } else if (this.annoUscita<2005 ) {
        return "Classico";
    } else {
        return "Catalogo Standard";
    }
    }

    //metodo durataOreMinuti()
    public String durataOreMinuti() {
        int ore = this.durata / 60;
        int minuti = this.durata % 60;
        return ore + " ore e " + minuti + " minuti";
    }

    //metodo aggiornaValutazione(nuovaValutazione)
    public boolean aggiornaValutazione(double nuovaValutazione) {
        if (nuovaValutazione >= 0.0 && nuovaValutazione <= 5.0) {
            this.valutazione = nuovaValutazione;
            return true;
        } else {
            return false;
        }
    }

    //metodo confrontaValutazione(altroContenuto)
    public String confrontaValutazione(ContenutoMultimediale altroContenuto){
        if (this.valutazione > altroContenuto.valutazione) {
            return "Migliore";
        } else if (this.valutazione < altroContenuto.valutazione) {
            return "Peggiore";
        } else {
            return "Uguale";
        }
    }
}