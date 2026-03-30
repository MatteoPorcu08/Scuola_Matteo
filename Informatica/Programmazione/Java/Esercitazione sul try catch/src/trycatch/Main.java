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
        }

        // Esercizio 6

    }
}