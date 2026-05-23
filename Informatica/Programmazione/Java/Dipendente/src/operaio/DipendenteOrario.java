package operaio;
public class DipendenteOrario extends Dipendente {
    private double oreLavorate;
    private double salarioOrario;

    public DipendenteOrario(String nome, double oreLavorate, double salarioOrario) {
        super(nome);

        try {
            if (oreLavorate < 0 || salarioOrario < 0) {
                throw new Exception("Valori non validi");
            }

            this.oreLavorate = oreLavorate;
            this.salarioOrario = salarioOrario;

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    @Override
    public double calcolaStipendio() {
        return oreLavorate * salarioOrario;
    }
}