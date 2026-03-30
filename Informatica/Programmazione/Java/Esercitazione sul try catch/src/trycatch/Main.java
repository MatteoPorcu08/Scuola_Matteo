package trycatch;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        ConsoleInput console = new ConsoleInput();
        // Esercizio 5
        try {
            System.out.print("Inserisci l'età: ");
            int num = console.readInt();
            System.out.println("Hai inserito: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Errore di formato: non hai inserito un numero intero valido.");
        } catch (IOException e) {
            System.out.println("Errore di input/output: " + e.getMessage());
        }

        // Esercizio 6
        double somma = 0;
        for (int i = 0; i < 3; i++) {
            try {
                System.out.print("Inserisci un numero double: ");
                double num = console.readDouble();
                somma += num;
            } catch (NumberFormatException e) {
                System.out.println("Errore di formato: non hai inserito un numero double valido.");
            } catch (IOException e) {
                System.out.println("Errore di input/output: " + e.getMessage());
            }
        }
        System.out.println("La somma dei numeri inseriti è: " + somma);
    }
}