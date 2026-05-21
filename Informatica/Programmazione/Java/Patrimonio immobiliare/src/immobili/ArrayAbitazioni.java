package immobili;
public class ArrayAbitazioni {
    private Abitazione abitazioni[];
    private int contatore;

    public ArrayAbitazioni() {
        this.abitazioni = new Abitazione[20];
        this.contatore = 0;
    }

    //Metodo per inserire un'abitazione nell'array
    public void inserisci(Abitazione abitazione) throws Exception {
        if (contatore >= abitazioni.length) {
            throw new Exception("Array pieno, impossibile inserire nuove abitazioni.");
        }
        abitazioni[contatore] = abitazione;
        contatore++;
    }

    //Metodo per eliminare un'abitazione dall'array
    public void elimina(String indirizzo) throws Exception {
        boolean trovato = false;
        for (int i = 0; i < contatore; i++) {
            if (abitazioni[i].getIndirizzo().equals(indirizzo)) {
                abitazioni[i] = abitazioni[contatore - 1]; // Sostituisce l'abitazione da eliminare con l'ultima abitazione
                abitazioni[contatore - 1] = null; // Rimuove l'ultima abitazione
                contatore--;
                trovato = true;
                break;
            }
        }
        if (!trovato) {
            throw new Exception("Abitazione non trovata.");
        }
    }

    //Metodo per cercare un'abitazione nell'array
    public Abitazione cercaAbitazione(String indirizzo) throws Exception {
        for (int i = 0; i < contatore; i++) {
            if (abitazioni[i].getIndirizzo().equals(indirizzo)) {
                return abitazioni[i];
            }
        }
        throw new Exception("Abitazione non trovata.");
    }

    @Override
    public String toString() {        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contatore; i++) {
            sb.append(abitazioni[i].toString()).append("\n");
        }
        return sb.toString();
    }
}