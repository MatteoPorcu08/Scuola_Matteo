package operaio;

public abstract class Dipendente {
    private String nome;

    public Dipendente(String nome) {
        this.nome = nome;
    }

    // Costruttore di copia
    public Dipendente(Dipendente d) {
        this.nome = d.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Metodo astratto calcolaStipendio()
    public abstract double calcolaStipendio();

    @Override
    public String toString() {
        return "Dipendente: " + nome;
    }
}