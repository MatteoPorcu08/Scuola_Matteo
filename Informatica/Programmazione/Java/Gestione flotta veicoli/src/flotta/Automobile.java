package flotta;

public class Automobile extends Veicolo implements Motorizzato, Ricaricabile {
    private int numeroPorte;
    private boolean motoreAcceso;
    private double carburante;

    public Automobile(String marca, String modello, int velocitaMassima, int numeroPorte) {
        super(marca, modello, velocitaMassima);
        this.numeroPorte = numeroPorte;
        this.motoreAcceso = false;
        this.carburante = 100.0; // Livello iniziale di carburante
    }

    @Override
    public void muovi(){
        System.out.println("L'automobile "+ marca + " " + modello + " si sta muovendo in autostrada");
    }

    @Override
    public void accendiMotore() {
        if (carburante > 0) {
            motoreAcceso = true;
            System.out.println("Motore Acceso");
        } else {
            System.out.println("Impossibile accendere il motore. Carburante insufficiente.");
        }
    }

    @Override
    public void spegniMotore() {
        motoreAcceso = false;
        System.out.println("Motore Spento");
    }

    @Override
    public void ricarica(double quantita) {
        if (quantita > 0) {
            carburante += quantita;
            System.out.println("Ricarica completata. Livello carburante: " + carburante);
        } else {
            System.out.println("Quantità di ricarica non valida.");
        }
    }

}