package superclasse;
public class Veicolo {
    protected  String marca;
    protected  String modello;
    protected int anno;
    protected  double  prezzoGiornaliero;

    public Veicolo(String marca, String modello, int anno, double prezzoGiornaliero) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    // Getters
    protected String getMarca() {
        return marca;
    }
    protected String getModello() {
        return modello;
    }
    protected int getAnno() {
        return anno;
    }
    protected double getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    // Setters
    protected void setMarca(String marca) {
        this.marca = marca;
    }
    protected void setModello(String modello) {
        this.modello = modello;
    }
    protected void setAnno(int anno) {
        this.anno = anno;
    }
    protected void setPrezzoGiornaliero(double prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
            "marca='" + marca + '\'' +
            ", modello='" + modello + '\'' +
            ", anno=" + anno +
            ", prezzoGiornaliero=" + prezzoGiornaliero +
            '}';
    }

    //Metodo calcolaCosto(int giorni)
    public int calcolaCosto(int giorni) {
        return (int) (prezzoGiornaliero * giorni);
        
}