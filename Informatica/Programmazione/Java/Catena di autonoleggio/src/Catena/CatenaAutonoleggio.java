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
        return targa;
    }
    public String getMarca() {
        return marca;
    }
    public String getModello() {
        return modello;
    }
    public int getCilindrata() {
        return cilindrata;
    }
    public int getAnnoacquisto() {
        return annoacquisto;
    }
    public int getNumeroposti() {
        return numeroposti;
    }

    //Metodo setter
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }
    public void setAnnoacquisto(int annoacquisto) {
        this.annoacquisto = annoacquisto;
    }
    public void setNumeroposti(int numeroposti) {
        this.numeroposti = numeroposti;
    }

    //Metodo toString
    public String toString() {
        return "CatenaAutonoleggio \ntarga:" + targa + "\n marca:" + marca + "\n modello:" + modello + "\ncilindrata:" + cilindrata + "\nannoacquisto:" + annoacquisto + "\nnumeroposti:" + numeroposti + "";
    }

    //Metodo confrontaautopotenza
    public String confrontaautopotenza(CatenaAutonoleggio altraAuto) {
        if (this.cilindrata > altraAuto.cilindrata) {
            return ("L'auto" + this.marca + " " + this.modello + " ha una cilindrata maggiore.");
        } else if (this.cilindrata < altraAuto.cilindrata) {
            return ("L'auto" + altraAuto.marca + " " + altraAuto.modello + " ha una cilindrata maggiore.");
        } else {
            return ("Le due auto hanno la stessa cilindrata.");
        }
    }

    //Metodo nolleggio
    public String nolleggio() {
        if (this.numeroposti >= 5) {
            return ("L'auto " + this.marca + " " + this.modello + " è adatta per il noleggio.");
        } else {
            return ("L'auto " + this.marca + " " + this.modello + " non è adatta per il noleggio. ");
        }
    }
}