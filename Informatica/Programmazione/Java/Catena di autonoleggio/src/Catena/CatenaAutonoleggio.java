package  Catena;
public class CatenaAutonoleggio {
    private String targa;
    private String marca;
    private String modello;
    private int cilindrata;
    private int annoacquisto;
    private int numeroposti;

    //Costruttore
    public CatenaAutonoleggio(String targa, String marca, String modello, int cilindrata, int annoacquisto, int numeroposti) {
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.cilindrata = cilindrata;
        this.annoacquisto = annoacquisto;
        this.numeroposti = numeroposti;
    }
    
    //Costruttore di copia
    public CatenaAutonoleggio(CatenaAutonoleggio altraAuto) {
        this.targa = altraAuto.targa;
        this.marca = altraAuto.marca;
        this.modello = altraAuto.modello;
        this.cilindrata = altraAuto.cilindrata;
        this.annoacquisto = altraAuto.annoacquisto;
        this.numeroposti = altraAuto.numeroposti;
    }

    //Metodi getter
    public String getTarga() {
}
