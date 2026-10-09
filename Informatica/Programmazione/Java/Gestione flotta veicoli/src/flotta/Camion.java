package flotta;

public class Camion extends Veicolo {
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
    
    @Override
    public void muovi() {
        if (!motoreAcceso) {
            System.out.println("Il camion non può muoversi: motore spento.");
            return;
        }

        if (carburante <= 0) {
            System.out.println("Il camion non può muoversi: carburante insufficiente.");
            motoreAcceso = false;
            return;
        }

        carburante -= 5.0;
        System.out.println("Il camion sta viaggiando.");
    }
}