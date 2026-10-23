package squadra;

public class Attaccante extends MembroSquadra implements Giocatore, Allenabile {
    private int numeroGol;
    private boolean titolare;
    private double energia;
    private double preparazione;

    public Attaccante(String nome, String cognome, int numeroMaglia, boolean titolare, double energia, double preparazione) {
        super(nome, cognome, numeroMaglia);
        this.numeroGol = 0;
        this.titolare = titolare;
        this.energia = energia;
        this.preparazione = preparazione;
    }

    @Override
    public void presentaRuolo() {
        System.out.println("L'attaccante " + nome + " " + cognome + " indossa la maglia numero " + numeroMaglia + ".");
    }

    @Override
    public void gioca() {
        System.out.println(nome + " " + cognome + " scatta in avanti e tenta di segnare un gol!");
    }

    @Override
    public void riposa() {
        this.titolare = false;
        this.energia = this.energia + 20;
        System.out.println(nome + " " + cognome + " è stato messo a riposo. Energia attuale: " + energia);
    }

    @Override
    public double getEnergia() {
        return energia;
    }

    @Override
    public void allenati(double intensita) {
        this.preparazione += intensita * 2;
        this.energia = this.energia - (intensita * 1.5);
        System.out.println(nome + " si è allenato. Preparazione: " + preparazione + ", Energia: " + energia);
    }

    public void segnaGol() {
        this.numeroGol++;
        System.out.println("GOAL! " + nome + " " + cognome + " ha segnato! " + numeroGol + " gol totali.");
    }

    @Override
    public String toString(){
        
    }
}