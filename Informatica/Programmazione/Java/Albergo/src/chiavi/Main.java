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
		Scanner Accesso = new Scanner(System.in);
		String risposta;
		int numero;
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
		
		System.out.println(P1.toString());
		
		
	}

}