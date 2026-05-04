package superclasse;
public class Automobile extends Veicolo {
    private int porte;
    private String alimentazione;

    public Automobile(String marca, String modello, int anno, double prezzoGiornaliero, int porte, String alimentazione) {
        super(marca, modello, anno, prezzoGiornaliero);
        this.porte = porte;
        this.alimentazione = alimentazione;
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

    //Metodo calcolaCosto(int giorni)
    public int calcolaCosto(int giorni) {
        return (int) (getPrezzoGiornaliero() * giorni);
    }
}