package PrenotazioneCorsi;

public class CentroSportivo {
    Corso[] corsi = new Corso[10];
    int numeroCorsi = 0;

    //Costruttore
    public CentroSportivo() {
        for (int i = 0; i < corsi.length; i++) {
            corsi[i] = null;
            numeroCorsi = 0;
        }
    }

    //Costruttore di copia
    public CentroSportivo(CentroSportivo centro) {
        this.corsi = new Corso[10];
        for (int i = 0; i < centro.corsi.length; i++) {
            if (centro.corsi[i] != null) {
                this.corsi[i] = new Corso(centro.corsi[i]);
            } else {
                this.corsi[i] = null;
            }
        }
        this.numeroCorsi = centro.numeroCorsi;
    }
    
    //Metodo public boolean aggiungiCorso(Corso c) Inserisce il corso nella prima posizione libera. Ritorna true se inserito, false se l'array è pieno.
    public boolean aggiungiCorso(Corso c) {
        if (numeroCorsi < corsi.length) {
            corsi[numeroCorsi] = new Corso(c);
            numeroCorsi++;
            return true;
        } else {
            System.out.println("Non è possibile aggiungere il corso " + c.getNome() + ". Numero massimo di corsi raggiunto.");
            return false;
        }
    }

    //Metodo public boolean rimuoviCorso(int posizione)
    public boolean rimuoviCorso(int posizione) {
        if (posizione >= 0 && posizione < numeroCorsi && corsi[posizione] != null) {
            for (int i = posizione; i < numeroCorsi - 1; i++) {
                corsi[i] = corsi[i + 1];
            }
            corsi[numeroCorsi - 1] = null;
            numeroCorsi--;
            return true;
        } else {
            System.out.println("Posizione " + posizione + " non valida. Impossibile rimuovere il corso.");
            return false;
        }
    }

    //Metodo public boolean rimuoviPerNome(String nome)
    public boolean rimuoviPerNome(String nome) {
        for (int i = 0; i < numeroCorsi; i++) {
            if (corsi[i].getNome().equals(nome)) {
                return rimuoviCorso(i);
            }
        }
        System.out.println("Corso con nome " + nome + " non trovato. Impossibile rimuovere.");
        return false;
    }



}