package Cucina;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci il nome della ricetta:");
        String nome = s.nextLine();
        System.out.println("Inserisci il tempo di preparazione:");
        int tempoPreparazione = s.nextInt();
        System.out.println("Inserisci la difficolta:");
        int difficolta = s.nextInt();
        System.out.println("Inserisci le porzioni desiderate:");
        int porzioni = s.nextInt();


        s.close();
    }
}