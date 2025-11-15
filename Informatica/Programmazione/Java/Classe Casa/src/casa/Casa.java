package  casa;
public class Casa {
    private String indirizzo;
    private int numeroStanze;
    private double superficie;
    private double prezzo;
    private boolean conGiardino;
    private int annoCostruzione;


    // Costruttore principale
    public Casa(String indirizzo, int numeroStanze, double superficie, double prezzo, boolean conGiardino, int annoCostruzione) {
        this.indirizzo = indirizzo;
        this.numeroStanze = numeroStanze;
        this.superficie = superficie;
        this.prezzo = prezzo;
        this.conGiardino = conGiardino;
        this.annoCostruzione = annoCostruzione;
    }

}
