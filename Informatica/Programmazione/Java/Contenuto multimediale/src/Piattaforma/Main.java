package Piattaforma;
public class Main {
    public static void main (String[] args) {
        ContenutoMultimediale c1 = new ContenutoMultimediale("Batman Begins ", "Azione", 140, 2005, 4.0);
        ContenutoMultimediale c2 = new ContenutoMultimediale("Frankenstein", "Horror", 149, 2025, 4.0);

        //presentazione della piattaforma
        System.out.println("Benvenuto nella Piattaforma di Contenuto Multimediale!");

        //metodo toString
        System.out.println("--- Dettagli Contenuti Multimediali ---");
        System.out.println("Contenuto 1:");
        System.out.println(c1.toString());
        System.out.println("Contenuto 2:");
        System.out.println(c2.toString());
        System.out.println("---------------------------------------");
        System.out.println("\n");
    }
}
