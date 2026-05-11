package immobili;
public class Villa extends Abitazione {

    private int numPiani;
    private double supGiardino;
    private boolean piscina;

    // Costruttore
    public Villa(int numStanze, double superficie, String indirizzo,
                String citta, int numPiani,
                double supGiardino, boolean piscina) {

        super(numStanze, superficie, indirizzo, citta);

        this.numPiani = numPiani;
        this.supGiardino = supGiardino;
        this.piscina = piscina;
    }

    // Costruttore copia
    public Villa(Villa v) {
        super(v);

        this.numPiani = v.getNumPiani();
        this.supGiardino = v.getSupGiardino();
        this.piscina = v.hasPiscina();
    }

    // Getter
    public int getNumPiani() {
        return numPiani;
    }

    public double getSupGiardino() {
        return supGiardino;
    }

    public boolean hasPiscina() {
        return piscina;
    }

    // Setter
    public void setNumPiani(int numPiani) {
        this.numPiani = numPiani;
    }

    public void setSupGiardino(double supGiardino) {
        this.supGiardino = supGiardino;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    @Override
    public String toString() {

        return super.toString() +
                "Villa:" +
                "\nNumero piani: " + numPiani +
                "\nSuperficie giardino: " + supGiardino +
                "\nPiscina: " + piscina + "\n";
    }

    public boolean equals(Villa v) {

        return super.equals(v) &&
            this.numPiani == v.numPiani &&
            this.supGiardino == v.supGiardino &&
            this.piscina == v.piscina;
    }
}