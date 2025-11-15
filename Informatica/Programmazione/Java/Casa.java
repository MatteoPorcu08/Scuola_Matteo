package casa;
public class Casa {
    private String indirizzo;
    private int numeroStanze;
    private double superficie;
    private double prezzo;
    private boolean conGiardino;
    private int annoCostruzione;

    public Casa(String indirizzo, int numeroStanze, double superficie, double prezzo, boolean conGiardino, int annoCostruzione) {
        this.indirizzo = indirizzo;
        this.numeroStanze = numeroStanze;
        this.superficie = superficie;
        this.prezzo = prezzo;
        this.conGiardino = conGiardino;
        this.annoCostruzione = annoCostruzione;
    }

    public Casa(Casa altraCasa) {
        this.indirizzo = altraCasa.indirizzo;
        this.numeroStanze = altraCasa.numeroStanze;
        this.superficie = altraCasa.superficie;
        this.prezzo = altraCasa.prezzo;
        this.conGiardino = altraCasa.conGiardino;
        this.annoCostruzione = altraCasa.annoCostruzione;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public void setNumeroStanze(int numeroStanze) {
        this.numeroStanze = numeroStanze;
    }
    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public void setConGiardino(boolean conGiardino) {
        this.conGiardino = conGiardino;
    }
    public void setAnnoCostruzione(int annoCostruzione) {
        this.annoCostruzione = annoCostruzione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
    public int getNumeroStanze() {
        return numeroStanze;
    }
    public double getSuperficie() {
        return superficie;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public boolean ConGiardino() {
        return conGiardino;
    }
    public int getAnnoCostruzione() {
        return annoCostruzione;
    }

    public boolean haSuperficieMaggioreDi(Casa altraCasa) {
        return this.superficie > altraCasa.superficie;
    }

    public boolean haPrezzoMinoreDi(Casa altraCasa) {
        return this.prezzo < altraCasa.prezzo;
    }

    public String toString() {
    return "Casa: indirizzo=" + indirizzo 
        + ", numeroStanze=" + numeroStanze
        + ", superficie=" + superficie
        + ", prezzo=" + prezzo
        + ", conGiardino=" + conGiardino
        + ", annoCostruzione=" + annoCostruzione;
}

}