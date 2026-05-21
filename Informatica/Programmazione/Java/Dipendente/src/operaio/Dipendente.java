package operaio;

public abstract class Dipendente {
    private String nome;

    public Dipendente(String nome) {
        this.nome = nome;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Metodo astratto per calcolare lo stipendio
    public abstract double calcolaStipendio();
    
    
}
