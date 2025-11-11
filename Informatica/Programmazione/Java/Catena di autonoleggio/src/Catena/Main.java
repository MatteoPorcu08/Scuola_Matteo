package Catena;
public class Main {
    public static void main(String[] args) {
<<<<<<< Updated upstream
        CatenaAutonoleggio v1 = new CatenaAutonoleggio("FI500EP", "Fiat", "500", 499, 1958, 4);
        CatenaAutonoleggio v2 = new CatenaAutonoleggio("BM320LX", "BMW", "Serie 3", 1999, 2023, 5);

        //Presentazione programma
        System.out.println("---Benvenuto nel programma di gestione della catena di autonoleggio!---");
        System.out.println("\n");

        //Visualizzazione auto toString
        System.out.println("---Ecco le auto attualmente disponibili nel nostro parco auto---");
        System.out.println("---Auto 1---");
        System.out.println(v1.toString());
        System.out.println("--------------------------------------------------");
        System.out.println("---Auto 2---");
        System.out.println(v2.toString());
        System.out.println("--------------------------------------------------");
        System.out.println("\n");

        //Costruttore di copia
        CatenaAutonoleggio v3 = new CatenaAutonoleggio(v1);
        CatenaAutonoleggio v4 = new CatenaAutonoleggio(v2);
        System.out.println("---Ecco l'auto 3, creata tramite il costruttore di copia a partire dall'auto 1---");
        System.out.println(v3.toString());
        System.out.println("--------------------------------------------------");
        System.out.println("---Ecco l'auto 4, creata tramite il costruttore di copia a partire dall'auto 2---");
        System.out.println(v4.toString());
        System.out.println("--------------------------------------------------");
        System.out.println("\n");

        //Metodo confrontaautopotenza
        System.out.println("---Confronto della cilindrata tra l'auto 1 e l'auto 2---");
        System.out.println(v1.confrontaautopotenza(v2));
        System.out.println("--------------------------------------------------");
        System.out.println("\n");

        //Metodo nolleggio
        System.out.println("---Simulazione del noleggio dell'auto 1 e 2---");
        System.out.println("---Stato noleggio auto 1---");
        System.out.println(v1.noleggio());
        System.out.println("--------------------------------------------------");
        System.out.println("---Stato noleggio auto 2---");
        System.out.println(v2.noleggio());
        System.out.println("--------------------------------------------------");
=======
        CatenaAutonoleggio v1 = new CatenaAutonoleggio("FI500EP", "Fiat", "500", 1958, 1958, 0);
        CatenaAutonoleggio v2 = new CatenaAutonoleggio("BM320LX", "BMW", "Serie 3", 2023, 5, 0);
>>>>>>> Stashed changes
    }
}