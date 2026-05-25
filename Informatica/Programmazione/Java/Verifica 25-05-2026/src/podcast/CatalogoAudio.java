package podcast;
public class CatalogoAudio {
    private String nome;
    private ContenutoAudio[] contenuti;
    private int numeroContenuti;

    public CatalogoAudio(String nome) {
        this.nome = nome;
        this.contenuti = new ContenutoAudio[100];
        this.numeroContenuti = 0;
    }

    //Metodo aggiungiContenuto(ContenutoAudio contenuto)
    public void aggiungiContenuto(ContenutoAudio contenuto) {
        if (numeroContenuti >= contenuti.length) {
            contenuti[numeroContenuti]= contenuto;
            numeroContenuti++;
        }
    }

    //Metodo rimuoviContenuto(String titolo)
    public boolean rimuoviContenuto(String titolo){
        for (int i = 0; i < numeroContenuti; i++) {
            if (contenuti[i].getTitolo().equals(titolo)) {
                contenuti[i] = contenuti[numeroContenuti - 1];
                contenuti[numeroContenuti - 1] = null;
                numeroContenuti--;
                return true;
            }
        }
        return false;
    }

    //Metodo cercaContenuto(String titolo)
    public ContenutoAudio cercaContenuto(String titolo){
        if(titolo != null){
        for (int i = 0; i < numeroContenuti; i++) {
            if (contenuti[i].getTitolo().equals(titolo)) {
                return contenuti[i];
            }
            }
        }
        return null;
    }

    //Metodo String visualizzaCatalogo()
    public String visualizzaCatalogo(){
        String stringa = "";
        for (int i = 0; i < numeroContenuti; i++){
            if(contenuti[i] != null){
                stringa += "contenuti[i]";
            }
        }
        return stringa;
    }

    //Metodo getNumeroContenuti()
    public int getNumeroContenuti(){
        return numeroContenuti;
    }
}