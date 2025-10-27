package brano;

public class Canzone {
    private String titolo;
    private String artista;
    private int durata; // durata in secondi
    private String genere;
    private int riproduzioni;


    // Costruttore
    public Canzone (String titolo, String artista, int durata, String genere) {
        this.titolo = titolo;
        this.artista = artista;
        this.durata = durata;
        this.genere = genere;
        this.riproduzioni = 0;
    }

    //Setter
    private void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    private void setArtista(String artista) {
        this.artista = artista;
    }
    private void setDurata(int durata) {
        this.durata = durata;
    }
    private void setGenere(String genere) {
        this.genere = genere;
    }
    private void setRiproduzioni(int riproduzioni) {
        this.riproduzioni = riproduzioni;
    }

    //Getter
    public String getTitolo() {
        return titolo;
    }
    public String getArtista() {
        return artista;
    }
    public int getDurata() {
        return durata;
    }
    public String getGenere() {
        return genere;
    }
    public int getRiproduzioni() {
        return riproduzioni;
    }

    //Metodi Specifici
    void riproduci() {
        riproduzioni++;
        System.out.println("Riproducendo: " + titolo + " di " + artista);
    }
    String getDurataFormattata() {
        int minuti = durata / 60;
        int secondi = durata % 60;
        return minuti + "m " + secondi + "s";
    }
    String stampaDettagli() {
        return "Titolo: " + titolo + "\nArtista: " + artista;
    }
    String getCategoriaDurata(){
        if(durata < 180){
            return "Canzone Breve";
        } else if(durata >= 180 && durata <= 300){
            return "Canzone Media";
        } else {
            return "Canzone Lunga";
    }
}
    //toString
    public String toString() {
        return "Titolo : " + titolo + "\nArtista: " + artista + "\nDurata: " + getDurataFormattata() + "\nGenere: " + genere + "\nRiproduzioni: " + riproduzioni + "\nCategoria Durata: " + getCategoriaDurata();
    }
}