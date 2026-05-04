package superclasse;
public class Veicolo {
    protected  String marca;
    protected  String modello;
    protected int anno;
    protected  double  prezzoGiornaliero;

    public Veicolo(String marca, String modello, int anno, double prezzoGiornaliero) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    //Costruttore di copia
    public Veicolo(Veicolo altroVeicolo) {
        this.marca = altroVeicolo.getMarca();
        this.modello = altroVeicolo.getModello();
        this.anno = altroVeicolo.getAnno();
        this.prezzoGiornaliero = altroVeicolo.getPrezzoGiornaliero();
    }

    // Getters
    protected String getMarca() {
        return marca;
    }
    protected String getModello() {
        return modello;
    }
    protected int getAnno() {
        return anno;
    }
    protected double getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    // Setters
    protected void setMarca(String marca) {
        this.marca = marca;
    }
    protected void setModello(String modello) {
        this.modello = modello;
    }
    protected void setAnno(int anno) {
        this.anno = anno;
    }
    protected void setPrezzoGiornaliero(double prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    //Metodo calcolaCosto(int giorni)
    public int calcolaCosto(int giorni) {
        return (int) (prezzoGiornaliero * giorni);
    }

    //Metodo stampaDettagli()
    public void stampaDettagli() {
        System.out.println("Marca: " + marca);
        System.out.println("Modello: " + modello);
        System.out.println("Anno: " + anno);
        System.out.println("Prezzo giornaliero: " + prezzoGiornaliero);
    }
}