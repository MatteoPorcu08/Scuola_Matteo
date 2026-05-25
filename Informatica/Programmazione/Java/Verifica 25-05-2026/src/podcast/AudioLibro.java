package podcast;
public class AudioLibro extends ContenutoAudio{
    public String narratore;
    public  int numeroCapitoli;
    public boolean  versioneIntegrale;

    public AudioLibro(String titolo, String autore, int durataMinuti, int annoPubblicazione, int riproduzioni,
            String narratore, int numeroCapitoli, boolean versioneIntegrale) {
        super(titolo, autore, durataMinuti, annoPubblicazione, riproduzioni);
        this.narratore = narratore;
        this.numeroCapitoli = numeroCapitoli;
        this.versioneIntegrale = versioneIntegrale;
    }

    //Getters
    public  String getCategoria(){
        return "AudioLibro";
    }
    public String getNarratore() {
        return narratore;
    }
    public int getNumeroCapitoli() {
        return numeroCapitoli;
    }
    public boolean isVersioneIntegrale() {
        return versioneIntegrale;
    }

    //Metodo toString()
    @Override
    public String toString() {
        return super.toString()+"AudioLibro narratore=" + narratore + ", numeroCapitoli=" + numeroCapitoli + ", versioneIntegrale="
                + versioneIntegrale;
    }
}