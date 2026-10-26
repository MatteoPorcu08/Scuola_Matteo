package squadra;

import java.util.ArrayList;

public class Rosa {

    private ArrayList<MembroSquadra> rosa = new ArrayList<>();

    //Metodo per aggiungere un metodo
    public void aggiungiMembro(MembroSquadra m) {
        rosa.add(m);
    }

    //Metodo per rimuovere il Membro
    MembroSquadra rimuoviMembro(int posizione){
        return rosa.remove(posizione);
    }

    //Metodo per spostare il membro della squadra
    public void spostaMembro(int posizioneAttuale, int nuovaPosizione){
        if (posizioneAttuale < 0 || posizioneAttuale >= rosa.size()
                || nuovaPosizione < 0 || nuovaPosizione >= rosa.size()) {
            throw new IndexOutOfBoundsException("Posizione non valida");
        }
        MembroSquadra membro = rosa.remove(posizioneAttuale);
        rosa.add(nuovaPosizione, membro);
    }

    //Metodo per visualizzare la rosa
    public void visualizzaRosa(){
        for (MembroSquadra membro : rosa) {
            System.out.println(membro);
        }
    }

    //Stampa la lista
    ArrayList<MembroSquadra>getMembri(){
        return rosa;
    }
}