import java.util.Scanner;

public class ConsumiEnergetici {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] consumi = new int[10];
        int totale = 0;
        int max, min;
        double media;
        int sopraMedia = 0;

        // Inserimento valori
        for (int i = 0; i < consumi.length; i++) {
            System.out.print("Inserisci il consumo (kWh) dell'abitazione " + (i + 1) + ": ");
            consumi[i] = input.nextInt();
            totale = totale + consumi[i];
        }

        // Calcolo media
        media = (double) totale / consumi.length;

        // Inizializzazione max e min
        max = consumi[0];
        min = consumi[0];

        // Calcolo max, min e conteggio sopra la media
        for (int i = 0; i < consumi.length; i++) {

            if (consumi[i] > max) {
                max = consumi[i];
            }

            if (consumi[i] < min) {
                min = consumi[i];
            }

            if (consumi[i] > media) {
                sopraMedia++;
            }
        }

        // Output risultati
        System.out.println("\n--- RISULTATI ---");
        System.out.println("Consumo totale: " + totale + " kWh");
        System.out.println("Consumo medio: " + media + " kWh");
        System.out.println("Consumo massimo: " + max + " kWh");
        System.out.println("Consumo minimo: " + min + " kWh");
        System.out.println("Abitazioni con consumo superiore alla media: " + sopraMedia);

        input.close();
    }
}