package Cucina;

import java.util.Scanner;

public class Main {
    Scanner s = new Scanner(System.in);

    System.out.println("Ciao! Benvenuto nella cucina");
    System.out.println("\nInserisci il nome della ricetta:");
    String nomeRicetta = s.nextLine();
    Ricetta ricetta = new Ricetta(nomeRicetta);
    boolean continua = true;

}
