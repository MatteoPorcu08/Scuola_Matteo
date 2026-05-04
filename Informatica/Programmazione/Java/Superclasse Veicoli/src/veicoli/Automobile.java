package veicoli;
public class Automobile extends Veicolo {
    private int porte;
    private String alimentazione;

    public Automobile(String marca, String modello, int anno, double prezzoGiornaliero, int porte, String alimentazione) {
        super(marca, modello, anno, prezzoGiornaliero);
        this.porte = porte;
        this.alimentazione = alimentazione;
    }

    //Costruttore di copia
    public Automobile(Automobile altraAutomobile) {
        super(altraAutomobile.getMarca(), altraAutomobile.getModello(), altraAutomobile.getAnno(), altraAutomobile.getPrezzoGiornaliero());
        this.porte = altraAutomobile.getPorte();
        this.alimentazione = altraAutomobile.getAlimentazione();
    }

    // Getters
    public int getPorte() {
        return porte;
    }
    public String getAlimentazione() {
        return alimentazione;
    }

    // Setters
    public void setPorte(int porte) {
        this.porte = porte;
    }
    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    // Override del metodo calcolaCosto(int giorni)
    @Override
    public int calcolaCosto(int giorni) {
        int costoBase = super.calcolaCosto(giorni);
        if (giorni > 7) {
            return (int) (costoBase * 0.9); // Applica uno sconto del 10%
        }
        return costoBase;
    }

    // Override del metodo stampaDettagli()
    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
        System.out.println("Porte: " + porte);
        System.out.println("Alimentazione: " + alimentazione);
    }
}