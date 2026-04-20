package magazzino;

public class Magazzino {
    private int quantitaDisponibile;

    public Magazzino(int quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public int getQuantitaDisponibile() {
        return quantitaDisponibile;
    }

    public void setQuantitaDisponibile(int quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }
}