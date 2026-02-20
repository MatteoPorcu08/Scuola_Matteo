package chiavi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Creazione del portachiavi
        System.out.print("Capienza portachiavi: ");
        int capienza = input.nextInt();
        input.nextLine();

        PortaChiavi portachiavi = new PortaChiavi(capienza);

        // Inserimento delle chiavi
        System.out.print("\nQuante chiavi vuoi inserire? ");
        int numeroChiavi = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numeroChiavi; i++) {
            System.out.println("\n--- Chiave " + (i + 1) + " ---");

            System.out.print("Numero camera: ");
            int numero = input.nextInt();
            input.nextLine();

            // Mostra i tipi disponibili
            System.out.println("Tipi disponibili: singola, doppia, tripla");
            System.out.print("Tipo camera: ");
            String tipo = input.nextLine();

            System.out.print("Nome cliente: ");
            String cliente = input.nextLine();

            Chiave c = new Chiave(numero, tipo, cliente);
            portachiavi.aggiungiChiave(c);
        }

        // Stampa portachiavi
        System.out.println("\n" + portachiavi.toString());

        input.close();
    }
}