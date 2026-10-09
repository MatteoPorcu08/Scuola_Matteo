package flotta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Automobile automobile = new Automobile("Fiat", "Panda", 2020, 5);
        Camion camion = new Camion("Iveco", "Turbostar", 1989, 20000);
        Bicicletta bicicletta = new Bicicletta("Lombardo", "Oltre XR4", 2024, 18);

        
        ArrayList<Veicolo> veicoli = new ArrayList<>();
        veicoli.add(automobile);
        veicoli.add(camion);
        veicoli.add(bicicletta);

        do{
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Visualizza veicoli");
            System.out.println("2. Aggiungi veicolo");
            System.out.println("3. Rimuovi veicolo");
            System.out.println("4. Sposta veicolo");
            System.out.println("5. Esci");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    for (Veicolo v : veicoli) {
                        System.out.println(v);
                    }
                    break;
                case 2:
                    // Aggiungi veicolo
                    break;
                case 3:
                    // Rimuovi veicolo
                    break;
                case 4:
                    // Sposta veicolo
                    break;
                case 5:
                    System.out.println("Uscita dal programma.");
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        } while (true);
    }
}