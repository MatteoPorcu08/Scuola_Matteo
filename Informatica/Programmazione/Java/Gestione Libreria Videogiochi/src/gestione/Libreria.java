package gestione;

public class Libreria {
    
    private Videogioco[] giochi;
    private int numVideogiochi;

    //Costruttore
    public Libreria(int dimensione) {
        giochi = new Videogioco[dimensione];
        numVideogiochi = 0;
    }

    //Costruttore di copia
    public Libreria(Libreria altraLibreria) {
        this.giochi = new Videogioco[altraLibreria.giochi.length];
        for (int i = 0; i < altraLibreria.numVideogiochi; i++) {
            this.giochi[i] = new Videogioco(altraLibreria.giochi[i]);
        }
        this.numVideogiochi = altraLibreria.numVideogiochi;
    }

    //Metodo aggiungiVideogioco(Videogioco v)
    public boolean aggiungiVideogioco(Videogioco v) {
        if (numVideogiochi < giochi.length) {
            giochi[numVideogiochi] = v;
            numVideogiochi++;
            return true;
        } else {
            System.out.println("Libreria piena, impossibile aggiungere il videogioco.");
            return false;
        }
    }

    //Metodo rimuoviVideogioco(int posizione)
    public boolean rimuoviVideogioco(int posizione) {
        if (posizione >= 0 && posizione < numVideogiochi) {
            for (int i = posizione; i < numVideogiochi - 1; i++) {
                giochi[i] = giochi[i + 1];
            }
            giochi[numVideogiochi - 1] = null; // Rimuove l'ultimo elemento
            numVideogiochi--;
            return true;
        } else {
            System.out.println("Posizione non valida, impossibile rimuovere il videogioco.");
            return false;
        }
    }

    //Metodo rimuoviTitolo(String titolo)
    public boolean rimuoviTitolo(String titolo) {
        for (int i = 0; i < numVideogiochi; i++) {
            if (giochi[i].getTitolo().equals(titolo)) {
                rimuoviVideogioco(i);
                return true;
            }
        }
        System.out.println("Titolo non trovato, impossibile rimuovere il videogioco.");
        return false;
    }

    //Metodo cercaVideogioco(String titolo)
    public Videogioco cercaVideogioco(String titolo) {
        for (int i = 0; i < numVideogiochi; i++) {
            if (giochi[i].getTitolo().equals(titolo)) {
                return giochi[i];
            }
        }
        System.out.println("Titolo non trovato.");
        return null;
    }

    //Metodo visualizzaLibreria()
    public void visualizzaLibreria() {
        if (numVideogiochi == 0) {
            System.out.println("La libreria è vuota.");
        } else {
            System.out.println("Libreria Videogiochi:");
            for (int i = 0; i < numVideogiochi; i++) {
                System.out.println(giochi[i]);
            }
        }
    }

    //Metodo contaMultiplayer()
    public int contaMultiplayer() {
        int count = 0;
        for (int i = 0; i < numVideogiochi; i++) {
            if (giochi[i].isMultiplayer()) {
                count++;
            }
        }
        return count;
    }

    //Metodo calcolaValoreTotale()
    public double calcolaValoreTotale() {
        double totale = 0.0;
        for (int i = 0; i < numVideogiochi; i++) {
            totale += giochi[i].getPrezzo();
        }
        return totale;
    }

    //Metodo mediaPrezzi()
    public double mediaPrezzi() {
        if (numVideogiochi == 0) {
            return 0.0;
        }
        return calcolaValoreTotale() / numVideogiochi;
    }


}
