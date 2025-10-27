public class Canzone {
    String titolo;
    String artista;
    int durata; // durata in secondi
    String genere;
    int riproduzioni;

    // Costruttore
    public Canzone (String titolo, String artista, int durata, String genere) {
        this.titolo = titolo;
        this.artista = artista;
        this.durata = durata;
        this.genere = genere;
        this.riproduzioni = 0;
    }
}
