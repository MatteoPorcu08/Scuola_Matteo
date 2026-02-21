package chiavi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		PortaChiavi P1= new PortaChiavi(10);
		
		Chiave C = new Chiave(12, "Singola", "Matteo");
		
		Scanner Accesso = new Scanner(System.in);
		
		System.out.println("Scrivi il numero della chiave della stanza");
		int numero;
		numero = Accesso.nextInt();
		Accesso.nextLine();
		
		System.out.println("Scrivi il tipo della chiave della stanza - Singola - Doppia - Tripla");
		String tipo;
		tipo = Accesso.nextLine();
		
		System.out.println("Scrivi il nominativo dela prenotazione:");
		String nominativo;
		nominativo = Accesso.nextLine();
		
		Chiave C2 = new Chiave(numero, tipo, nominativo);
		
		System.out.println("Scrivi il numero della chiave della stanza");
		numero = Accesso.nextInt();
		Accesso.nextLine();
		
		System.out.println("Scrivi il tipo della chiave della stanza - Singola - Doppia - Tripla");
		tipo = Accesso.nextLine();
		
		System.out.println("Scrivi il nominativo dela prenotazione:");
		nominativo = Accesso.nextLine();
		
		Chiave C3 = new Chiave(numero, tipo, nominativo);
		
		P1.aggiungiChiave(C3);
        P1.aggiungiChiave(C2);
        P1.aggiungiChiave(C);
		System.out.println(P1.toString());
		
	}
}