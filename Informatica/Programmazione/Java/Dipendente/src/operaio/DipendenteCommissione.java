package operaio;

public class DipendenteCommissione extends Dipendente {
    private double vendite;
    private double percentualeCommissione;

    public DipendenteCommissione(String nome, double vendite, double percentualeCommissione) {
        super(nome);
        this.vendite = vendite;
        this.percentualeCommissione = percentualeCommissione;
    }

    @Override
    public double calcolaStipendio() {
        return vendite * percentualeCommissione;
    }
}