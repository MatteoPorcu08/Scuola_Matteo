package canzoni;
public class Canzone {
    private String titolo;
    private String artista;
    private int durata; // in secondi

    public Canzone(String titolo, String artista, int durata) {
        this.titolo = titolo;
        this.artista = artista;
        this.durata = durata;
    }

    // Getters
    public String getTitolo() {
        return titolo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDurata() {
        return durata;
    }

    // Setters
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    //Metodo equals per confrontare due canzoni
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Canzone canzone = (Canzone) obj;
        return titolo.equals(canzone.titolo) && artista.equals(canzone.artista);
    }

    //Metodo toString per rappresentare la canzone come stringa
    @Override
    public String toString() {
        return "Canzone{" +"titolo='" + titolo + '\'' +", artista='" + artista + '\'' +", durata=" + durata +'}';
    }
}