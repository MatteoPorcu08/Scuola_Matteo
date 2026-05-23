package operaio;
public class DipendenteCommissione extends Dipendente {
    private double vendite;
    private double percentualeCommissione;

    public DipendenteCommissione(String nome, double vendite, double percentualeCommissione) {
        super(nome);

        try {
            if (vendite < 0 || percentualeCommissione < 0) {
                throw new Exception("Valori non validi");
            }

            this.vendite = vendite;
            this.percentualeCommissione = percentualeCommissione;

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    @Override
    public double calcolaStipendio() {
        return vendite * (percentualeCommissione / 100);
    }
}