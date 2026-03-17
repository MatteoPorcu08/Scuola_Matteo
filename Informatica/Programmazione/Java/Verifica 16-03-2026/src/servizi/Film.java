package servizi;
public class Film {
    private String titolo;
    private String regista;
    private int annoUscita;
    private int durata; //in minuti
    private double voto; // su scala 0-10
    private boolean premioOscar;

    //Costruttore
    public Film (String titolo, String regista, int annoUscita, int durata,double voto, boolean premioOscar ) {
        this.titolo = titolo;
        this.regista = regista;
        this.annoUscita = annoUscita;
        this.durata = durata;
        this.voto = voto;
        this.premioOscar = premioOscar;
    }

    //Costruttore di copia
    public Film( Film altro){
        this.titolo = altro.titolo;
        this.regista = altro.regista;
        this.annoUscita = altro.annoUscita;
        this.durata = altro.durata;
        this.voto = altro.voto;
        this.premioOscar = altro.premioOscar;
    }
    
    //Getter
    public String getTitolo(){
        return titolo;
    }
    public String getRegista(){
        return regista;
    }
    public int getAnnoUscita(){
        return annoUscita;
    }
    public int getDurata(){
        return durata;
    }
    public double getVoto(){
        return voto;
    }
    public boolean getPremioOscar(){
        return premioOscar;
    }

    //Setter
    public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    public void setRegista(String regista){
        this.regista=regista;
    }
    public void setAnnoUsicta(int annoUscita){
        this.annoUscita=annoUscita;
    }
    public void setDurata(int durata){
        this.durata=durata;
    }
    public void setVoto(double voto){
        this.voto=voto;
    }
    public void setPremioOscar(boolean premioOscar){
        this.premioOscar=premioOscar;
    }

    //Metodo toString()
    @Override
    public String toString(){
        return "Film: \nNome:"+titolo+"\nRegista:"+regista+"\nAnno Uscita:"+annoUscita+"\nDurata:"+durata+"\nVoto:"+voto+"\nPremio Oscar:"+premioOscar;
    }

    //Metodo public double costoNoleggio(int giorni, double prezzoGiornaliero)
    public double costoNoleggio(int giorni, double prezzoGiornaliero){
        double costoNoleggio;
        return costoNoleggio= giorni*prezzoGiornaliero;
    }

    //Metodo public boolean aumentaVoto(double incremento)
    public boolean aumentaVoto(double incremento){
        if(incremento>= 10){
            return true;
        }else{
            return false;
        }
    }
}