package superclasse;
public class Veicolo {
    public String marca;
    public  String modello;
    public  int noleggioGiornaliero;

    public Veicolo(String marca, String modello, int noleggioGiornaliero) {
        this.marca = marca;
        this.modello = modello;
        this.noleggioGiornaliero = noleggioGiornaliero;
    }

    // Getters
    public String getMarca() {
        return marca;
    }
    public String getModello() {
        return modello;
    }
    public int getNoleggioGiornaliero() {
        return noleggioGiornaliero;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public void setNoleggioGiornaliero(int noleggioGiornaliero) {
        this.noleggioGiornaliero = noleggioGiornaliero;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", noleggioGiornaliero=" + noleggioGiornaliero +
                '}';
    }
}