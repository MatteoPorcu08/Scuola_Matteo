package brano;
public class Main {
    public static void main(String[] args) {
        Canzone canzone1 = new Canzone("Blinding Lights", "The Weeknd", 200, "Pop");
        Canzone canzone2 = new Canzone("Bohemian Rhapsody", "Queen", 354, "Rock");
        Canzone canzone3 = new Canzone("Bad Guy", "Billie Eilish", 194, "Eletronica");
        Canzone canzone4 = new Canzone("Lose Yourself", "Eminem", 326, "Rap");
        Canzone canzone5 = new Canzone("Shape of You", "Ed Sheeran", 233, "Pop");

    //Stampa dettagli canzoni
        System.out.println("Dettagli delle canzoni:");
        System.out.println("\n");
        System.out.println("Detagli Canzone 1:");
        System.out.println(canzone1.stampaDettagli());
        System.out.println("Detagli Canzone 2:");
        System.out.println(canzone2.stampaDettagli());
        System.out.println("Detagli Canzone 3:");
        System.out.println(canzone3.stampaDettagli());
        System.out.println("Detagli Canzone 4:");
        System.out.println(canzone4.stampaDettagli());
        System.out.println("Detagli Canzone 5:");
        System.out.println(canzone5.stampaDettagli());
        System.out.println("\n");

        //Simulare riproduzioni
        System.out.println("\nSimulazione riproduzioni:");
        System.out.println(canzone1.riproduci());
        System.out.println(canzone2.riproduci());
        System.out.println(canzone1.riproduci());
        System.out.println(canzone3.riproduci());
        System.out.println(canzone1.riproduci());
        System.out.println(canzone4.riproduci());
        System.out.println(canzone5.riproduci());
        System.out.println(canzone2.riproduci());
        System.out.println(canzone3.riproduci());
        System.out.println(canzone5.riproduci());
        System.out.println("\n");

        //Testare i getter
        System.out.println("Test dei getter:");
        System.out.println("Titolo canzone 1: " + canzone1.getTitolo());
        System.out.println("Artista canzone 2: " + canzone2.getArtista());
        System.out.println("Durata canzone 3: " + canzone3.getDurata() + " secondi");
        System.out.println("Genere canzone 4: " + canzone4.getGenere());
        System.out.println("Riproduzioni canzone 5: " + canzone5.getRiproduzioni());
        System.out.println("\n");
        
        //Testare i setter
        System.out.println("Test dei setter:");

        //Mostrare la durata formattata
        System.out.println(canzone1.getDurataFormattata());
        System.out.println(canzone2.getDurataFormattata());
        System.out.println(canzone3.getDurataFormattata());
        System.out.println(canzone4.getDurataFormattata());
        System.out.println(canzone5.getDurataFormattata());
        System.out.println("\n");

        //Utilizzare il metodo toString()
        System.out.println("Dettagli completi delle canzoni:");
        System.out.println("\nCanzone 1:\n" + canzone1.toString());
        System.out.println("\nCanzone 2:\n" + canzone2.toString());
        System.out.println("\nCanzone 3:\n" + canzone3.toString());
        System.out.println("\nCanzone 4:\n" + canzone4.toString());
        System.out.println("\nCanzone 5:\n" + canzone5.toString());
    }
}