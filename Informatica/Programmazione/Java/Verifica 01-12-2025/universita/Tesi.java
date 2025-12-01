package universita;

public class Tesi {
    private String titolo;
    private String relatore;
    private int pagine;
    private int votoProposto;
    private String stato;

    public Tesi(String titolo, String relatore, int pagine, int votoProposto, String stato) {
        this.titolo = titolo;
        this.relatore = relatore;
        this.setPagine(pagine);
        this.setVotoProposto(votoProposto);
        this.stato = stato;
    }

    public Tesi(Tesi altro) {
        this.titolo = altro.getTitolo();
        this.relatore = altro.getRelatore();
        this.pagine = altro.getPagine();
        this.votoProposto = altro.getVotoProposto();
        this.stato = altro.getStato();
    }

    // Getter
    public String getTitolo() { return titolo; }
    public String getRelatore() { return relatore; }
    public int getPagine() { return pagine; }
    public int getVotoProposto() { return votoProposto; }
    public String getStato() { return stato; }

    // Setter con validazioni
    public void setTitolo(String titolo) { this.titolo = titolo; }
    public void setRelatore(String relatore) { this.relatore = relatore; }
    
    public void setPagine(int pagine) {
        if(pagine >= 1) {
            this.pagine = pagine;
        } else {
            System.out.println("Errore: le pagine devono essere >= 1");
        }
    }
    
    public void setVotoProposto(int votoProposto) {
        if(votoProposto >= 0 && votoProposto <= 110) {
            this.votoProposto = votoProposto;
        } else {
            System.out.println("Errore: voto deve essere tra 0 e 110");
        }
    }
    
    public void setStato(String stato) { this.stato = stato; }

    @Override
    public String toString() {
        return "Titolo: " + titolo + " — Relatore: " + relatore + 
               " — Pagine: " + pagine + " — Voto proposto: " + 
               votoProposto + " — Stato: " + stato;
    }

    public boolean isProntaPerDiscussione() {
        return pagine >= 30; // Solo controllo sulle pagine come da specifica
    }

    public boolean aggiornaVoto(int nuovoVoto) {
        if(nuovoVoto >= 0 && nuovoVoto <= 110) {
            this.votoProposto = nuovoVoto;
            return true;
        }
        return false;
    }

    public int aumentaPagine(int extra) {
        if(extra > 0) {
            this.pagine += extra;
        }
        return this.pagine;
    }
}