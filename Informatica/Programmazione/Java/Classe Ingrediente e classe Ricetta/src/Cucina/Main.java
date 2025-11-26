package Cucina;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        //chiedo l'input all'utente
        System.out.println("Inserisci il nome della ricetta:");
        String nome = s.nextLine();

        System.out.println("Inserisci il tempo di preparazione (minuti):");
        int tempoPreparazione = s.nextInt();

        System.out.println("Inserisci il numero di porzioni:");
        int porzioni = s.nextInt();

        //Ingredienti manuali
        Ingrediente ingr1 = new Ingrediente("Pasta", 200, "g", 350, 0.50, true);
        Ingrediente ingr2 = new Ingrediente("Pomodoro", 150, "g", 40, 0.30, true);
        Ingrediente ingr3 = new Ingrediente("Olio", 20, "g", 900, 1.00, true);

        //Creazione ricetta
        Ricetta ricetta = new Ricetta(nome, tempoPreparazione, porzioni, ingr1, ingr2, ingr3);

        //Stampo la ricetta
        System.out.println("\n--- RICETTA COMPLETA ---");
        System.out.println(ricetta);

        // Stampo gli ingredienti
        System.out.println("\n--- INGREDIENTI ---");
        System.out.println("Ingrediente 1:\n" + ingr1);
        System.out.println("Ingrediente 2:\n" + ingr2);
        System.out.println("Ingrediente 3:\n" + ingr3);
        s.close();
    }
}