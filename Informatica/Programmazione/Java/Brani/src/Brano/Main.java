package brano;

public class Main {
    public static void main(String[] args) {
        Canzone canzone1 = new Canzone("Blinding Lights", "The Weeknd", 200, "Pop");
        Canzone canzone2 = new Canzone("Bohemian Rhapsody", "Queen", 354, "Rock");
        Canzone canzone3 = new Canzone("Bad Guy", "Billie Eilish", 194, "Eletronica");
        Canzone canzone4 = new Canzone("Lose Yourself", "Eminem", 326, "Rap");
        Canzone canzone5 = new Canzone("Shape of You", "Ed Sheeran", 233, "Pop");

    //Stampa Detagli Canzoni
    stampaDettagli(canzone1);

    //Simulazione Riproduzioni
        canzone1.riproduci();
        canzone1.riproduci();
        canzone2.riproduci();
        canzone3.riproduci();
        canzone3.riproduci();
        canzone3.riproduci();
        canzone4.riproduci();
        canzone5.riproduci();
        canzone5.riproduci();
        canzone2.riproduci();

    //Test getter
        System.out.println("\nNumero di riproduzioni di '" + canzone1.getTitolo() + "': " + canzone1.getRiproduzioni());
        System.out.println("Durata formattata di '" + canzone2.getTitolo() + "': " + canzone2.getDurataFormattata());
        System.out.println("Categoria durata di '" + canzone3.getTitolo() + "': " + canzone3.getCategoriaDurata());

    //Durata formattata
        System.out.println("\nDurata formattata di tutte le canzoni:");
        System.out.println(canzone1.getTitolo() + ": " + canzone1.getDurataFormattata());
        System.out.println(canzone2.getTitolo() + ": " + canzone2.getDurataFormattata());
        System.out.println(canzone3.getTitolo() + ": " + canzone3.getDurataFormattata());
        System.out.println(canzone4.getTitolo() + ": " + canzone4.getDurataFormattata());
        System.out.println(canzone5.getTitolo() + ": " + canzone5.getDurataFormattata());
    
    //ToString
        System.out.println("\nDettagli completi delle canzoni:");
        System.out.println(canzone1);
        System.out.println();
        System.out.println(canzone2);
        System.out.println();
        System.out.println(canzone3);
        System.out.println();
        System.out.println(canzone4);
        System.out.println();
        System.out.println(canzone5);

    }
}