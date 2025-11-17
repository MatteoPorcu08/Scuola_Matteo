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



}