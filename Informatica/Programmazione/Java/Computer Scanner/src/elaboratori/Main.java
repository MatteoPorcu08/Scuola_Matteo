package elaboratori;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        //creo due oggetti computer
        computer pc1 = new comeputer;
        computer pc2 = new comeputer;
        System 
        
        
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