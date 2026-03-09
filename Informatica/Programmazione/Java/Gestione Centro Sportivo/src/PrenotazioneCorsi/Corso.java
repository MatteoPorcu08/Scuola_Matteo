package PrenotazioneCorsi;

public class Corso {
    String nome;
    String istruttore;
    int durata; // in minuti
    double costoMensile;
    int numeroIscritti;
    int capMaxIscritti; //numero massimo di partecipanti

    // Costruttore
    public Corso(String nome, String istruttore, int durata, double costoMensile,int capMaxIscritti) {
        this.nome = nome;
        this.istruttore = istruttore;
        this.durata = durata;
        this.costoMensile = costoMensile;
        this.numeroIscritti = 0; // inizialmente nessuno è iscritto
        this.capMaxIscritti = capMaxIscritti;
    }

    //Costruttore di copia
    public Corso(Corso corso) {
        this.nome = corso.nome;
        this.istruttore= corso.istruttore;
        this.durata= corso.durata;
        this.costoMensile= corso.costoMensile;
        this.numeroIscritti = corso.numeroIscritti;
        this.capMaxIscritti = corso.capMaxIscritti;
    }

    //Getter
    public String getNome() {
        return nome;
    }

    public String getIstruttore() {
        return istruttore;
    }

    public int getDurata() {
        return durata;
    }

    public double getCostoMensile() {
        return costoMensile;
    }

    public int getNumeroIscritti() {
        return numeroIscritti;
    }

    public int getCapMaxIscritti() {
        return capMaxIscritti;
    }

    //Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIstruttore(String istruttore) {
        this.istruttore = istruttore;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }
    public void setCostoMensile(double costoMensile) {
        this.costoMensile = costoMensile;
    }
    public void setNumeroIscritti(int numeroIscritti) {
        this.numeroIscritti = numeroIscritti;
    }
    public void setCapMaxIscritti(int capMaxIscritti) {
        this.capMaxIscritti = capMaxIscritti;
    }

    //Metodo ToString
    @Override
    public String toString() {
        return "Corso:"+ nome+ "\nIstruttore: "+ istruttore+"\nDurata: "+ durata+ " minuti"+"\nCosto Mensile: "+ costoMensile+ " euro"+"\nNumero Iscritti: "+ numeroIscritti+"\nCapacità Massima Iscritti: "+ capMaxIscritti;
    }

    //Metodo public void aggiungiIscritti(int numero)
    public void aggiungiIscritti(int numero){
        if (this.numeroIscritti + numero <= this.capMaxIscritti) {
            this.numeroIscritti += numero;
        } else {
            System.out.println("Non è possibile aggiungere " + numero + " iscritti. Capacità massima raggiunta.");
        }
    }

    //Metodo public void applicaScontoSePocoFrequentato(double percentuale)
    public void applicaScontoSePocoFrequentato(double percentuale) {
        if (this.numeroIscritti < 10) {
            this.costoMensile -= this.costoMensile * (percentuale / 100);
        }
    }

    //Metodo public boolean isCompleto()
    public boolean isCompleto() {
        if(numeroIscritti >= capMaxIscritti){
            return true;
        } else {
            return false;
        }
    }

    //Metodo public boolean aggiungiIscritti(int numero)
    public boolean aggiungiIscrittiBoolean(int numero){
        if (this.numeroIscritti + numero <= this.capMaxIscritti) {
            this.numeroIscritti += numero;
            return true;
        } else {
            System.out.println("Non è possibile aggiungere " + numero + " iscritti. Capacità massima raggiunta.");
            return false;
        }
    }

    //Metodo public boolean corsoAffollato()
    public boolean corsoAffollato() {
        if(this.numeroIscritti > 20){
            return true;
        } else {
            return false;
        }
    }
}