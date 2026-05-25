package podcast;
public class Podcast extends ContenutoAudio {
    public String argomento;
    public boolean contieneOspiti;

    public Podcast(String titolo, String autore, int durataMinuti, int annoPubblicazione, int riproduzioni,String argomento, boolean contieneOspiti) {
        super(titolo, autore, durataMinuti, annoPubblicazione, riproduzioni);
        this.argomento = argomento;
        this.contieneOspiti = contieneOspiti;
    }

    //Getters
    public  String getCategoria(){
        return "Podcast";
    }
    public String getArgomento() {
        return argomento;
    }
    public boolean getContieneOspiti() {
        return contieneOspiti;
    }

    //Metodo toString()
    @Override
    public String toString() {
        return  super.toString()+"Podcast argomento=" + argomento + ", contieneOspiti=" + contieneOspiti ;
    }
}