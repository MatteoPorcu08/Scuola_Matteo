package elaboratori;
public class Main {
    public static void main(String[] args) {
        elaboratori.Computer pc1 = new elaboratori.Computer("Asus", "ZenBook", 1500.99, "Ryzen 7", 32, 2000);
        elaboratori.Computer pc2 = new elaboratori.Computer("Dell", "XPS 13", 599.99, "Intel i5", 8, 256);

        // Stampa utilizzando il metodo toString
        System.out.println("\nUtilizzando toString:");
        System.out.println(pc1.toString());
        System.out.println(pc2.toString());
        System.out.println("\n");

        // Stampa la fascia di prezzo
        System.out.println("\nFascia di prezzo:");
        System.out.println("Computer 1: " + pc1.ottieniFasciaDiPrezzo());
        System.out.println("Computer 2: " + pc2.ottieniFasciaDiPrezzo());
        System.out.println("\n");

        //stampo i metodi aggiuntivi
        //stampo il metodo aggiornaPrezzo
        System.out.println("\nAggiorna Prezzo");
        System.out.println("Computer 1 nuovo prezzo: " + pc1.aggiornaPrezzo(0) + "Eur");
        System.out.println("Computer 2 nuovo prezzo: " + pc2.aggiornaPrezzo(50) + "Eur");
        System.out.println("\n");

        //stampo il metodo upgradeRam
        System.out.println("\nUpgrade RAM");
        pc1.upgradeRam(64);
        pc2.upgradeRam(16);
        System.out.println("Computer 1 dopo upgrade RAM: " + pc1.toString());
        System.out.println("Computer 2 dopo upgrade RAM: " + pc2.toString());
        System.out.println("\n");

        //stampo il metodo confrontaComputer
        System.out.println("\nConfronta Computer");
        int confronto = pc1.confrontaComputer(pc2);
        if(confronto == 1){
            System.out.println("Computer 1 è più costoso di Computer 2.");
        } else if(confronto == -1){
            System.out.println("Computer 1 è meno costoso di Computer 2.");
        } else {
            System.out.println("Entrambi i computer hanno lo stesso prezzo.");
        }

        //stampo il metodo ottieniInfoDettagliata
        System.out.println("\nInfo Dettagliate Computer 1:");
        System.out.println(pc1.ottieniInfoDettagliata());
        System.out.println("\nInfo Dettagliate Computer 2:");
        System.out.println(pc2.ottieniInfoDettagliata());
        System.out.println("\n");
    }
}