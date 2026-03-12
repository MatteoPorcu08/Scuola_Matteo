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

    //Metodo public int contaPerAnno(int anno)
    public int contaPerAnno(int anno) {
        if (this.annoUscita == anno) {
            return 1;
        } else {
            return 0;
        }
    }

    //Metodo public boolean aggiornaPrezzoTitolo(String titolo, double nuovoPrezzo)
    public boolean aggiornaPrezzoTitolo(String titolo, double nuovoPrezzo) {
        if (this.titolo.equals(titolo)) {
            setPrezzo(nuovoPrezzo);
            return true;
        } else {
            return false;
        }
    }

    //Metodo public Videogioco[] filtraPerPrezzoRange(double min, double max)
    public Videogioco[] filtraPerPrezzoRange(double min, double max) {
        if (min < 0 || max < 0 || min > max) {
            System.out.println("Intervallo di prezzo non valido. Assicurati che min e max siano non negativi e che min sia minore o uguale a max.");
            return new Videogioco[0];
        }
        Videogioco[] risultati = new Videogioco[1];
        int count = 0;
        if (prezzo >= min && prezzo <= max) {
            risultati[count] = this;
            count++;
        }
        return risultati;
    }

    //Metodo public Videogioco[] topNRecenti(int n)
    public Videogioco[] topNRecenti(int n) {
        if (n <= 0) {
            System.out.println("Il numero di videogiochi da restituire deve essere maggiore di 0.");
            return new Videogioco[0];
        }
        Videogioco[] risultati = new Videogioco[n];
        if (isRecente()) {
            risultati[0] = this;
        }
        return risultati;
    }

    //Metodo public String[] generiPresenti()
    public String[] generiPresenti() {
        String[] generi = new String[1];
        generi[0] = this.genere;
        return generi;
    }

    //Metodo public String[] elencoTitoli()
    public String[] elencoTitoli() {
        String[] titoli = new String[1];
        titoli[0] = this.titolo;
        return titoli;
    }

    //Metodo public Libreria merge(Libreria altra)
    //public Libreria merge(Libreria altra) {
        //Libreria nuovaLibreria = new Libreria();
        //nuovaLibreria.aggiungiVideogioco(this);
        //for (Videogioco v : altra.getVideogiochi()) {
        //    nuovaLibreria.aggiungiVideogioco(v);
        //}
        //return nuovaLibreria;
    //}

    //Metodo public boolean importaDaCSV(String csv)
}