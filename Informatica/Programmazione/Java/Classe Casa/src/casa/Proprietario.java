package casa;
public class Proprietario {
    private  String nome;
    private String cognome;
    private String codiceFiscale;
    public Casa home;

    //Costruttore Principale
    public Proprietario(String nome, String cognome, String codiceFiscale, Casa home) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.home = home;
    }

    //Costruttore Di Copia
    public Proprietario(Proprietario altroProprietario) {
        this.nome = altroProprietario.nome;
        this.cognome = altroProprietario.cognome;
        this.codiceFiscale = altroProprietario.codiceFiscale;
        this.home = altroProprietario.home;
    }

    //Metodo Getter
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public Casa getHome() {
        return home;
    }

    //Metodo Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public void setHome(Casa home) {
        this.home = home;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Proprietario:\n Nome: " + this.nome + "\nCognome: " + this.cognome + "\nCodice Fiscale: " + this.codiceFiscale + "\nCasa: " + this.home.toString();
    }

    //haCasaConGiardino()
    public boolean haCasaConGiardino() {
        if(this.home.ConGiardino()) {
            return true;
        } else {
            return false;
        }
    }

    //aggiornaCasa(Casa c)
    public String aggiornaCasa(Casa c) {
        if(this.home==c) {
            return "Nessuna modifica apportata alla casa.";
        } else {
            this.home = c;
            return "Casa aggiornata con successo.";
        }
        
    }
}