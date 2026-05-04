package superclasse;
public class Automobile {
    public String marca;
    public  String modello;
    public  int noleggioGiornaliero;
    private int numeroPorte;
    private String tipoAlimentazione;

    public Automobile(String marca, String modello, int noleggioGiornaliero, int numeroPorte, String tipoAlimentazione) {
        this.marca = marca;
        this.modello = modello;
        this.noleggioGiornaliero = noleggioGiornaliero;
        this.numeroPorte = numeroPorte;
        this.tipoAlimentazione = tipoAlimentazione;
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
    public int getNumeroPorte() {
        return numeroPorte;
    }
    public String getTipoAlimentazione() {
        return tipoAlimentazione;
    }

    //Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public void setNoleggioGiornaliero(int noleggioGiornaliero) {
        this.noleggioGiornaliero = noleggioGiornaliero;
    }
    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }
    public void setTipoAlimentazione(String tipoAlimentazione) {
        this.tipoAlimentazione = tipoAlimentazione;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", noleggioGiornaliero=" + noleggioGiornaliero +
                ", numeroPorte=" + numeroPorte +
                ", tipoAlimentazione='" + tipoAlimentazione + '\'' +
                '}';
    }

    //Metodo calcolaCosto(int giorni)
    public int calcolaCosto(int giorni) {
        return giorni * 50; // Costo fisso di 50 euro al giorno
    }
}