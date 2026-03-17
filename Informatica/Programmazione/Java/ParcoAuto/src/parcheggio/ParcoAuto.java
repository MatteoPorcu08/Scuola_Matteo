package parcheggio;

public class ParcoAuto {
    private static final int NUM_MAX= 20;
    private Auto[] auto;
    private int numeroAuto;

    //Costruttore
    public ParcoAuto() {
        auto = new Auto[NUM_MAX];
        numeroAuto = 0;
    }

    //Costruttore di copia
    public ParcoAuto(ParcoAuto p) {
        auto = new Auto[NUM_MAX];
        numeroAuto = p.numeroAuto;
        for (int i = 0; i < numeroAuto; i++) {
            auto[i] = new Auto(p.auto[i]);
        }
    }

}
