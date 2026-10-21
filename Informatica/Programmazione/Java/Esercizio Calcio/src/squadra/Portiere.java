package squadra;

public class Portiere extends MembroSquadra implements Giocatore, Allenabile {
    private int numeroParate;
    private boolean titolare;
    private double energia;
    private double preparazione;

    public Portiere(String nome, String cognome, int numeroMaglia, boolean titolare, double energia, double preparazione) {
        super(nome, cognome, numeroMaglia);
        this.numeroParate = 0;
        this.titolare = titolare;
        this.energia = Math.min(100, Math.max(0, energia));
        this.preparazione = preparazione;
    }

    @Override
    public void presentaRuolo() {
        System.out.println("Il portiere " + nome + " " + cognome + " difende la porta con la maglia numero " + numeroMaglia + ".");
    }

    @Override
    public void gioca() {
        System.out.println(nome + " " + cognome + " si posiziona tra i pali e difende la porta.");
    }

    @Override
    public void riposa() {
        this.titolare = false;
        this.energia = Math.min(100, this.energia + 15); // Recupera 15 di energia
        System.out.println(nome + " " + cognome + " è stato messo a riposo. Energia attuale: " + energia);
    }

    @Override
    public double getEnergia() {
        return energia;
    }

    @Override
    public void allenati(double intensita) {
        this.preparazione += intensita * 1.8;
        this.energia = Math.max(0, this.energia - (intensita * 1.2));
        System.out.println(nome + " si è allenato sul posizionamento. Preparazione: " + preparazione + ", Energia: " + energia);
    }

    public void effettuaParata() {
        this.numeroParate++;
        System.out.println("Grande parata di " + nome + " " + cognome + "! Parate totali: " + numeroParate);
    }
}