package servizi;
public class Main {
    public static void main(String[] args) {
        Videoteca v1 = new Videoteca();
        Film f1 = new Film ("Minecraft", "matteo", 2012, 100, 7.5, true);
        Film f2 = new Film ("Titolo1","Regista1",2022, 90,8.0, true);

        //Test aggiungiFilm
        System.out.println(v1.aggiungiFilm(f1));
        System.out.println(v1.aggiungiFilm(f2));
        System.out.println(v1.aggiungiFilm(null));
    }
}
