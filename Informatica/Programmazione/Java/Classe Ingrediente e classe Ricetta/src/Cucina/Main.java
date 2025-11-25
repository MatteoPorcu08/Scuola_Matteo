package Cucina;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci il nome della ricetta:");
        String nome = s.nextLine();
        System.out.println("Inserisci il tempo di preparazione:");
        int tempoPreparazione = s.nextLine();
        System.out.println("Inserisci la difficolta:");


        s.close();
    }
}
