package chiavi;
public class PortaChiavi {

    private Chiave[] chiavi;
    private int dimensione;

    public PortaChiavi(int dimensione) {
        this.dimensione = dimensione;
        chiavi = new Chiave[dimensione];
    }

    // Inserisce nella prima posizione libera
    public boolean inserisciChiave(Chiave c) {
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] == null) {
                chiavi[i] = c;
                return true;
            }
        }
        return false; // nessuna posizione libera
    }

    // Richiesta chiave per numero camera
    public Chiave restituisciChiave(int numeroCamera) {
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null && chiavi[i].getNumeroCamera() == numeroCamera) {
                Chiave temp = chiavi[i];
                chiavi[i] = null;
                return temp;
            }
        }
        return null;
    }

    // Richiesta chiave per nominativo
    public Chiave restituisciChiave(String nominativo) {
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null &&
                chiavi[i].getNominativo().equalsIgnoreCase(nominativo)) {

                Chiave temp = chiavi[i];
                chiavi[i] = null;
                return temp;
            }
        }
        return null;
    }

    // Metodo opzionale: elenco camere singole
    public Chiave[] elencoSingole() {
        int count = 0;

        for (Chiave c : chiavi) {
            if (c != null && c.getTipo().equalsIgnoreCase("singola")) {
                count++;
            }
        }

        Chiave[] singole = new Chiave[count];
        int index = 0;

        for (Chiave c : chiavi) {
            if (c != null && c.getTipo().equalsIgnoreCase("singola")) {
                singole[index++] = c;
            }
        }

        return singole;
    }

    @Override
    public String toString() {
        String risultato = "STATO PORTACHIAVI:\n";
        for (int i = 0; i < chiavi.length; i++) {
            risultato += "Posizione " + i + ": ";
            if (chiavi[i] != null)
                risultato += chiavi[i].toString();
            else
                risultato += "Vuota";
            risultato += "\n";
        }
        return risultato;
    }
}