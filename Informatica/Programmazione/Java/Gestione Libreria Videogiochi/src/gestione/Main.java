package gestione;

/**
 * Classe di test per il sistema di gestione libreria videogiochi
 * @author Matteo
 * @version 3.2
 * Data 23/02/2026
 */
public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== TEST GESTIONE LIBRERIA VIDEOGIOCHI ===\n");
        
        // 1. Creare una nuova Libreria
        Libreria libreria = new Libreria();
        System.out.println("1. Libreria creata con successo (dimensione 10)");
        
        // 2. Creare almeno 6 oggetti Videogioco e inserirli
        System.out.println("\n2. Creazione e inserimento di 6 videogiochi:");
        
        Videogioco gioco1 = new Videogioco("The Last of Us", "Azione", 2013, 59.99, false);
        Videogioco gioco2 = new Videogioco("FIFA 24", "Sport", 2023, 69.99, true);
        Videogioco gioco3 = new Videogioco("Minecraft", "Sandbox", 2011, 29.99, true);
        Videogioco gioco4 = new Videogioco("God of War", "Azione", 2022, 49.99, false);
        Videogioco gioco5 = new Videogioco("Mario Kart", "Corse", 2020, 39.99, true);
        Videogioco gioco6 = new Videogioco("Cyberpunk 2077", "RPG", 2020, 34.99, false);
        
        libreria.aggiungiVideogioco(gioco1);
        libreria.aggiungiVideogioco(gioco2);
        libreria.aggiungiVideogioco(gioco3);
        libreria.aggiungiVideogioco(gioco4);
        libreria.aggiungiVideogioco(gioco5);
        libreria.aggiungiVideogioco(gioco6);
        
        System.out.println("Inseriti 6 videogiochi");
        
        // 3. Stampare la libreria
        System.out.println("\n3. Visualizzazione libreria iniziale:");
        libreria.visualizzaLibreria();
        
        // 4. Rimuovere il gioco in posizione 2 e stampare
        System.out.println("4. Rimozione gioco in posizione 2:");
        boolean rimossa = libreria.rimuoviVideogioco(2);
        System.out.println("Rimozione " + (rimossa ? "riuscita" : "fallita"));
        libreria.visualizzaLibreria();
        
        // 5. Rimuovere un videogioco per titolo
        System.out.println("5. Rimozione gioco con titolo 'FIFA 24':");
        boolean rimossaTitolo = libreria.rimuoviTitolo("FIFA 24");
        System.out.println("Rimozione " + (rimossaTitolo ? "riuscita" : "fallita"));
        libreria.visualizzaLibreria();
        
        // 6. Applicare sconto del 20% a tutti
        System.out.println("6. Applicazione sconto del 20% a tutti i giochi:");
        libreria.applicaScontoATutti(20);
        libreria.visualizzaLibreria();
        
        // 7. Stampare il videogioco più costoso
        System.out.println("7. Videogioco più costoso:");
        Videogioco piuCostoso = libreria.trovaPiuCostoso();
        if (piuCostoso != null) {
            System.out.println(piuCostoso);
        } else {
            System.out.println("Nessun gioco presente");
        }
        
        // 8. Ordinare per prezzo crescente e stampare
        System.out.println("\n8. Ordinamento per prezzo crescente:");
        libreria.ordinaPerPrezzoCrescente();
        libreria.visualizzaLibreria();
        
        // Test aggiuntivi
        System.out.println("\n=== TEST AGGIUNTIVI ===");
        
        // Test contaMultiplayer
        System.out.println("Giochi multiplayer: " + libreria.contaMultiplayer());
        
        // Test calcolaValoreTotale e mediaPrezzi
        System.out.println("Valore totale libreria: €" + libreria.calcolaValoreTotale());
        System.out.println("Media prezzi: €" + libreria.mediaPrezzi());
        
        // Test filtraPerGenere
        System.out.println("\nFiltro per genere 'Azione':");
        Videogioco[] azione = libreria.filtraPerGenere("Azione");
        for (Videogioco g : azione) {
            System.out.println(g);
        }
        
        // Test ordinamento per anno
        System.out.println("\nOrdinamento per anno (decrescente):");
        libreria.ordinaPerAnnoDecrescente();
        libreria.visualizzaLibreria();
        
        // Test compattazione
        System.out.println("Compattazione libreria:");
        libreria.compattaLibreria();
        libreria.visualizzaLibreria();
    }
}