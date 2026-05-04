package superclasse;

public class Automobile {
    private int numeroPorte;
    private String tipoAlimentazione;

    public Automobile(int numeroPorte, String tipoAlimentazione) {
        this.numeroPorte = numeroPorte;
        this.tipoAlimentazione = tipoAlimentazione;
    }

    // Getters
    public int getNumeroPorte() {
        return numeroPorte;
    }
    public String getTipoAlimentazione() {
        return tipoAlimentazione;
    }

    //Setters
    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }
    public void setTipoAlimentazione(String tipoAlimentazione) {
        this.tipoAlimentazione = tipoAlimentazione;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "numeroPorte=" + numeroPorte +
                ", tipoAlimentazione='" + tipoAlimentazione + '\'' +
                '}';
    }

}