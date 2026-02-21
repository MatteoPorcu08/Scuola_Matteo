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
        Scanner input = new Scanner(System.in);

        System.out.println("Quante chiavi vuoi inserire nel PortaChiavi?");
        int numeroChiavi = input.nextInt();
        input.nextLine();

        Chiave[] chiaviInserite = new Chiave[numeroChiavi];

        for (int i = 0; i < numeroChiavi; i++) {
            System.out.println("\n--- Inserimento chiave " + (i+1) + " ---");
            
            System.out.print("Inserisci il numero della chiave: ");
            int numero = input.nextInt();
            input.nextLine();

            System.out.print("Inserisci il tipo della chiave (Singola/Doppia/Tripla): ");
            String tipo = input.nextLine();

            System.out.print("Inserisci il nominativo della prenotazione: ");
            String nominativo = input.nextLine();
            
            chiaviInserite[i] = new Chiave(numero, tipo, nominativo);
        }

        PortaChiavi mioPortaChiavi = new PortaChiavi();

        for (int i = 0; i < numeroChiavi; i++) {
            mioPortaChiavi.elencoChiavi[i] = chiaviInserite[i];
        }

        System.out.println("\nPortaChiavi creato con successo!");
        System.out.println(mioPortaChiavi.toString());

        int scelta;
        String risposta;

        do {
            System.out.println("\n--- MENU OPERAZIONI ---");
            System.out.println("1 - Ricerca chiave da posizione");
            System.out.println("2 - Ricerca chiave da nominativo");
            System.out.println("3 - Rimuovi chiave da posizione");
            System.out.println("4 - Rimuovi chiave da nominativo");
            System.out.println("5 - Conta chiavi di un determinato tipo");
            System.out.println("0 - Esci");
            System.out.print("Scegli operazione: ");

            scelta = input.nextInt();
            input.nextLine();

            switch(scelta) {
                case 1:
                    System.out.print("Inserisci posizione da cercare: ");
                    int pos = input.nextInt();
                    input.nextLine();

                    if (pos >= 0 && pos < mioPortaChiavi.elencoChiavi.length && mioPortaChiavi.elencoChiavi[pos] != null) {
                        System.out.println("Chiave trovata: " + mioPortaChiavi.elencoChiavi[pos].toString());
                    } else {
                        System.out.println("Posizione non valida o vuota");
                    }
                    break;

                case 2:
                    System.out.print("Inserisci nominativo da cercare: ");
                    String nominativoRicerca = input.nextLine();

                    boolean trovata = false;
                    for (int i = 0; i < mioPortaChiavi.elencoChiavi.length; i++) {
                        if (mioPortaChiavi.elencoChiavi[i] != null && mioPortaChiavi.elencoChiavi[i].getCliente().equalsIgnoreCase(nominativoRicerca)) {
                            System.out.println("Chiave trovata alla posizione " + i + ": " + mioPortaChiavi.elencoChiavi[i].toString());
                            trovata = true;
                        }
                    }
                    if (!trovata) {
                        System.out.println("Nessuna chiave trovata con questo nominativo");
                    }
                    break;

                case 3:
                    System.out.print("Inserisci posizione da rimuovere: ");
                    int posRimozione = input.nextInt();
                    input.nextLine();

                    if (posRimozione >= 0 && posRimozione < mioPortaChiavi.elencoChiavi.length) {
                        if (mioPortaChiavi.elencoChiavi[posRimozione] != null) {
                            mioPortaChiavi.elencoChiavi[posRimozione] = null;
                            System.out.println("Chiave rimossa con successo");
                        } else {
                            System.out.println("Posizione già vuota");
                        }
                    } else {
                        System.out.println("Posizione non valida");
                    }
                    break;

                case 4:
                    System.out.print("Inserisci nominativo della chiave da rimuovere: ");
                    String nominativoRimozione = input.nextLine();

                    boolean rimossa = false;
                    for (int i = 0; i < mioPortaChiavi.elencoChiavi.length; i++) {
                        if (mioPortaChiavi.elencoChiavi[i] != null &&mioPortaChiavi.elencoChiavi[i].getCliente().equalsIgnoreCase(nominativoRimozione)) {
                            mioPortaChiavi.elencoChiavi[i] = null;
                            System.out.println("Chiave con nominativo '" + nominativoRimozione +"' rimossa dalla posizione " + i);
                            rimossa = true;
                        }
                    }
                    if (!rimossa) {
                        System.out.println("Nessuna chiave trovata con questo nominativo");
                    }
                    break;

                case 5:
                    System.out.print("Inserisci il tipo di chiave da contare (Singola/Doppia/Tripla): ");
                    String tipoRicerca = input.nextLine();

                    int contatore = 0;
                    for (int i = 0; i < mioPortaChiavi.elencoChiavi.length; i++) {
                        if (mioPortaChiavi.elencoChiavi[i] != null &&mioPortaChiavi.elencoChiavi[i].getTipo().equalsIgnoreCase(tipoRicerca)) {
                            contatore++;
                        }
                    }
                    System.out.println("Ci sono " + contatore + " chiavi di tipo " + tipoRicerca);
                    break;

                case 0:
                    System.out.println("Grazie per aver utilizzato il programma. Arrivederci!");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

            if (scelta != 0) {
                System.out.print("\nVuoi effettuare un'altra operazione? (s/n): ");
                risposta = input.nextLine();
                if (risposta.equalsIgnoreCase("n")) {
                    scelta = 0;
                    System.out.println("Grazie per aver utilizzato il programma. Arrivederci!");
                }
            }

        } while (scelta != 0);

        input.close();
    }
}