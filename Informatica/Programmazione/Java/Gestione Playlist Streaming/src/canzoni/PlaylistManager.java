package canzoni;

import java.util.ArrayList;

public class PlaylistManager {
    private ArrayList<Canzone> playlist;

    public void aggiungiCanzone(Canzone canzone) {
        playlist.add(canzone);
    }

    public boolean rimuoviCanzone(String titolo) {
        for (int i = 0; i < playlist.size(); i++) {
            Canzone canzone = playlist.get(i);
            if (canzone.getTitolo().equals(titolo)) {
                playlist.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean contieneCanzone(String titolo) {
        for (Canzone canzone : playlist) {
            if (canzone.getTitolo().equals(titolo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Canzone> ricercaPerDurata(int minDurata, int maxDurata) {
        ArrayList<Canzone> risultati = new ArrayList<>();
        for (Canzone canzone : playlist) {
            if (canzone.getDurata() >= minDurata && canzone.getDurata() <= maxDurata) {
                risultati.add(canzone);
            }
        }
        return risultati;
    }

    public boolean modificaDurata(String titolo, int nuovaDurata) {
        for (Canzone canzone : playlist) {
            if (canzone.getTitolo().equals(titolo)) {
                canzone.setDurata(nuovaDurata);
                return true;
            }
        }
        return false;
    }

    public boolean ricercaPerArtista(String artista) {
        for (Canzone canzone : playlist) {
            if (canzone.getArtista().equals(artista)) {
                return true;
            }
        }
        return false;
    }
}