package superclasse;
public class Motocicletta {
    public String marca;
    public  String modello;
    public  int noleggioGiornaliero;
    public int cilindrata;
    public boolean bauletto;

    public Motocicletta(String marca, String modello, int noleggioGiornaliero, int cilindrata, boolean bauletto) {
        this.marca = marca;
        this.modello = modello;
        this.noleggioGiornaliero = noleggioGiornaliero;
        this.cilindrata = cilindrata;
        this.bauletto = bauletto;
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
    public int getCilindrata() {
        return cilindrata;
    }
    public boolean isBauletto() {
        return bauletto;
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
    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }
    public void setBauletto(boolean bauletto) {
        this.bauletto = bauletto;
    }

    @Override
    public String toString() {
        return "Motocicletta{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", noleggioGiornaliero=" + noleggioGiornaliero +
                ", cilindrata=" + cilindrata +
                ", bauletto=" + bauletto +
                '}';
    }

    //Metodo calcolaCosto(int giorni)
    public int calcolaCosto(int giorni) {
        return noleggioGiornaliero * giorni;
    }
}