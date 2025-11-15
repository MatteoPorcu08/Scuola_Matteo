package casa;
public class Main {
    public static void main(String[] args) {
        Casa c1 = new Casa("Via Garibaldi 12", 7, 120, 320000.0, true, 2015);
        Casa c2 = new Casa("Corso Italia 45", 3, 85, 210000.0, false, 2005);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println("\n");

        Casa c3 = new Casa(c1);
        System.out.println(c3.toString());
        Casa c4 = new Casa(c2);
        System.out.println(c4.toString());
        System.out.println("\n");

        c3.setIndirizzo("Via Manzoni 20");
        c3.setPrezzo(345000.0);
        System.out.println("---Casa 3 modificata---");
        System.out.println(c3.toString());
        System.out.println("------------------------------------");
        System.out.println("\n");

        System.out.println("---Confronto tra le case---");
        System.out.println("---Confronto superficie casa 1 e casa 2---");
        System.out.println(c1.haSuperficieMaggioreDi(c2));
        System.out.println("--------------------------------");
        System.out.println("---Confronto prezzo casa 1 e casa 2---");
        System.out.println(c1.haPrezzoMinoreDi(c2));
        System.out.println("--------------------------------");
        System.out.println("\n");
    }
}