package elenco;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner s = new Scanner (System.in)) { //importa la classe Scanner per input da tastiera

            //creazione prima persona tramite input da tastiera
            System.out.println("Inserisci il nome della prima persona:");
            String nome1 = s.nextLine();
            System.out.println("Inserisci il cognome della prima persona:");
            String cognome1 = s.nextLine();
            System.out.println("Inserisci l'età della prima persona:");
            int eta1 = s.nextInt();
            System.out.println("Inserisci l'altezza della prima persona:");
            float altezza1 = s.nextFloat();
            s.nextLine(); // Consuma il newline rimasto
            Persona persona1 = new Persona (nome1, cognome1, eta1, altezza1);
            System.out.println("---Prima persona creata--- \n" + persona1);

            System.out.println("\n");

            //creazione seconda persona tramite input da tastiera
            System.out.println("Inserisci il nome della seconda persona:");
            String nome2 = s.nextLine();
            System.out.println("Inserisci il cognome della seconda persona:");
            String cognome2 = s.nextLine();
            System.out.println("Inserisci l'età della seconda persona:");
            int eta2 = s.nextInt();
            System.out.println("Inserisci l'altezza della seconda persona:");
            float altezza2 = s.nextFloat();
            s.nextLine(); // Consuma il newline rimasto
            Persona persona2 = new Persona (nome2, cognome2, eta2, altezza2);
            System.out.println("---Seconda persona creata---" + persona2);
            System.out.println("\n");

            //creazione terza persona tramite costruttore di copia
            Persona persona3 = new Persona (persona1);
            System.out.println("---Terza persona creata tramite costruttore di copia della prima---\n " + persona3);
            System.out.println("\n");

            //confronto tra la prima e la seconda persona
            System.out.println("\n---Confronto età tra la prima e la seconda persona---");
            System.out.println(persona1.confrontaEta(persona2));
            System.out.println("\n");
        }
    }
}