package Catena;
public class Main {
    public static void main(String[] args) {
        CatenaAutonoleggio v1 = new CatenaAutonoleggio("FI500EP", "Fiat", "500", 499, 1958, 4);
        CatenaAutonoleggio v2 = new CatenaAutonoleggio("BM320LX", "BMW", "Serie 3", 1999, 2023, 5);

        //presentazione programma
        System.out.println("Benvenuto nel programma di gestione della catena di autonoleggio!");
        System.out.println("\n");

        //visualizzazione auto
        System.out.println("Ecco le auto attualmente disponibili nel nostro parco auto:");
        System.out.println("Auto 1:");
        System.out.println("Targa: " + v1.getTarga());

    }
}
