package servizi;
public class Videoteca {
    private Film[] films;
    private int numeroFilm;

    //Costruttore
    public Videoteca (){
        this.films = new Film[20];
        this.numeroFilm = 0;
    }

    //Costruttore di copia
    public Videoteca(Videoteca altra){
        this.films = altra.films;
        this.numeroFilm = altra.numeroFilm;
    }

    //Metodo public boolean aggiungiFilm(Film f)
    public boolean aggiungiFilm(Film f){
        for (int i = 0; i < 20; i++) {
            if(f!=null){
                films[i]= f;
                numeroFilm ++;
                return true;
            }
            }
                return false;
    }

    //Metodo public boolean rimuoviFilm(int posizione)
    public boolean rimuoviFilm(int posizione){
        int y=0;
        for (int i = 0; i < 20; i++) {
        if(posizione>=0 && posizione<=19){
            y--;
            return true;
        }
        }
        return false;
    }

    //Metodo public boolean rimuoviFilm(String titolo)
    public boolean rimuoviFilm(String titolo){
        for (int i = 0; i < 20; i++) {
            if(films[i].getTitolo().equals(titolo)){
                films[i]=null;
                numeroFilm--;
                return true;
            }
        }
        return false;
    }

    //Metodo public boolean cercaFilm(String titolo)
    public boolean cercaFilm(String titolo){
        for (int i = 0; i < 20; i++) {
            if(films[i].getTitolo().equals(titolo)){
                return true;
            }
        }
        return false;
    }


    //Metodo public String visualizzaVideoteca()
    public String visualizzaVideoteca(){
        String s="";
        for (int i = 0; i < 20; i++) {
            if(films[i]!=null){
                s+=films[i].toString()+"\n";
            }
        }
        return s;
    }
}