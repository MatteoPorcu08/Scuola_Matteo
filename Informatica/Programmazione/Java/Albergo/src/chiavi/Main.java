package chiavi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creazione del porta chiavi
        PortaChiavi P1 = new PortaChiavi();
        
        Chiave C = new Chiave(12, "Singola", "Matteo");
        
        Scanner Accesso = new Scanner(System.in);
        
        System.out.println("=== INSERIMENTO PRIMA CHIAVE ===");
        System.out.println("Scrivi il numero della chiave della stanza:");
        int numero;
        numero = Accesso.nextInt();
        Accesso.nextLine();
        
        System.out.println("Scrivi il tipo della chiave della stanza (Singola/Doppia/Tripla):");
        String tipo;
        tipo = Accesso.nextLine();
        
        System.out.println("Scrivi il nominativo della prenotazione:");
        String nominativo;
        nominativo = Accesso.nextLine();
        
        Chiave C2 = new Chiave(numero, tipo, nominativo);
        
        System.out.println("\n=== INSERIMENTO SECONDA CHIAVE ===");
        System.out.println("Scrivi il numero della chiave della stanza:");
        numero = Accesso.nextInt();
        Accesso.nextLine();
        
        System.out.println("Scrivi il tipo della chiave della stanza (Singola/Doppia/Tripla):");
        tipo = Accesso.nextLine();
        
        System.out.println("Scrivi il nominativo della prenotazione:");
        nominativo = Accesso.nextLine();
        
        Chiave C3 = new Chiave(numero, tipo, nominativo);
        
        // CORREZIONE 2: Il metodo si chiama "setElencoChiavi" non "aggiungiChiave"
        // Dobbiamo specificare anche la posizione
        System.out.println("\n=== AGGIUNTA CHIAVI ===");
        
        // Aggiungiamo le chiavi in posizioni diverse
        System.out.println(P1.setElencoChiavi(C, 0));  // Prima chiave in posizione 0
        System.out.println(P1.setElencoChiavi(C2, 1)); // Seconda chiave in posizione 1
        System.out.println(P1.setElencoChiavi(C3, 2)); // Terza chiave in posizione 2
        
        System.out.println("\n=== CONTENUTO PORTA CHIAVI ===");
        System.out.println(P1.toString());
        
        // Test dei metodi di ricerca
        System.out.println("\n=== TEST RICERCHE ===");
        
        // Ricerca per numero
        System.out.println("Ricerca chiave per numero 12:");
        Chiave trovataPerNumero = P1.richiediChiaveNum(12);
        if(trovataPerNumero != null) {
            System.out.println("Trovata: " + trovataPerNumero);
        } else {
            System.out.println("Nessuna chiave trovata con numero 12");
        }
        
        // Ricerca per nome
        System.out.println("\nRicerca chiave per nome 'Matteo':");
        Chiave trovataPerNome = P1.richiediChiaveNome("Matteo");
        if(trovataPerNome != null) {
            System.out.println("Trovata: " + trovataPerNome);
        } else {
            System.out.println("Nessuna chiave trovata per Matteo");
        }
        
        // Test rimozione
        System.out.println("\n=== TEST RIMOZIONE ===");
        System.out.println(P1.rimuoviChiave(12));
        System.out.println("Dopo rimozione:");
        System.out.println(P1.toString());
        
        // Statistiche
        System.out.println("\n=== STATISTICHE ===");
        System.out.println("Numero totale chiavi: " + P1.getNumeroChiavi());
        
        Accesso.close();
    }
}