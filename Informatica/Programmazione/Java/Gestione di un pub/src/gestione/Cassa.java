package gestione;

import java.util.ArrayList;

class Cassa {
    public ArrayList<Prodotto>[] contiTavoli = new ArrayList[40];

    public Cassa() {
        for (int i = 1; i <= 40; i++) {
            contiTavoli[i] = new ArrayList<>();
        }
    }

    public void registraOrdine(Ordine o) {
        contiTavoli[o.numeroTavolo].addAll(o.prodottiOrdinati);
    }

    public void calcolaEStampaConto(int numeroTavolo) {
        ArrayList<Prodotto> consumazioni = contiTavoli[numeroTavolo];

        if (consumazioni.isEmpty()) {
            System.out.println("Il tavolo " + numeroTavolo + " non ha consumazioni active.");
            return;
        }

        double totale = 0;
        System.out.println("\n--- SCONTRINO CASSA - TAVOLO " + numeroTavolo + " ---");
        for (Prodotto p : consumazioni) {
            System.out.println(p.nome + " : " + p.prezzo + "€");
            totale += p.prezzo;
        }

        System.out.println("TOTALE DA PAGARE: " + totale + " €");

    }
}