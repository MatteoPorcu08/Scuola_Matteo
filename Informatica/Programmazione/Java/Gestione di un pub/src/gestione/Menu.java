package gestione;

import java.util.ArrayList;


abstract class Menu {
    protected ArrayList<Prodotto> listaProdotti = new ArrayList<>();

    public abstract void mostraMenu();
    
    public void aggiungiProdotto(Prodotto p) {
        listaProdotti.add(p);
    }
}