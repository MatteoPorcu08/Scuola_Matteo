package operaio;
public class DipendenteOrario extends Dipendente {
    private double oreLavorate;
    private double salarioOrario;

    public DipendenteOrario(String nome, double oreLavorate, double salarioOrario) {
        super(nome);
        this.oreLavorate = oreLavorate;
        this.salarioOrario = salarioOrario;
    }

    @Override
    public double calcolaStipendio() {
        return oreLavorate * salarioOrario;
    }
}