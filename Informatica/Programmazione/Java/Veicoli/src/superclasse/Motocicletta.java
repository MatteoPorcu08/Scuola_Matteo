package superclasse;
public class Motocicletta extends Veicolo {
    private int cilindrata;
    private boolean bauletto;

    public Motocicletta(String marca, String modello, int anno, double prezzoGiornaliero, int cilindrata, boolean bauletto) {
        super(marca, modello, anno, prezzoGiornaliero);
        this.cilindrata = cilindrata;
        this.bauletto = bauletto;
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

    // Override del metodo stampaDettagli()
    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Cilindrata: " + cilindrata);
        System.out.println("Bauletto: " + bauletto);
    }

    // Override del metodo calcolaCosto(int giorni)
    @Override
    public int calcolaCosto(int giorni) {
        int costoBase = super.calcolaCosto(giorni);
        if (prezzoGiornaliero < 0) {
            return 0;
        }
        else if( giorni )
        return costoBase;
    }
    
}