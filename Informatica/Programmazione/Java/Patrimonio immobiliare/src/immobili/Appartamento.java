package immobili;
public class Appartamento extends Abitazione {

    private int piano;
    private boolean ascensore;
    private int numTerrazzi;

    // Costruttore
    public Appartamento(int numStanze, double superficie,
                        String indirizzo, String citta,
                        int piano, boolean ascensore,
                        int numTerrazzi) {

        super(numStanze, superficie, indirizzo, citta);

        this.piano = piano;
        this.ascensore = ascensore;
        this.numTerrazzi = numTerrazzi;
    }

    // Costruttore copia
    public Appartamento(Appartamento a) {
        super(a);

        this.piano = a.getPiano();
        this.ascensore = a.hasAscensore();
        this.numTerrazzi = a.getNumTerrazzi();
    }

    // Getter
    public int getPiano() {
        return piano;
    }

    public boolean hasAscensore() {
        return ascensore;
    }

    public int getNumTerrazzi() {
        return numTerrazzi;
    }

    // Setter
    public void setPiano(int piano) {
        this.piano = piano;
    }

    public void setAscensore(boolean ascensore) {
        this.ascensore = ascensore;
    }

    public void setNumTerrazzi(int numTerrazzi) {
        this.numTerrazzi = numTerrazzi;
    }

    @Override
    public String toString() {

        return super.toString() +
                "Appartamento:" +
                "\nPiano: " + piano +
                "\nAscensore: " + ascensore +
                "\nNumero terrazzi: " + numTerrazzi + "\n";
    }

    public boolean equals(Appartamento a) {

        return super.equals(a) &&
            this.piano == a.piano &&
            this.ascensore == a.ascensore &&
            this.numTerrazzi == a.numTerrazzi;
    }
}