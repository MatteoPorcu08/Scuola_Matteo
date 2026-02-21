package chiavi;

import java.util.Scanner;

/**
 * Classe Main per testare le funzionalità del PortaChiavi e della Chiave
 * @autor 4BINF
 * Data: 2024-06-10
 * @version  1.0
 */

public class Main {

	public static void main(String[] args) {

		PortaChiavi P1= new PortaChiavi();
		Chiave C;
		Scanner Accesso = new Scanner(System.in);
		String risposta;
		int numero, scelta;
		String tipo;
		String nominativo;
		int i=0;
		
		do {
		
			System.out.println("Scrivi il numero della chiave della stanza");
			numero = Accesso.nextInt();
			Accesso.nextLine();
			System.out.println("Scrivi il tipo della chiave della stanza - Singola - Doppia - Tripla");
			tipo = Accesso.nextLine();
			System.out.println("Scrivi il nominativo dela prenotazione:");
			nominativo = Accesso.nextLine();
		
			
			P1.elencoChiavi[i] = new Chiave(numero, tipo, nominativo);
			i++;
			System.out.println("Vuoi inserire un'altra chiave?");
			risposta=Accesso.nextLine();
		} while (risposta.equalsIgnoreCase("s")||risposta.equalsIgnoreCase("y")||risposta.equalsIgnoreCase("si")||risposta.equalsIgnoreCase("yes"));
		
			
		do {
			System.out.println("\nScegli tra le seguenti operazioni:");
			System.out.println("1) Lascia la chiave");
			System.out.println("2) Prendere la chiave inserendo il numero");
			System.out.println("3) Prendere la chiave inserendo il nome");
			System.out.println("4) Stampa l'elenco delle chiavi presenti nel portachiavi");
			System.out.println("0) Uscita");
			System.out.print("Scelta: ");
			
			scelta=Accesso.nextInt();
			Accesso.nextLine();
			
			switch (scelta) {
				case 1:
					System.out.println("Scrivi il numero della stanza: ");
					numero=Accesso.nextInt();
					Accesso.nextLine();
					C = new Chiave(P1.richiediChiaveNum(numero));
					System.out.println(P1.restituisciChiave(C));
					break;
					
				case 2:
					System.out.println("Inserisci il numero della chiave da prendere: ");
					numero = Accesso.nextInt();
					Accesso.nextLine();
					C = P1.prendiChiaveNum(numero);
					if (C != null) {
						System.out.println("Hai preso la chiave: " + C.toString());
					} else {
						System.out.println("Nessuna chiave trovata con numero " + numero);
					}
					break;
					
				case 3:
					System.out.println("Inserisci il nominativo della prenotazione: ");
					nominativo = Accesso.nextLine();
					C = P1.prendiChiaveNome(nominativo);
					if (C != null) {
						System.out.println("Hai preso la chiave: " + C.toString());
					} else {
						System.out.println("Nessuna chiave trovata con nominativo " + nominativo);
					}
					break;
					
				case 4:
					System.out.println(P1.toString());
					break;
					
				case 0:
					System.out.println("Grazie per aver usato il nostro programma!");
					break;
					
				default:
					System.out.println("Opzione non valida, riprova");
					break;
			}
		
		} while (scelta != 0);
		
		Accesso.close();
	}
}