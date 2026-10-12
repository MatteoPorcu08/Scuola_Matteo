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

    public void caricaMerci(double peso) {
        if (peso> 0 && caricoAttuale + peso <= capacitaCaricoMassimo) {
            caricoAttuale += peso;
            System.out.println("Carico di " + peso + " kg aggiunto. Carico attuale: " + caricoAttuale + " kg.");
        } else {
            System.out.println("Impossibile caricare: superata la capacità massima del camion.");
        }
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

    @Override
    public void ricarica(double quantita) {
        carburante += quantita;
        if (carburante > 100.0) {
            carburante = 100.0; // Livello massimo di carburante
        }
    }

    @Override
    public String toString() {
        return "Camion{" +"marca='" + marca + '\'' +", modello='" + modello + '\'' +", velocitaMassima=" + velocitaMassima +", capacitaCaricoMassimo=" + capacitaCaricoMassimo +", caricoAttuale=" + caricoAttuale +", motoreAcceso=" + motoreAcceso +", carburante=" + carburante +'}';
    }
}