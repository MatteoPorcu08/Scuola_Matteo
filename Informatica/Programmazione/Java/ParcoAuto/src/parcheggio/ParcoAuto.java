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
        compattaParcoAuto();
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
                compattaParcoAuto();
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

    // Metodo public String visualizzaParco()
    public String visualizzaParco() {
        String visualizza = "";
        for (int i = 0; i < numeroAuto; i++) {
            if (auto[i] != null) {
                visualizza += auto[i].toString() + "\n";
            }
        }
        return visualizza;
    }

    // Metodo public void compattaParcoAuto()
    public void compattaParcoAuto() {
        int j = 0;
        for (int i = 0; i < NUM_MAX; i++) {
            if (auto[i] != null) {
                auto[j] = auto[i];
                auto[i] = null;
            }
        }
    }

    // Metodo public int contaDisponibili()
    public int contaDisponibili() {
        int n = 0;
        for (int i = 0; i < NUM_MAX; i++) {
            if (auto[i] != null && auto[i].isDisponibile()) {
                n++;
            }
        }
        return n;
    }

    // Metodo public int contaMarca(String marca)
    public int contaMarca(String marca) {
        int n = 0;
        for (int i = 0; i < NUM_MAX; i++) {
            if (auto[i] != null && auto[i].getMarca().equals(marca)) {
                n++;
            }
        }
        return n;
    }
}