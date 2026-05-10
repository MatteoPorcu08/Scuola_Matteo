package immobili;

public class Abitazione {

    protected int numStanze;
    protected double superficie;
    protected String indirizzo;
    protected String citta;

    // Costruttore
    public Abitazione(int numStanze, double superficie, String indirizzo, String citta) {
        this.numStanze = numStanze;
        this.superficie = superficie;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    // Costruttore copia
    public Abitazione(Abitazione a) {
        this.numStanze = a.getNumStanze();
        this.superficie = a.getSuperficie();
        this.indirizzo = a.getIndirizzo();
        this.citta = a.getCitta();
    }

    // Getter
    public int getNumStanze() {
        return numStanze;
    }

    public double getSuperficie() {
        return superficie;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    // Setter
    public void setNumStanze(int numStanze) {
        this.numStanze = numStanze;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Abitazione:\n" +
                "Numero stanze: " + numStanze +
                "\nSuperficie: " + superficie +
                "\nIndirizzo: " + indirizzo +
                "\nCittà: " + citta + "\n";
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Abitazione) {
            Abitazione a = (Abitazione) obj;

            return this.numStanze == a.numStanze &&
                this.superficie == a.superficie &&
                this.indirizzo.equals(a.indirizzo) &&
                this.citta.equals(a.citta);
        }
        return false;
    }
}