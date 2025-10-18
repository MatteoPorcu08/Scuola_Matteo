package elenco;

public class Persona {

    // ATTRIBUTI: nome, cognome, età, altezza
    private String nome;
    private String cognome;
    private int eta;
    private float  altezza;

    // METODI



    // COSTRUTTORE
    public Persona (String nome, String cognome, int eta, float altezza) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.altezza = altezza;

    }
    /* SETTER:Metodi che assegnano i valori ai singoli parametri
        Possono essere pubblici (attributi dinamici) o privato (attributi statici)*/

        private void setNome (String nome) {
            this.nome = nome;
        }
        private void setCognome (String cognome) {
            this.cognome = cognome;
        }
        public void setEta (int eta) {
            this.eta = eta;
        }
        public void setAltezza (float altezza) {
            this.altezza = altezza;
        }
    
    /* GETTER: Metodi che restituiscono i valori dei singoli parametri
        Sono sempre pubblici perchè devono essere utilizati anche all'esterno della classe */

        public String getNome () {
            return this.nome;
        }
        public String getCognome () {
            return this.cognome;
        }
        public int getEta () {
            return this.eta;
        }
        public float getAltezza () {
            return this.altezza;
        }


}
