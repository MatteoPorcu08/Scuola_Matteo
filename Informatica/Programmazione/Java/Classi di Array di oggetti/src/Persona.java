/**
* @author classe 4B INF
* @version 1.2
*/
public class Persona {
   //ATTRIBUTI: nome, cognome, età, altezza

    private String nome;
    private String cognome;
    private int eta;
    private float altezza;

    //METODI

    /**COSTRUTTORE
    *
    * @param nome nome della persona
    * @param cognome cognome della persone
    * @param eta età della persona
    * @param altezza
    */


    public Persona(String nome, String cognome, int eta, float altezza) {
        this.nome=nome;
       this.cognome=cognome;
       this.eta=eta;
       this.altezza=altezza;
   }
   
   //costrutore di copia
   public Persona(Persona P) {
       this.nome=P.getNome();
       this.cognome= P.getCognome();
       this.eta= P.getEta();
       this.altezza= P.getAltezza();
   }
   
   /*SETTER: metodi che assegnano i valori ai singoli parametri
   Possono essere pubblici (attributi dinamici) o privato (attributi statici)*/
   
   public void setNome(String nome) {
       this.nome=nome;
   }
   
   private void setCognome(String cognome) {
       this.cognome=cognome;
   }
   
   public void setEta(int eta) {
       this.eta=eta;
   }
   
   public void setAltezza(float altezza) {
       this.altezza=altezza;
   }
   
   //GETTER: metodi che servono per visualizzare i valori di ciascun attributo
   //sono sempre pubblici perchè devono esere utilizzati anche all'esterno della classe
   
   /**
    * Metodo getNome
    * @return il nome dell'oggetto
    */
   
   public String getNome() {
       return this.nome;
   }
   
   public String getCognome() {
       return this.cognome;
   }
   
   public int getEta() {
       return this.eta;
   }
   
   public float getAltezza() {
       return this.altezza;
   }
   
   //metodo toString: serve per restituire i valori degli attributi
   public String toString() {
       return "Nome = "+this.nome+"\nCognome = "+this.cognome+"\nEtà = "+this.eta+"\nAltezza = "+this.altezza;
   }
   
   //metodo confronta età
   /**
    * Metodo confrontaEta
    * @param altraPersona è una persona di cui confrontiamo l'età
    * @return commento relativo a chi è la persona più grande
    */
   public String confrontaEta(Persona altraPersona) {
       if(this.eta>altraPersona.getEta()) {
           return this.nome+ " è più grande di " +altraPersona.getNome();        
       }else if(this.eta==altraPersona.getEta()){
           return this.nome + " e " + altraPersona.getNome()+ "hanno la stessa età";
       }else {
           return altraPersona.getNome()+ " è più grande di " + this.nome;
       }
   }
   
}
