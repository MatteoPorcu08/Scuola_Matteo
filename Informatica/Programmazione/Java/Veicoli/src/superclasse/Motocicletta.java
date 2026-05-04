package superclasse;
public class Motocicletta extends Veicolo {
    private int cilindrata;
    private boolean bauletto;

    public Motocicletta(String marca, String modello, int anno, double prezzoGiornaliero, int cilindrata, boolean bauletto) {
        super(marca, modello, anno, prezzoGiornaliero);
        this.cilindrata = cilindrata;
        this.bauletto = bauletto;
    }

    //Costruttore di copia
    public Motocicletta(Motocicletta altraMotocicletta) {
        super(altraMotocicletta.getMarca(), altraMotocicletta.getModello(), altraMotocicletta.getAnno(), altraMotocicletta.getPrezzoGiornaliero());
        this.cilindrata = altraMotocicletta.getCilindrata();
        this.bauletto = altraMotocicletta.isBauletto();
    }

    // Getters
    public int getCilindrata() {
        return cilindrata;
    }

    public boolean isBauletto() {
        return bauletto;
    }

    // Setters
    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public void setBauletto(boolean bauletto) {
        this.bauletto = bauletto;
    }

    // Override del metodo calcolaCosto(int giorni)
    @Override
    public int calcolaCosto(int giorni) {
        int costoBase = super.calcolaCosto(giorni);
        if (prezzoGiornaliero < 0) {
            return 0;
        }
        else if( giorni > 5) {
            return (int) (costoBase - 20); // Applica uno sconto di 20 euro
        }
        return costoBase;
    }
    
    // Override del metodo stampaDettagli()
    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Cilindrata: " + cilindrata);
        System.out.println("Bauletto: " + bauletto);
    }
}