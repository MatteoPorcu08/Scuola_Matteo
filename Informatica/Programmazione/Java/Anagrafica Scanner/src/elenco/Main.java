package elenco;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in); //importa la classe Scanner per input da tastiera

        //creazione due oggetti persona tramite input da tastiera
        System.out.println("Inserisci il nome della prima persona:");
        String nome1 = input.nextLine();
        System.out.println("Inserisci il cognome della prima persona:");
        String cognome1 = input.nextLine();
        System.out.println("Inserisci l'età della prima persona:");
        int eta1 = input.nextInt();
        System.out.println("Inserisci l'altezza della prima persona:");
        float altezza1 = input.nextFloat();
        input.nextLine(); // Consuma il newline rimasto
        Persona persona1 = new Persona (nome1, cognome1, eta1, altezza1);
        System.out.println("\n");
        System.out.println("Inserisci il nome della seconda persona:");
        String nome2 = input.nextLine();
        System.out.println("Inserisci il cognome della prima persona:");
        String cognome2 = input.nextLine();
        System.out.println("Inserisci l'età della prima persona:");
        int eta2 = input.nextInt();
        System.out.println("Inserisci l'altezza della prima persona:");
        float altezza2 = input.nextFloat();
        input.nextLine(); // Consuma il newline rimasto
        Persona persona2 = new Persona (nome1, cognome1, eta1, altezza1);

        
    }
}
