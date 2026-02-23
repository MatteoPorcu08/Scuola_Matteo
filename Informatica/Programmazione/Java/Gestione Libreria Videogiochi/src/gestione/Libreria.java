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
    public void aggiungiVideogioco(Videogioco v) {
        if (numVideogiochi < giochi.length) {
            giochi[numVideogiochi] = v;
            numVideogiochi++;
        } else {
            System.out.println("Libreria piena, impossibile aggiungere il videogioco.");
        }
    }

    //Metodo rimuoviVideogioco(int posizione)
    public void rimuoviVideogioco(int posizione) {
        if (posizione >= 0 && posizione < numVideogiochi) {
            for (int i = posizione; i < numVideogiochi - 1; i++) {
                giochi[i] = giochi[i + 1];
            }
            giochi[numVideogiochi - 1] = null; // Rimuove l'ultimo elemento
            numVideogiochi--;
        } else {
            System.out.println("Posizione non valida, impossibile rimuovere il videogioco.");
        }
    }

    //Metodo rimuoviTitolo(String titolo)
    public void rimuoviTitolo(String titolo) {
        for (int i = 0; i < numVideogiochi; i++) {
            if (giochi[i].getTitolo().equals(titolo)) {
                rimuoviVideogioco(i);
                return;
            }
        }
        System.out.println("Titolo non trovato, impossibile rimuovere il videogioco.");
    }

    //Metodo cercaVideogioco(String titolo)


}
