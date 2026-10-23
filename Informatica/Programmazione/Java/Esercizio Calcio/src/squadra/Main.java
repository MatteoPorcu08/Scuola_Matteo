package squadra;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creazione dell'ArrayList per la gestione della rosa
        ArrayList<MembroSquadra> rosa = new ArrayList<>();

        System.out.println("--- 1. INSERIMENTO DEI MEMBRI ---");
        // Creazione e inserimento diretto degli elementi come richiesto dal testo
        Attaccante a1 = new Attaccante("Lautaro", "Martinez", 10, true, 90, 80);
        Portiere p1 = new Portiere("Yann", "Sommer", 1, true, 95, 85);
        Allenatore all1 = new Allenatore("Simone", "Inzaghi", 0, 15);
        Attaccante a2 = new Attaccante("Marcus", "Thuram", 9, true, 85, 75);

        rosa.add(a1);
        rosa.add(p1);
        rosa.add(all1);
        rosa.add(a2);
        System.out.println("Membri inseriti nella rosa.\n");


        System.out.println("--- 2. VISUALIZZAZIONE DELLA ROSA INIZIALE ---");
        mostraRosa(rosa);


        System.out.println("--- 3. SPOSTAMENTO DI UN MEMBRO ---");
        
        int posizioneDaSpostare = 2;
        int nuovaPosizione = 0;
        
        System.out.println("Sposto " + rosa.get(posizioneDaSpostare).getNome() + " dalla posizione " + posizioneDaSpostare + " alla posizione " + nuovaPosizione);
        
        MembroSquadra membroSpostato = rosa.remove(posizioneDaSpostare);
        rosa.add(nuovaPosizione, membroSpostato);
        
        // Mostriamo la rosa aggiornata dopo lo spostamento
        mostraRosa(rosa);


        System.out.println("--- 4. RIMOZIONE DI UN MEMBRO ---");
        
        int posizioneDaRimuovere = 3;
        
        MembroSquadra membroRimosso = rosa.remove(posizioneDaRimuovere);
        System.out.println("Rimosso con successo: " + membroRimosso.getNome() + " " + membroRimosso.getCognome() + " (Ex posizione: " + posizioneDaRimuovere + ")\n");


        System.out.println("--- VISUALIZZAZIONE DELLA ROSA FINALE ---");
        mostraRosa(rosa);
    }

    private static void mostraRosa(ArrayList<MembroSquadra> lista) {
        if (lista.isEmpty()) {
            System.out.println("La rosa è vuota.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                MembroSquadra m = lista.get(i);
                String tipo = m.getClass().getSimpleName();
                System.out.println("[" + i + "] Tipo: " + tipo + " | " + m.getNome() + " " + m.getCognome() + " (Maglia: " + m.getNumeroMaglia() + ")");
            }
        }
        System.out.println();
    }
}