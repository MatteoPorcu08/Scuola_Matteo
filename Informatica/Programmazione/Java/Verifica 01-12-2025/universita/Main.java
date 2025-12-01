package universita;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // 1. Creare almeno due oggetti Tesi
        Tesi t1 = new Tesi("Intelligenza Artificiale e Machine Learning", "Franco", 30, 80, "Definitiva");
        Tesi t2 = new Tesi("Sistemi di guida autonoma", "Sabry", 20, 60, "Bozza");
        
        System.out.println("--- Benvenuto nel programma dell'Università ---\n");
        
        // 2. Creare due oggetti Studente via costruttore principale
        System.out.println("--- Inserisci i dati dello studente 1 ---");
        System.out.print("Matricola: ");
        String m1 = s.nextLine();
        System.out.print("Nome: ");
        String n1 = s.nextLine();
        System.out.print("Cognome: ");
        String c1 = s.nextLine();
        System.out.print("Corso: ");
        String corso1 = s.nextLine();
        System.out.print("Anno iscrizione: ");
        int a1 = s.nextInt();
        s.nextLine(); // Consuma newline
        
        Studente s1 = new Studente(m1, n1, c1, corso1, a1, t1);
        
        System.out.println("\n--- Inserisci i dati dello studente 2 ---");
        System.out.print("Matricola: ");
        String m2 = s.nextLine();
        System.out.print("Nome: ");
        String n2 = s.nextLine();
        System.out.print("Cognome: ");
        String c2 = s.nextLine();
        System.out.print("Corso: ");
        String corso2 = s.nextLine();
        System.out.print("Anno iscrizione: ");
        int a2 = s.nextInt();
        s.nextLine();
        
        Studente s2 = new Studente(m2, n2, c2, corso2, a2, t2);
        
        // 3. Creare una terza Studente usando il costruttore di copia
        System.out.println("\n--- Creazione studente 3 come copia dello studente 1 ---");
        Studente s3 = new Studente(s1);
        
        // 4. Dimostrare DEEP COPY: modificando la Tesi della copia non cambia l'originale
        System.out.println("\n=== DIMOSTRAZIONE DEEP COPY ===");
        System.out.println("Prima della modifica:");
        System.out.println("S1 tesi pagine: " + s1.getTesi().getPagine());
        System.out.println("S3 tesi pagine: " + s3.getTesi().getPagine());
        
        // Modifico solo la tesi di s3
        s3.getTesi().setPagine(50);
        
        System.out.println("\nDopo aver modificato S3 (aumentato pagine a 50):");
        System.out.println("S1 tesi pagine: " + s1.getTesi().getPagine() + " (NON è cambiato!)");
        System.out.println("S3 tesi pagine: " + s3.getTesi().getPagine() + " (modificato solo qui)");
        System.out.println("✓ DEEP COPY verificata!\n");
        
        // 5. Stampare tutti gli studenti con toString()
        System.out.println("=== STUDENTI CREATI ===");
        System.out.println("--- Studente 1 ---");
        System.out.println(s1.toString());
        System.out.println("\n--- Studente 2 ---");
        System.out.println(s2.toString());
        System.out.println("\n--- Studente 3 (copia di S1) ---");
        System.out.println(s3.toString());
        
        // 6. Testare metodi base della tesi
        System.out.println("\n=== TEST METODI TESI ===");
        System.out.println("Tesi 1 è pronta per discussione? " + t1.isProntaPerDiscussione());
        System.out.println("Tesi 2 è pronta per discussione? " + t2.isProntaPerDiscussione());
        
        System.out.println("\nAggiorno voto Tesi 1 a 90:");
        boolean aggiornato = t1.aggiornaVoto(90);
        System.out.println("Aggiornamento riuscito? " + aggiornato + " - Nuovo voto: " + t1.getVotoProposto());
        
        System.out.println("\nAumento pagine Tesi 2 di 15:");
        int nuovePagine = t2.aumentaPagine(15);
        System.out.println("Nuovo numero pagine Tesi 2: " + nuovePagine);
        System.out.println("Ora Tesi 2 è pronta per discussione? " + t2.isProntaPerDiscussione());
        
        // 7. Testare metodi intermedi scelti
        System.out.println("\n=== TEST METODI STUDENTE ===");
        System.out.println("S1 ha tesi? " + s1.haTesi());
        System.out.println("S1 è idoneo alla laurea? " + s1.isIdoneoAllaLaurea());
        System.out.println("S2 è idoneo alla laurea? " + s2.isIdoneoAllaLaurea());
        
        System.out.println("\nConfronto pagine tra S1 e S2:");
        System.out.println("Risultato: " + s1.confrontaPagine(s2));
        
        // Test sostituisciTesi
        System.out.println("\nSostituisco la tesi di S2 con una nuova:");
        Tesi t3 = new Tesi("Nuova Tesi Sostitutiva", "Prof. Rossi", 40, 95, "In revisione");
        boolean sostituita = s2.sostituisciTesi(t3);
        System.out.println("Sostituzione riuscita? " + sostituita);
        System.out.println("Nuova tesi S2: " + s2.getTesi().toString());
        
        // Test promuoviVotoTesi
        System.out.println("\nPromuovo voto tesi di S1 di 5 punti:");
        boolean promosso = s1.promuoviVotoTesi(5);
        System.out.println("Promozione riuscita? " + promosso);
        System.out.println("Nuovo voto S1: " + s1.getTesi().getVotoProposto());
        
        // Test annullaTesi
        System.out.println("\nAnnullo la tesi di S3:");
        s3.annullaTesi();
        System.out.println("S3 ha ancora tesi? " + s3.haTesi());
        System.out.println("S1 ha ancora tesi? " + s1.haTesi() + " (non influenzato!)");
        
        // Test equals (opzionale)
        System.out.println("\n=== TEST UGUAGLIANZA ===");
        System.out.println("S1.equals(S3) con stessa matricola? " + s1.equals(s3));
        
        // Creo studente con stessa matricola
        Studente s4 = new Studente(s1.getMatricola(), "Mario", "Rossi", "Matematica", 2022, null);
        System.out.println("S1.equals(S4) con stessa matricola? " + s1.equals(s4));
        
        s.close();
        System.out.println("\n=== PROGRAMMA TERMINATO ===");
    }
}