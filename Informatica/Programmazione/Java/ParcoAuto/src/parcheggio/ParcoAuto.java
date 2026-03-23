package parcheggio;

public class ParcoAuto {
    private static final int NUM_MAX = 20;
    private Auto[] auto;
    private int numeroAuto;

    // Costruttore
    public ParcoAuto() {
        auto = new Auto[NUM_MAX];
        this.numeroAuto = 0;
    }

    // Costruttore di copia
    public ParcoAuto(ParcoAuto p) {
        auto = new Auto[NUM_MAX];
        numeroAuto = p.numeroAuto;
        for (int i = 0; i < numeroAuto; i++) {
            auto[i] = new Auto(p.auto[i]);
        }
    }

    // Metodo public boolean rimuoviAuto(int posizione)
    public boolean rimuoviAuto(int posizione) {
        if (posizione < 0 || posizione >= numeroAuto) {
            return false;
        }
        for (int i = posizione; i < numeroAuto - 1; i++) {
            auto[i] = auto[i + 1];
        }
        numeroAuto--;
        return true;
    }

    // Metodo public boolean rimuoviAuto(String targa)
    public boolean rimuoviAuto(String targa) {
        for (int i = 0; i < numeroAuto; i++) {
            if (auto[i].getTarga().equals(targa)) {
                for (int j = i; j < numeroAuto - 1; j++) {
                    auto[j] = auto[j + 1];
                }
                numeroAuto--;
                return true;
            }
        }
        return false;

    }

    // Metodo Auto cercaAuto(String targa)
    public Auto cercaAuto(String targa) {
        for (int i = 0; i < numeroAuto; i++) {
            if (auto[i].getTarga().equals(targa)) {
                return new Auto(auto[i]);
            }
        }
        return null;
    }
}