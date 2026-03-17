package parcheggio;
public class Auto {
    private String targa;
    private String modello;
    private int anno;
    private int km;
    private boolean disponibile;
    private double prezzoGiornaliero;

    // Costruttore
    public Auto(String targa, String modello, int anno, int km, boolean disponibile, double prezzoGiornaliero) {
        this.targa = targa;
        this.modello = modello;
        this.anno = anno;
        this.km = km;
        this.disponibile = disponibile;
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    //Costruttore di copia
    public Auto(Auto auto) {
        this.targa = auto.targa;
        this.modello = auto.modello;
        this.anno = auto.anno;
        this.km = auto.km;
        this.disponibile = auto.disponibile;
        this.prezzoGiornaliero = auto.prezzoGiornaliero;
    }

    //Getter
    public String getTarga() {
        return targa;
    }
    public 

}
