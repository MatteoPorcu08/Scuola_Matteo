package Videogiochi;

public abstract class Personaggio {
    protected String nome;
    protected int puntiVita;

    public Personaggio(String nome, int puntiVita) {
        this.nome = nome;
        this.puntiVita = puntiVita;
    }

    public String getNome() {
        return nome;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public abstract void usaAbilitaSpeciale();
}