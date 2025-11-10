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

        //metodo ottieniCategoria
        System.out.println("--- Categorie dei Contenuti ---");
        System.out.println("Categoria del Contenuto 1: " + c1.ottieniCategoria());
        System.out.println("Categoria del Contenuto 2: " + c2.ottieniCategoria());
        System.out.println("---------------------------------------");
        System.out.println("\n");

        //metodo durataOreMinuti()
        System.out.println("--- Durata dei Contenuti in Ore e Minuti ---");
        System.out.println("Durata del Contenuto 1: " + c1.durataOreMinuti());
        System.out.println("Durata del Contenuto 2: " + c2.durataOreMinuti());
        System.out.println("---------------------------------------");
        System.out.println("\n");

        //metodo aggiornaValutazione(nuovaValutazione)
        System.out.println("--- Aggiornamento Valutazioni ---");
        System.out.println("Aggiornamento valutazione del Contenuto 1 a 4.5: " + (c1.aggiornaValutazione(4.5) ? "Successo" : "Fallito"));
        System.out.println("Aggiornamento valutazione del Contenuto 2 a 5.5: " + (c2.aggiornaValutazione(5.5) ? "Successo" : "Fallito"));
        System.out.println("Nuova valutazione del Contenuto 1: " + c1.aggiornaValutazione.toString());
        System.out.println("Nuova valutazione del Contenuto 2: " + c2.toString());
        System.out.println("---------------------------------------");
        System.out.println("\n");
    }
}
