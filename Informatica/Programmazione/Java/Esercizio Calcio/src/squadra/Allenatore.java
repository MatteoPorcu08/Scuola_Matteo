package squadra;

public class Allenatore extends MembroSquadra {
    private int anniEsperienza;

    public Allenatore(String nome, String cognome, int numeroMaglia, int anniEsperienza) {
        super(nome, cognome, numeroMaglia);
        this.anniEsperienza = anniEsperienza;
    }

    @Override
    public void presentaRuolo() {
        System.out.println("L'allenatore " + nome + " " + cognome + " guida la squadra dalla panchina (Anni exp: " + anniEsperienza + ").");
    }

    public void impartisciIstruzioni() {
        System.out.println("Mister " + cognome + " urla indicazioni tattiche: 'Cambiate modulo, passate al 4-3-3!'");
    }
}