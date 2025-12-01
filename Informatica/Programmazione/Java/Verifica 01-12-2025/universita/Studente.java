package universita;

public class Studente {
    private String matricola;
    private String nome;
    private String cognome;
    private String corso;
    private int annoIscrizione;
    private Tesi tesi;

    public Studente(String matricola, String nome, String cognome, String corso, int annoIscrizione, Tesi tesi) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.corso = corso;
        this.annoIscrizione = annoIscrizione;
        this.tesi = tesi;
    }

    // Costruttore di Copia (deep copy)
    public Studente(Studente altro) {
        this.matricola = altro.matricola;
        this.nome = altro.nome;
        this.cognome = altro.cognome;
        this.corso = altro.corso;
        this.annoIscrizione = altro.annoIscrizione;
        // Deep copy della tesi
        if(altro.tesi != null) {
            this.tesi = new Tesi(altro.tesi);
        } else {
            this.tesi = null;
        }
    }

    // Getter
    public String getMatricola() { return matricola; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getCorso() { return corso; }
    public int getAnnoIscrizione() { return annoIscrizione; }
    public Tesi getTesi() { return tesi; }

    // Setter
    public void setMatricola(String matricola) { this.matricola = matricola; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setCorso(String corso) { this.corso = corso; }
    public void setAnnoIscrizione(int annoIscrizione) { this.annoIscrizione = annoIscrizione; }
    public void setTesi(Tesi tesi) { this.tesi = tesi; }

    @Override
    public String toString() {
        String tesiStr = (tesi != null) ? tesi.toString() : "Nessuna tesi assegnata";
        return "Studente: " + nome + " " + cognome + 
               " (Matricola: " + matricola + ")\n" +
               "Corso: " + corso + " - Anno iscrizione: " + annoIscrizione + 
               "\nTesi: " + tesiStr;
    }

    public boolean haTesi() {
        return tesi != null;
    }

    // METODI INTERMEDI (implementati 2)
    public boolean sostituisciTesi(Tesi nuovaTesi) {
        if(nuovaTesi != null) {
            this.tesi = new Tesi(nuovaTesi); // Deep copy
            return true;
        }
        return false;
    }

    public void annullaTesi() {
        this.tesi = null;
    }

    public boolean isIdoneoAllaLaurea() {
        return haTesi() && tesi.isProntaPerDiscussione();
    }

    public String confrontaPagine(Studente altro) {
        if(!this.haTesi() || !altro.haTesi()) {
            return "Confronto non possibile: almeno uno studente non ha tesi";
        }
        
        int pagineThis = this.tesi.getPagine();
        int pagineAltro = altro.tesi.getPagine();
        
        if(pagineThis > pagineAltro) {
            return "Più pagine";
        } else if(pagineThis < pagineAltro) {
            return "Meno pagine";
        } else {
            return "Stessa lunghezza";
        }
    }

    public boolean promuoviVotoTesi(int incremento) {
        if(!haTesi()) return false;
        int nuovoVoto = tesi.getVotoProposto() + incremento;
        return tesi.aggiornaVoto(nuovoVoto);
    }

    // METODI AVANZATI (opzionali)
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Studente altro = (Studente) obj;
        return matricola.equals(altro.matricola);
    }
}