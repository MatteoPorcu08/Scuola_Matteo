package squadra;

public abstract class MembroSquadra {
    protected String nome;
    protected String cognome;
    protected int numeroMaglia;

    public MembroSquadra(String nome, String cognome, int numeroMaglia) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroMaglia = numeroMaglia;
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public int getNumeroMaglia() { return numeroMaglia; }

    public abstract void presentaRuolo();
}