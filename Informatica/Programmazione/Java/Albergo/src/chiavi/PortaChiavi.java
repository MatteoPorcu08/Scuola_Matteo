package chiavi;

public class PortaChiavi {

    private Chiave[] chiavi;
    private int dimensione;

    public PortaChiavi(int capacita) {
        chiavi = new Chiave[capacita];
        dimensione = 0;
    }

    // Aggiunge una chiave al portachiavi se c'è spazio disponibile
    public boolean aggiungiChiave(Chiave chiave) {
        if (dimensione >= chiavi.length) {
            System.out.println("Portachiavi pieno!");
            return false;
        }

        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] == null) {
                chiavi[i] = chiave;
                dimensione++;
                System.out.println("Chiave camera " + chiave.getNumeroCamera() + " aggiunta");
                return true;
            }
        }
        return false;
    }

    // Rimuove una chiave dal portachiavi in base al numero della camera
    public Chiave rimuoviChiave(int numeroCamera) {
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null && chiavi[i].getNumeroCamera() == numeroCamera) {
                Chiave chiaveRimossa = chiavi[i];
                chiavi[i] = null;
                dimensione--;
                System.out.println("Chiave camera " + numeroCamera + " rimossa");
                return chiaveRimossa;
            }
        }
        System.out.println("Chiave non trovata!");
        return null;
    }

    // Cerca una chiave in base al numero della camera o al nome del cliente
    public Chiave cercaPerNumero(int numeroCamera) {
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null && chiavi[i].getNumeroCamera() == numeroCamera) {
                return chiavi[i];
            }
        }
        return null;
    }

    // Cerca una chiave in base al nome del cliente
    public Chiave cercaPerCliente(String cliente) {
        for (int i = 0; i < chiavi.length; i++) {
            if (chiavi[i] != null && chiavi[i].getCliente().equals(cliente)) {
                return chiavi[i];
            }
        }
        return null;
    }

    // Metodo toString
    public String toString() {
        String risultato = "---PORTA CHIAVI---\n Capienza: " + chiavi.length + ", Occupati: " + dimensione + "\n";
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