package operaio;
public class DipendenteStipendiato extends Dipendente {

    private double stipendioFisso;

    public DipendenteStipendiato(String nome, double stipendioFisso) {
        super(nome);

        try {

            if (stipendioFisso < 0) {
                throw new IllegalArgumentException("Stipendio non valido");
            }

            this.stipendioFisso = stipendioFisso;

        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    @Override
    public double calcolaStipendio() {
        return stipendioFisso;
    }
}