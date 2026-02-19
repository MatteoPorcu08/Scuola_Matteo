package chiavi;
public class PortaChiavi {

    private Chiave[] chiavi;
    private int dimensione; // numero effettivo di chiavi presenti
    
    /**
     * Costruttore - crea un portachiavi con una capienza massima
     * @param capacita il numero massimo di chiavi che può contenere
     */
    public PortaChiavi(int capacita) {
        chiavi = new Chiave[capacita];
        dimensione = 0;
    }
    
    /**
     * Aggiunge una chiave nella prima posizione libera
     * @param chiave la chiave da aggiungere
     * @return true se aggiunta con successo, false se il portachiavi è pieno
     */
    public boolean aggiungiChiave(Chiave chiave) {

        if (dimensione >= chiavi.length) {
            System.out.println("Portachiavi pieno! Non si possono aggiungere altre chiavi.");
            return false;
        }
        

        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] == null) {
                chiavi[i] = chiave;
                dimensione++;
                System.out.println("Chiave della camera " + chiave.getNumeroCamera() + " aggiunta in posizione " + i);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Rimuove una chiave cercandola per numero camera
     * @param numeroCamera il numero della camera
     * @return la chiave rimossa o null se non trovata
     */
    public Chiave rimuoviChiave(int numeroCamera) {
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null && chiavi[i].getNumeroCamera() == numeroCamera) {
                Chiave chiaveRimossa = chiavi[i];
                chiavi[i] = null;
                dimensione--;
                System.out.println("Chiave della camera " + numeroCamera + " rimossa dalla posizione " + i);
                return chiaveRimossa;
            }
        }
        
        System.out.println("Chiave della camera " + numeroCamera + " non trovata!");
        return null;
    }
    
    /**
     * Cerca una chiave per numero camera
     * @param numeroCamera il numero della camera da cercare
     * @return la chiave trovata o null se non esiste
     */
    public Chiave cercaPerNumero(int numeroCamera) {
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null && chiavi[i].getNumeroCamera() == numeroCamera) {
                return chiavi[i];
            }
        }
        return null;
    }
    
    /**
     * Cerca una chiave per nome cliente
     * @param cliente il nome del cliente da cercare
     * @return la chiave trovata o null se non esiste
     */
    public Chiave cercaPerCliente(String cliente) {
        for (int i = 0; i < chiavi.length; i++) {

            if (chiavi[i] != null) {
                String clienteChiave = chiavi[i].getCliente().toLowerCase();
                String clienteCercato = cliente.toLowerCase();
                
                if (clienteChiave.equals(clienteCercato)) {
                    return chiavi[i];
                }
            }
        }
        return null;
    }
    
    /**
     * Restituisce tutte le chiavi delle camere singole
     * @return array di chiavi singole
     */
    public Chiave[] getChiaviSingole() {

        int contatore = 0;
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null) {
                String tipo = chiavi[i].getTipo().toLowerCase();
                if (tipo.equals("singola")) {
                    contatore++;
                }
            }
        }
        

        Chiave[] chiaviSingole = new Chiave[contatore];
        int posizione = 0;
        

        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null) {
                String tipo = chiavi[i].getTipo().toLowerCase();
                if (tipo.equals("singola")) {
                    chiaviSingole[posizione] = chiavi[i];
                    posizione++;
                }
            }
        }
        
        return chiaviSingole;
    }
    
    /**
     * Metodo toString per rappresentare il portachiavi
     */
    @Override
    public String toString() {
        String risultato = "PORTA CHIAVI - Capienza: " + chiavi.length + ", Occupati: " + dimensione + "\n";
        
        for (int i = 0; i < chiavi.length; i++) {
            risultato += "Posizione " + i + ": ";
            if (chiavi[i] != null) {
                risultato += chiavi[i].toString();
            } else {
                risultato += "libera";
            }
            risultato += "\n";
        }
        
        return risultato;
    }
}