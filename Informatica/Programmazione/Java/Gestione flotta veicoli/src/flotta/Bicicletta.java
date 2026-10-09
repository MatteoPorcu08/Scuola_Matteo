package flotta;

public class Bicicletta extends Veicolo {
    private int numeroRapporti;

    public Bicicletta(String marca, String modello, int anno, int numeroRapporti) {
        super(marca, modello, anno);
        this.numeroRapporti = numeroRapporti;
    }

    @Override
    public void muovi() {
        System.out.println("La bicicletta " + marca + " " + modello + " si sta muovendo su strada");
    }
}