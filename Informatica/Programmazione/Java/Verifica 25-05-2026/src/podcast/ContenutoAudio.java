package podcast;
public class ContenutoAudio {
    protected String titolo;
    protected String autore;
    protected int durataMinuti;
    protected int annoPubblicazione;
    protected int riproduzioni;

    public ContenutoAudio (String titolo,String autore, int durataMinuti, int annoPubblicazione,int riproduzioni){
        this.titolo=titolo;
        this.autore= autore;
        this.durataMinuti= durataMinuti;
        this.annoPubblicazione= annoPubblicazione;
        this.riproduzioni= 0;
    }

    //Getters
    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    public int getDurataMinuti() {
        return durataMinuti;
    }
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    public int getRiproduzioni() {
        return riproduzioni;
    }

    //Setters
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public void setDurataMinuti(int durataMinuti) {
        this.durataMinuti = durataMinuti;
    }
    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }
    public void setRiproduzioni(int riproduzioni) {
        this.riproduzioni = riproduzioni;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "ContenutoAudio [titolo=" + titolo + ", autore=" + autore + ", durataMinuti=" + durataMinuti
                + ", annoPubblicazione=" + annoPubblicazione + ", riproduzioni=" + riproduzioni + "]";
    }

    //Metodo public void ascolta()
    public void ascolta(){
        riproduzioni +=1;
    }

    //Metodo public boolean isPopolare()
    public boolean isPopolare(){
        if(riproduzioni>50){
            return true;
        }
        return false;
    }
}