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
    public String getModello() {
        return modello;
    }
    public int getAnno() {
        return anno;
    }
    public int getKm() {
        return km;
    }
    public boolean isDisponibile() {
        return disponibile;
    }
    public double getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    //Setter
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public void setKm(int km) {
        this.km = km;
    }
    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
    public void setPrezzoGiornaliero(double prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Auto:\n Targa: " + targa + "\n Modello: " + modello + "\n Anno: " + anno + "\n Km: " + km + "\n Disponibile: " + disponibile + "\n Prezzo Giornaliero: " + prezzoGiornaliero;
    }

    //Metodo pubblic void restituisci(int kmaggiunti)
}