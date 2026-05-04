package superclasse;
public class Veicolo {
    protected  String marca;
    protected  String modello;
    protected int anno;
    protected  double  noleggioGiornaliero;

    public Veicolo(String marca, String modello, int anno, double noleggioGiornaliero) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.noleggioGiornaliero = noleggioGiornaliero;
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
    protected double getNoleggioGiornaliero() {
        return noleggioGiornaliero;
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
    protected void setNoleggioGiornaliero(double noleggioGiornaliero) {
        this.noleggioGiornaliero = noleggioGiornaliero;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", anno=" + anno +
                ", noleggioGiornaliero=" + noleggioGiornaliero +
                '}';
    }
}