package chiavi;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Quante camere ha l'albergo?");
        int n = sc.nextInt();
        sc.nextLine();

        PortaChiavi portaChiavi = new PortaChiavi(n);

        // Inserimento iniziale chiavi
        for (int i = 0; i < n; i++) {

            System.out.println("\nInserisci numero camera:");
            int numero = sc.nextInt();
            sc.nextLine();

            System.out.println("Inserisci tipo (singola/doppia/tripla):");
            String tipo = sc.nextLine();

            System.out.println("Inserisci nominativo cliente:");
            String nome = sc.nextLine();

            Chiave c = new Chiave(numero, tipo, nome);
            portaChiavi.inserisciChiave(c);
        }

        int scelta;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Restituisci chiave per numero camera");
            System.out.println("2 - Restituisci chiave per nominativo");
            System.out.println("3 - Visualizza stato portachiavi");
            System.out.println("4 - Elenco camere singole");
            System.out.println("0 - Esci");

            scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {

                case 1:
                    System.out.println("Inserisci numero camera:");
                    int num = sc.nextInt();
                    sc.nextLine();
                    Chiave k1 = portaChiavi.restituisciChiave(num);
                    if (k1 != null)
                        System.out.println("Consegnata: " + k1);
                    else
                        System.out.println("Chiave non trovata.");
                    break;

                case 2:
                    System.out.println("Inserisci nominativo:");
                    String nome = sc.nextLine();
                    Chiave k2 = portaChiavi.restituisciChiave(nome);
                    if (k2 != null)
                        System.out.println("Consegnata: " + k2);
                    else
                        System.out.println("Chiave non trovata.");
                    break;

                case 3:
                    System.out.println(portaChiavi);
                    break;

                case 4:
                    Chiave[] singole = portaChiavi.elencoSingole();
                    System.out.println("Camere singole:");
                    for (Chiave c : singole) {
                        System.out.println(c);
                    }
                    break;

                case 0:
                    System.out.println("Grazie e arrivederci!");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 0);

        sc.close();
    }
}