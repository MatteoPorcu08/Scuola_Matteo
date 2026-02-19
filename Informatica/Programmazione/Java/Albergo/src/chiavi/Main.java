package chiavi;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DI GESTIONE CHIAVI ALBERGO ===\n");
        
        // Creo i portachiavi
        System.out.print("Inserisci la capienza massima del portachiavi: ");
        int capienza = input.nextInt();
        input.nextLine(); // Consuma il newline
        
        PortaChiavi portachiavi = new PortaChiavi(capienza);
        
        // Chiedo quanti clienti vogliono lasciare la chiave
        System.out.print("\nQuanti clienti vogliono lasciare la chiave? ");
        int numChiavi = input.nextInt();
        input.nextLine();
        
        // Inserisco le chiavi dei clienti
        for (int i = 0; i < numChiavi; i++) {
            System.out.println("\n--- Inserimento chiave " + (i + 1) + " ---");
            
            System.out.print("Numero camera: ");
            int numero = input.nextInt();
            input.nextLine();
            
            System.out.print("Tipo camera (singola/doppia/tripla): ");
            String tipo = input.nextLine();
            
            System.out.print("Nome cliente: ");
            String cliente = input.nextLine();
            
            // Creo la chiave e la aggiungo
            Chiave chiave = new Chiave(numero, tipo, cliente);
            portachiavi.aggiungiChiave(chiave);
        }
        
        // Mostro lo stato iniziale
        System.out.println("\n" + portachiavi.toString());
        
        boolean continua = true;
        
        while (continua) {
            System.out.println("\n=== MENU OPERAZIONI ===");
            System.out.println("1 - Cerca chiave per numero camera");
            System.out.println("2 - Cerca chiave per nome cliente");
            System.out.println("3 - Rimuovi chiave (cliente esce)");
            System.out.println("4 - Aggiungi nuova chiave (cliente entra)");
            System.out.println("5 - Visualizza tutte le chiavi singole");
            System.out.println("6 - Visualizza stato portachiavi");
            System.out.println("0 - Esci");
            System.out.print("Scegli operazione: ");
            
            int scelta = input.nextInt();
            input.nextLine();
            
            switch (scelta) {
                case 1:
                    // Ricerca per numero camera
                    System.out.print("Inserisci numero camera da cercare: ");
                    int numCerca = input.nextInt();
                    input.nextLine();
                    
                    Chiave trovataNum = portachiavi.cercaPerNumero(numCerca);
                    if (trovataNum != null) {
                        System.out.println("Chiave trovata: " + trovataNum);
                    } else {
                        System.out.println("Nessuna chiave trovata per la camera " + numCerca);
                    }
                    break;
                    
                case 2:
                    // Ricerca per nome cliente
                    System.out.print("Inserisci nome cliente da cercare: ");
                    String clienteCerca = input.nextLine();
                    
                    Chiave trovataCliente = portachiavi.cercaPerCliente(clienteCerca);
                    if (trovataCliente != null) {
                        System.out.println("Chiave trovata: " + trovataCliente);
                    } else {
                        System.out.println("Nessuna chiave trovata per il cliente " + clienteCerca);
                    }
                    break;
                    
                case 3:
                    // Rimozione chiave (cliente esce)
                    System.out.print("Inserisci numero camera da rimuovere: ");
                    int numRimuovi = input.nextInt();
                    input.nextLine();
                    
                    portachiavi.rimuoviChiave(numRimuovi);
                    break;
                    
                case 4:
                    // Aggiunta nuova chiave (cliente entra)
                    System.out.println("\n--- Inserimento nuova chiave ---");
                    System.out.print("Numero camera: ");
                    int nuovoNum = input.nextInt();
                    input.nextLine();
                    
                    System.out.print("Tipo camera (singola/doppia/tripla): ");
                    String nuovoTipo = input.nextLine();
                    
                    System.out.print("Nome cliente: ");
                    String nuovoCliente = input.nextLine();
                    
                    Chiave nuovaChiave = new Chiave(nuovoNum, nuovoTipo, nuovoCliente);
                    portachiavi.aggiungiChiave(nuovaChiave);
                    break;
                    
                case 5:
                    // Visualizza chiavi singole
                    Chiave[] singole = portachiavi.getChiaviSingole();
                    if (singole.length > 0) {
                        System.out.println("\nCAMERE SINGOLE PRESENTI:");
                        for (int i = 0; i < singole.length; i++) {
                            System.out.println((i + 1) + ". " + singole[i]);
                        }
                    } else {
                        System.out.println("Nessuna camera singola presente.");
                    }
                    break;
                    
                case 6:
                    // Visualizza stato portachiavi
                    System.out.println("\n" + portachiavi.toString());
                    break;
                    
                case 0:
                    // Esci
                    System.out.println("Grazie per aver usato il sistema. Arrivederci!");
                    continua = false;
                    break;
                    
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        input.close();
    }
}