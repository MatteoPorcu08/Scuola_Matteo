package gestione;

/**
 * Classe di test per il sistema di gestione libreria videogiochi
 * @author Matteo
 * @version 3.2
 * @return restituisce un messaggio di benvenuto e dimostra le funzionalità della libreria
 * Data 23/02/2026
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("---Gestione Libreria Videogiochi---\n");


        Libreria libreria = new Libreria(10);
        System.out.println("Libreria creata con successo (dimensione 10)");

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

        System.out.println("3. Visualizzazione dei videogiochi presenti in libreria:");
        libreria.visualizzaLibreria();

        System.out.println("\n4.Rimuovere il gioco in posizione 2 (indice 2) e stampare la libreria.");
        libreria.rimuoviVideogioco(2);
        libreria.visualizzaLibreria();

        System.out.println("\n5.Rimuovere un videogioco per titolo (scegliere uno dei titoli inseriti) e stampare la libreria.");
        libreria.rimuoviVideogiocoPerTitolo("Minecraft");
        libreria.visualizzaLibreria();

        System.out.println("\n6. Applicare uno sconto del 20% a tutti i giochi e stampare la libreria.");
        libreria.applicaSconto(20);

        System.out.println("\n7. Stampare il videogioco più costoso.");
        Videogioco giocoPiuCostoso = libreria.getVideogiocoPiuCostoso();
        if (giocoPiuCostoso != null) {
            System.out.println("Videogioco più costoso: " + giocoPiuCostoso);
        }

        System.out.println("\n8. Ordinare per prezzo crescente e stampare la libreria.");
        libreria.ordinaPerPrezzoCrescente();
        libreria.visualizzaLibreria();

    }
}