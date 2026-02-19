package chiavi;
public class Chiave {

    private int numeroCamera;
    private String tipo; // singola, doppia, tripla
    private String nominativo;

    public Chiave(int numeroCamera, String tipo, String nominativo) {
        this.numeroCamera = numeroCamera;
        this.tipo = tipo;
        this.nominativo = nominativo;
    }

    public int getNumeroCamera() {
        return numeroCamera;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    @Override
    public String toString() {
        return "Chiave [Camera=" + numeroCamera +
                ", Tipo=" + tipo +
                ", Cliente=" + nominativo + "]";
    }
}