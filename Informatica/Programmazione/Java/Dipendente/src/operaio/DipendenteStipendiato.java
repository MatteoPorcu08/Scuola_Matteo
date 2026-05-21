package operaio;

public class DipendenteStipendiato extends Dipendente {
    private double stipendioFisso;

    public DipendenteStipendiato(String nome, double stipendioFisso) {
        super(nome);
        this.stipendioFisso = stipendioFisso;
    }

    @Override
    public double calcolaStipendio() {
        return stipendioFisso;
    }
}