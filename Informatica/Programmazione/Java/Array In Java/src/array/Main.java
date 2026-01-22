package array;

public class Main {
    public static void main(String[] args) {
        // Creazione di un array di interi
        int[] numeri = { 10, 20, 30, 40, 50 };

        // Accesso agli elementi dell'array
        System.out.println("Primo elemento: " + numeri[0]);
        System.out.println("Secondo elemento: " + numeri[1]);

        // Modifica di un elemento dell'array
        numeri[2] = 35;
        System.out.println("Terzo elemento modificato: " + numeri[2]);

        // Iterazione attraverso l'array
        System.out.println("Tutti gli elementi dell'array:");
        for (int i = 0; i < numeri.length; i++) {
            System.out.println(numeri[i]);
        }
    }
}
