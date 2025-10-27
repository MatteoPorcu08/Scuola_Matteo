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
        stampaDettagli(canzone2);
        stampaDettagli(canzone3);
        stampaDettagli(canzone4);
        stampaDettagli(canzone5);

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





    }

}
