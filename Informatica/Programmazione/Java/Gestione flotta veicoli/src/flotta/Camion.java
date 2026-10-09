package flotta;

public class Camion extends Veicolo implements Motorizzato, Ricaricabile {
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
        System.out.println("Il camion sta trasportando "+ caricoAttuale + " kg di merci.");
    }

    @Override
    public void accendiMotore() {
        motoreAcceso = true;
    }

    @Override
    public void spegniMotore() {
        motoreAcceso = false;
    }

    @Override
    public double getLivelloCarburante() {
        return carburante;
    }
}