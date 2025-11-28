package Cucina;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        //Creazione Ingredienti
        System.out.println("--- Inserimento ingrediente 1 ---");
        Ingrediente ingr1 = creaIngrediente(s);

        System.out.println("\n--- Inserimento ingrediente 2 ---");
        Ingrediente ingr2 = creaIngrediente(s);

        System.out.println("\n--- Inserimento ingrediente 3 ---");
        Ingrediente ingr3 = creaIngrediente(s);

        //Creazione ricetta
        Ricetta r1 = new Ricetta("Pasta alla Carbonara", 20, "Media", 2, ingr1, ingr2, ingr3);

        boolean continua = true;
        while (continua) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Stampa ricetta");
            System.out.println("2. Scala dosi");
            System.out.println("3. Calcola calorie totali");
            System.out.println("4. Stima costo totale");
            System.out.println("5. Verifica se vegetariana");
            System.out.println("6. Sostituisci ingrediente");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            int scelta = s.nextInt();
            s.nextLine();

            switch (scelta) {
                case 1:
                    System.out.println("\n" + r1);
                    break;
                case 2:
                    System.out.print("Inserisci nuove porzioni: ");
                    int nuovePorzioni = s.nextInt();
                    s.nextLine();
                    r1.scalaDosi(nuovePorzioni);
                    System.out.println("Porzioni aggiornate!");
                    break;
                case 3:
                    System.out.println("Calorie totali: " + r1.calcolaCalorieTotali());
                    break;
                case 4:
                    System.out.println("Costo totale: " + r1.stimaCostoTotale() + "€");
                    break;
                case 5:
                    if (r1.isVegetariana()) {
                        System.out.println("La ricetta è vegetariana.");
                    } else {
                        System.out.println("La ricetta NON è vegetariana.");
                    }
                    break;
                case 6:
                    System.out.print("Numero ingrediente da sostituire (1-3): ");
                    int numIng = s.nextInt();
                    s.nextLine();
                    System.out.println("Inserisci il nuovo ingrediente:");
                    Ingrediente nuovoIng = creaIngrediente(s);
                    if (r1.sostituisciIngrediente(numIng, nuovoIng)) {
                        System.out.println("Ingrediente sostituito!");
                    } else {
                        System.out.println("Numero ingrediente non valido!");
                    }
                    break;
                case 0:
                    continua = false;
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        }

        s.close();
    }

    // Metodo per creare un ingrediente tramite Scanner
    private static Ingrediente creaIngrediente(Scanner s) {
        System.out.print("Nome: ");
        String nome = s.nextLine();
        System.out.print("Quantità: ");
        double quant = s.nextDouble();
        s.nextLine();
        System.out.print("Unità di misura: ");
        String unita = s.nextLine();
        System.out.print("Calorie per unità: ");
        double cal = s.nextDouble();
        System.out.print("Costo per unità: ");
        double costo = s.nextDouble();
        System.out.print("Vegetariano? (true/false): ");
        boolean veg = s.nextBoolean();
        s.nextLine();
        return new Ingrediente(nome, quant, unita, cal, costo, veg);
    }
}