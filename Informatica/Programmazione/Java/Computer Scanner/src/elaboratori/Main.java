package elaboratori;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        //creo due oggetti computer
        
        Computer c1;
        System.out.println("Ciao, questo programma serve per catalogare i computer.");
        System.out.println("Inserisci la marca del tuo pc: ");
        String marca;
        marca=s.nextLine();
        System.out.println("Inserisci il modello del tuo pc: ");
        String modello;
        modello=s.nextLine();
        System.out.println("Inserisci il prezzo del tuo pc: ");
        double prezzo;
        prezzo=s.nextDouble();
        s.nextLine();
        System.out.println("Inserisci la CPU del tuo pc: ");
        String cpu;
        cpu=s.nextLine();
        System.out.println("Inserisci la quantità di RAM del tuo pc: ");
        int ram;
        ram=s.nextInt();
        s.nextLine();
        System.out.println("Inserisci la quantità di memoria del tuo pc: ");
        int storage;
        storage=s.nextInt();
        s.nextLine();

        Computer pc1 = new Computer(marca, modello, prezzo, cpu, ram, storage);

        Computer c2;
        System.out.println("Inserisci la marca del secondo pc: ");
        String marca2;
        marca2=s.nextLine();
        System.out.println("Inserisci il modello del secondo pc: ");
        String modello2;
        modello2=s.nextLine();
        System.out.println("Inserisci il prezzo del secondo pc: ");
        double prezzo2;
        prezzo2=s.nextDouble();
        s.nextLine();
        System.out.println("Inserisci la CPU del secondo pc: ");
        String cpu2;
        cpu2=s.nextLine();
        System.out.println("Inserisci la quantità di RAM del secondo pc: ");
        int ram2;
        ram2=s.nextInt();
        s.nextLine();
        System.out.println("Inserisci la quantità di memoria del secondo pc: ");
        int storage2;
        storage2=s.nextInt();
        s.nextLine();
        Computer pc2 = new Computer(marca2, modello2, prezzo2, cpu2, ram2, storage2);
        
        System.out.println("Benvenuto! Questo programma serve per conforntare due computer."); //Messaggio di Benvenuto

        // Stampa utilizzando il metodo toString
        System.out.println("\nSpecifiche dei computer(Utilizzando toString):");
        System.out.println("Queste sono le spocifiche del primo computer:\n");
        System.out.println(pc1.toString());
        System.out.println("\nQueste sono le spocifiche del secondo computer:\n");
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
        System.out.println("Computer 1 dopo upgrade RAM: " + pc1.getRam());
        System.out.println("Computer 2 dopo upgrade RAM: " + pc2.getRam());
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