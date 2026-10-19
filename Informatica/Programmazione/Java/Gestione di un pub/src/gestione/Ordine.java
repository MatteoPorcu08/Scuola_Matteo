package gestione;

import java.util.ArrayList;

class Ordine {
    int numeroTavolo;
    ArrayList<Prodotto> prodottiOrdinati = new ArrayList<>();

    public Ordine(int numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
    }

    public void aggiungiProdottoAllOrdine(Prodotto p) {
        prodottiOrdinati.add(p);
    }
}