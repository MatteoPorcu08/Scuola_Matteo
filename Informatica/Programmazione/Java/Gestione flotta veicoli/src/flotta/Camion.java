package flotta;

public class Camion {
    private double capacitaCaricoMassimo;
    private double caricoAttuale;
    private boolean motoreAcceso;
    private double carburante;

    public Camion(String marca, String modello, int velocitaMassima, double capacitaCaricoMassimo) {
        super(marca, modello, velocitaMassima);
        this.capacitaCaricoMassimo = capacitaCaricoMassimo;
        this.caricoAttuale = 0.0; // Carico iniziale
        this.motoreAcceso = false;
        this.carburante = 100.0; // Livello iniziale di carburante
    }
}
