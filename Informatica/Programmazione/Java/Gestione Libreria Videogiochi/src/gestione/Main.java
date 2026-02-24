package gestione;

/**
 * Classe di test per il sistema di gestione libreria videogiochi
 * @author Matteo
 * @version 3.4
 * Data 24/02/2026
 */
public class Main {

    public static void main(String[] args) {

        // Creo una nuova Libreria
        Libreria libreria = new Libreria(10);

        // Creo 6 oggetti Videogioco e inserirli
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

        // Stampo la libreria
        System.out.println("Libreria attuale:");
        libreria.visualizzaLibreria();

        // Rimuovo il gioco in posizione 2 (indice 2)
        System.out.println("\nRimozione gioco in posizione 2:");
        libreria.rimuoviVideogioco(2);
        libreria.visualizzaLibreria();

        // Rimuovo un videogioco per titolo
        System.out.println("\nRimozione gioco con titolo 'FIFA 24':");
        libreria.rimuoviTitolo("FIFA 24");
        libreria.visualizzaLibreria();

        // Applico uno sconto del 20% a tutti i giochi
        System.out.println("\nApplicazione sconto 20% a tutti i giochi:");
        libreria.applicaScontoATutti(20);
        libreria.visualizzaLibreria();

        // Stampo il videogioco più costoso
        System.out.println("\nVideogioco più costoso:");
        Videogioco piuCostoso = libreria.trovaPiuCostoso();
        if (piuCostoso != null) {
            System.out.println(piuCostoso);
        }

        // Ordino per prezzo crescente
        System.out.println("\nOrdinamento per prezzo crescente:");
        libreria.ordinaPerPrezzoCrescente();
        libreria.visualizzaLibreria();
    }
}