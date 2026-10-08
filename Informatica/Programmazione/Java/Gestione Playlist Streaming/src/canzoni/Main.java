package canzoni;

public class Main {
    public static void main(String[] args) {
        PlaylistManager playlistManager = new PlaylistManager();

        playlistManager.aggiungiCanzone(new Canzone("Shape of You", "Ed Sheeran", 240));
        playlistManager.aggiungiCanzone(new Canzone("Blinding Lights", "The Weeknd", 200));
        playlistManager.aggiungiCanzone(new Canzone("Levitating", "Dua Lipa", 220));

        // Verifica se una canzone è presente nella playlist
        System.out.println("Contiene 'Shape of You': " + playlistManager.contieneCanzone("Shape of You"));

        // Rimuove una canzone dalla playlist
        boolean rimosso = playlistManager.rimuoviCanzone("Blinding Lights");
        System.out.println("Rimosso 'Blinding Lights': " + rimosso);

        // Ricerca canzoni per durata
        System.out.println("Canzoni con durata tra 200 e 250 secondi:");
        for (Canzone canzone : playlistManager.ricercaPerDurata(200, 250)) {
            System.out.println(canzone);
        }

        // Modifica la durata di una canzone
        boolean modificato = playlistManager.modificaDurata("Levitating", 230);
        System.out.println("Modificata durata di 'Levitating': " + modificato);
    }
}