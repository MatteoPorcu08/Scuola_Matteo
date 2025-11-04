package elaboratori;
public class Main {
    public static void main(String[] args) {
        elaboratori.Computer pc1 = new elaboratori.Computer("Asus", "ZenBook", 999.99, "Intel i7", 16, 512);
        elaboratori.Computer pc2 = new elaboratori.Computer("Dell", "XPS 13", 1199.99, "Intel i5", 8, 256);
        
        // Stampa utilizzando il metodo toString
        System.out.println("\nUtilizzando toString():");
        System.out.println(pc1.toString());
        System.out.println(pc2.toString());
        System.out.println("\n");

        // Stampa la fascia di prezzo
        System.out.println("\nFascia di prezzo:");
        System.out.println("Computer 1: " + pc1.ottieniFasciaDiPrezzo());
        System.out.println("Computer 2: " + pc2.ottieniFasciaDiPrezzo());
        System.out.println("\n");

        //stampo i metodi aggiuntivi
        //stampo il emtodo aggiornaPrezzo
        System.out.println("\nAggiorna Prezzo");
        System.out.println("Computer 1 nuovo prezzo: " + pc1.aggiornaPrezzo(10) + "€");
        System.out.println("Computer 2 nuovo prezzo: " + pc2.aggiornaPrezzo(15) + "€");
        System.out.println("\n");

        //stampo il metodo upgradeRam
        System.out.println("\nUpgrade RAM");
        
    }
}
