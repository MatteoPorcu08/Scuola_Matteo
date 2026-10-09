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