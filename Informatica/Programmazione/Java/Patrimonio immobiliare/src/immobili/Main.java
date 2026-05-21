package immobili;

public class Main {

    public static void main(String[] args) {

        // Creazione abitazione
        Abitazione a1 = new Abitazione(5,120.5,"Via Roma 10","Milano");

        // Creazione villa
        Villa v1 = new Villa(8,300,"Via Verdi 20","Roma",2,500,true);

        // Creazione appartamento
        Appartamento ap1 = new Appartamento(4,90,"Via Napoli 5","Torino",3,true,2);

        // Stampa oggetti
        System.out.println(a1.toString());

        System.out.println(v1.toString());

        System.out.println(ap1.toString());

        // Test equals
        Abitazione a2 = new Abitazione(5,120.5,"Via Roma 10","Milano");

        System.out.println("a1 uguale ad a2? " + a1.equals(a2));

        Villa v2 = new Villa(8,300,"Via Verdi 20","Roma",2,500,true);

        System.out.println("v1 uguale a v2? " + v1.equals(v2));

        Appartamento ap2 = new Appartamento(4,90,"Via Napoli 5","Torino",3,true,2);

        System.out.println("ap1 uguale ad ap2? " + ap1.equals(ap2));

        ArrayAbitazioni arrayAbitazioni = new ArrayAbitazioni();
        try {
            arrayAbitazioni.inserisci(a1);
            arrayAbitazioni.inserisci(v1);
            arrayAbitazioni.inserisci(ap1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Stampa array
        System.out.println("Abitazioni nell'array:");
        System.out.println(arrayAbitazioni.toString());
        // Cerca abitazione
        try {
            Abitazione abitazioneCercata = arrayAbitazioni.cercaAbitazione("Via Roma 10");
            System.out.println("Abitazione trovata: " + abitazioneCercata.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Elimina abitazione
        try {
            arrayAbitazioni.elimina("Via Verdi 20");
            System.out.println("Abitazione eliminata.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Stampa array dopo eliminazione
        System.out.println("Abitazioni nell'array dopo eliminazione:");
        System.out.println(arrayAbitazioni.toString());
    }
}