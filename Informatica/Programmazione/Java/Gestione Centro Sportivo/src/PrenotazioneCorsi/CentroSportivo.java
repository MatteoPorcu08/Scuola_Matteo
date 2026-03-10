package PrenotazioneCorsi;

public class CentroSportivo {
    Corso[] corsi = new Corso[10];
    int numeroCorsi = 0;

    //Costruttore
    public CentroSportivo() {
        for (int i = 0; i < corsi.length; i++) {
            corsi[i] = null;
            numeroCorsi = 0;
        }
    }

    //Costruttore di copia
    public CentroSportivo(CentroSportivo centro) {
        this.corsi = new Corso[10];
        for (int i = 0; i < centro.corsi.length; i++) {
            if (centro.corsi[i] != null) {
                this.corsi[i] = new Corso(centro.corsi[i]);
            } else {
                this.corsi[i] = null;
            }
        }
        this.numeroCorsi = centro.numeroCorsi;
    }

    //Metodo public boolean aggiungiCorso(Corso c)
    public boolean aggiungiCorso(Corso c) {
        if (numeroCorsi < corsi.length) {
            corsi[numeroCorsi] = c;
            numeroCorsi++;
            return true;
        } else {
            System.out.println("Impossibile aggiungere il corso " + c.getNome() + ". Il centro sportivo è pieno.");
            return false;
        }
    }

    //Metodo public boolean rimuoviCorso(int posizione)
    public boolean rimuoviCorso(int posizione) {
        if (posizione >= 0 && posizione < numeroCorsi && corsi[posizione] != null) {
            for (int i = posizione; i < numeroCorsi - 1; i++) {
                corsi[i] = corsi[i + 1];
            }
            corsi[numeroCorsi - 1] = null;
            numeroCorsi--;
            return true;
        } else {
            System.out.println("Posizione " + posizione + " non valida. Impossibile rimuovere il corso.");
            return false;
        }
    }

    //Metodo public boolean rimuoviPerNome(String nome)
    public boolean rimuoviPerNome(String nome) {
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i].getNome().equals(nome)) {
                return rimuoviCorso(i);
            }
        }
        System.out.println("Corso con nome " + nome + " non trovato. Impossibile rimuovere.");
        return false;
    }

    //Metodo public Corso cercaCorso(String nome)
    public Corso cercaCorso(String nome){
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i].getNome().equals(nome)) {
                return corsi[i];
            }
        }
        System.out.println("Corso con nome " + nome + " non trovato.");
        return null;
    }

    //Metodo public String visualizzaCorsi()
    public String visualizzaCorsi(){
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i] != null) {
                System.out.println(corsi[i].toString());
            }
        }
        return "";
    }

    //Metodo public int contaCorsiAffollati()
    public int contaCorsiAffollati(){
        int contatore = 0;
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i] != null && corsi[i].corsoAffollato()) {
                contatore++;
            }
        }
        return contatore;
    }

    //Metodo public double incassoTotaleMensile()
    public double incassoTotaleMensile(){
        double incassoTotale = 0;
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i] != null) {
                incassoTotale += corsi[i].getCostoMensile() * corsi[i].getNumeroIscritti();
            }
        }
        return incassoTotale;
    }

    //Metodo public double durataMedia()
    public double durataMedia() {
        if (numeroCorsi == 0) {
            return 0;
        }
        int durataTotale = 0;
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i] != null) {
                durataTotale += corsi[i].getDurata();
            }
        }
        return (double) durataTotale / numeroCorsi;
    }

    //Metodo public Corso corsoConPiuIscritti()
    public Corso corsoConPiuIscritti(){
        if (numeroCorsi == 0) {
            return null;
        }
        Corso corsoPiuIscritti = corsi[0];
        for (int i = 1; i < numeroCorsi; i++) {
            if (corsi[i] != null && corsi[i].getNumeroIscritti() > corsoPiuIscritti.getNumeroIscritti()) {
                corsoPiuIscritti = corsi[i];
            }
        }
        return corsoPiuIscritti;
    }

    //Metodo public Corso[] filtraPerIstruttore(String istruttore)
    public Corso[] filtraPerIstruttore(String istruttore){
        Corso[] corsiFiltrati = new Corso[numeroCorsi];
        int contatore = 0;
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i] != null && corsi[i].getIstruttore().equals(istruttore)) {
                corsiFiltrati[contatore] = corsi[i];
                contatore++;
            }
        }
        return corsiFiltrati;
    }

    //Metodo public void applicaScontoAiCorsiMenoFrequentati(double percentuale)
    public void applicaScontoAiCorsiMenoFrequentati(double percentuale){
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i] != null && corsi[i].getNumeroIscritti() < 5) {
                double nuovoCosto = corsi[i].getCostoMensile() * (1 - percentuale / 100);
                corsi[i].setCostoMensile(nuovoCosto);
            }
        }
    }

    //Metodo public CentroSportivo mergeCentro(CentroSportivo altro)
    public CentroSportivo mergeCentro(CentroSportivo altro) {
        CentroSportivo centroUnito = new CentroSportivo();
        for (int i = 0; i < this.numeroCorsi; i++) {
            if (this.corsi[i] != null) {
                centroUnito.aggiungiCorso(new Corso(this.corsi[i]));
            }
        }
        for (int i = 0; i < altro.numeroCorsi; i++) {
            if (altro.corsi[i] != null) {
                centroUnito.aggiungiCorso(new Corso(altro.corsi[i]));
            }
        }
        return centroUnito;
    }

    //Metodo public boolean spostaCorso(int from, int to)
    public boolean spostaCorso(int from, int to) {
        if (from >= 0 && from < numeroCorsi && to >= 0 && to < numeroCorsi) {
            Corso temp = corsi[from];
            corsi[from] = corsi[to];
            corsi[to] = temp;
            return true;
        } else {
            System.out.println("Posizioni non valide. Impossibile spostare il corso.");
            return false;
        }
    }

    //Metodo public String esportaCSV()
    public String esportaCSV() {
        StringBuilder csv =new StringBuilder();
        for(int i = 0; i < numeroCorsi; i++) {
            if (corsi[i] != null) {
                csv.append(corsi[i].getNome()).append(",")
                   .append(corsi[i].getIstruttore()).append(",")
                   .append(corsi[i].getDurata()).append(",")
                   .append(corsi[i].getCostoMensile()).append(",")
                   .append(corsi[i].getNumeroIscritti()).append(",")
                   .append(corsi[i].getCapMaxIscritti()).append("\n");
            }
        }
    }

    //Metodo public String[] elencoNomiCorsiAttivi()
    public String[] elencoNomiCorsiAttivi() {
        String[] nomiCorsi = new String[numeroCorsi];
        int contatore = 0;
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i] != null) {
                nomiCorsi[contatore] = corsi[i].getNome();
                contatore++;
            }
        }
        return nomiCorsi;
    }

}