package edu_asproni_fermi_esercizio1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione di un destinatario
        System.out.print("Inserisci il nome del destinatario: ");
        String nomeDestinatario = scanner.nextLine();
        System.out.print("Inserisci il codice del destinatario: ");
        String codiceDestinatario = scanner.nextLine();
        Destinatario destinatario = new Destinatario(nomeDestinatario, codiceDestinatario);

        // Creazione di un mitente
        Mitente mitente = new Mitente();

        // Invio di un messaggio al destinatario
        System.out.print("Inserisci il messaggio da inviare: ");
        String messaggio = scanner.nextLine();
        mitente.inviaMessaggio(destinatario, messaggio);
    }
}