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
    }

    //Simulare riproduzioni
    canzone1.getRiproduzioni();

    //Testare i getter
    

}