package chiavi;

/**
 * Classe Chiave
 * @author 4B Inf
 * @version 1.0
 */
public class Chiave {
    // Attributi
    private int numeroCamera;
    private String tipo; // singola, doppia, tripla
    private String cliente;
    
    /**
     * Costruttore
     * @param numeroCamera il numero della camera
     * @param tipo il tipo di camera
     * @param cliente il nome del cliente
     */
    public Chiave(int numeroCamera, String tipo, String cliente) {
        this.numeroCamera = numeroCamera;
        this.tipo = tipo;
        this.cliente = cliente;
    }
    
    // Metodi getter
    public int getNumeroCamera() {
        return numeroCamera;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    // Metodi setter
    public void setNumeroCamera(int numeroCamera) {
        this.numeroCamera = numeroCamera;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    /**
     * Metodo toString per rappresentare la chiave come stringa
     */
    @Override
    public String toString() {
        return "Chiave camera=" + numeroCamera + ", tipo=" + tipo + ", cliente=" + cliente + "\n";
    }
}