package chiavi;

/**
 * Classe di array Portachiavi
 * @author 4B Inf
 * @version 1.1
 */

public class PortaChiavi {
    
    private static final int NUM_MAX = 30;
    
    private Chiave elencoChiavi[];
    
    /**
     * Costruttore
     */
    public PortaChiavi() {
        elencoChiavi = new Chiave[NUM_MAX];
    }
    
    /**
     * Costruttore di copia
	 * @param altroPortaChiavi l'oggetto da cui copiare i dati
	 * 
     */
    public PortaChiavi(PortaChiavi altroPortaChiavi) {
        elencoChiavi = new Chiave[NUM_MAX];
        for(int i = 0; i < NUM_MAX; i++) {
            if(altroPortaChiavi.elencoChiavi[i] != null) {
                elencoChiavi[i] = new Chiave(
                    altroPortaChiavi.elencoChiavi[i].getNumeroCamera(),
                    altroPortaChiavi.elencoChiavi[i].getTipo(),
                    altroPortaChiavi.elencoChiavi[i].getCliente()
                );
            }
        }
    }
    
    public String setElencoChiavi(Chiave C1, int posizione) {
        if(posizione >= 0 && posizione < NUM_MAX && C1 != null && elencoChiavi[posizione] == null) {
            elencoChiavi[posizione] = new Chiave(
                C1.getNumeroCamera(),
                C1.getTipo(),
                C1.getCliente()
            );
            return "Chiave registrata con successo";
        }
        else {
            return "Errore nella registrazione";
        }
    }
    
    // Ricerca per numero
    public Chiave richiediChiaveNum(int nCamera) {
        if(nCamera >= 0) {
            for(int i = 0; i < NUM_MAX; i++) {
                if(elencoChiavi[i] != null && elencoChiavi[i].getNumeroCamera() == nCamera) {
                    return elencoChiavi[i];
                }
            }
        }
        return null;
    }
    
    // Ricerca per nominativo
    public Chiave richiediChiaveNome(String nome) {
        if(nome != null && !nome.isEmpty()) {
            for(int i = 0; i < NUM_MAX; i++) {
                if(elencoChiavi[i] != null && elencoChiavi[i].getCliente().equalsIgnoreCase(nome)) {
                    return elencoChiavi[i];
                }
            }
        }
        return null;
    }
    
    public String restituisciChiave(Chiave c) {
        if(c != null) {
            // Prima controlla se esiste già una chiave con gli stessi dati
            for(int i = 0; i < NUM_MAX; i++) {
                if(elencoChiavi[i] != null && 
                    elencoChiavi[i].getNumeroCamera() == c.getNumeroCamera() &&
                    elencoChiavi[i].getCliente().equals(c.getCliente())) {
                    return "Chiave già presente nel portachiavi";
                }
            }
            
            // Cerca una posizione libera
            for(int i = 0; i < NUM_MAX; i++) {
                if(elencoChiavi[i] == null) {
                    elencoChiavi[i] = new Chiave(
                        c.getNumeroCamera(),
                        c.getTipo(),
                        c.getCliente()
                    );
                    return "Chiave restituita con successo.";
                }
            }
            return "Tutte le posizioni sono occupate";
        } else {
            return "Chiave non valida";
        }
    }
    
    public String rimuoviChiave(int numeroCamera) {
        for(int i = 0; i < NUM_MAX; i++) {
            if(elencoChiavi[i] != null && elencoChiavi[i].getNumeroCamera() == numeroCamera) {
                elencoChiavi[i] = null;
                return "Chiave rimossa con successo";
            }
        }
        return "Chiave non trovata";
    }
    
	@Override
    public String toString() {
        String stringa = "=== PORTA CHIAVI ===\n";
        int count = 0;
        for (int i = 0; i < NUM_MAX; i++) {
            if (elencoChiavi[i] != null) {
                stringa += "Posizione " + i + ": " + elencoChiavi[i].toString() + "\n";
                count++;
            }
        }
        if(count == 0) {
            stringa += "Nessuna chiave presente\n";
        } else {
            stringa += "Totale chiavi: " + count;
        }
        return stringa;
    }
    
    // Metodo per ottenere il numero di chiavi presenti
    public int getNumeroChiavi() {
        int count = 0;
        for(int i = 0; i < NUM_MAX; i++) {
            if(elencoChiavi[i] != null) {
                count++;
            }
        }
        return count;
    }
    
    // Metodo per verificare se una posizione è libera
    public boolean isPosizioneLibera(int posizione) {
        if(posizione >= 0 && posizione < NUM_MAX) {
            return elencoChiavi[posizione] == null;
        }
        return false;
    }
}