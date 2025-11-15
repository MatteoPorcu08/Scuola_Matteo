package casa;
public class Main {
    public static void main(String[] args) {
        Casa casa1 = new Casa("Via Musei 31", 10, 200, 450000.0, true, 2000);
        Casa casa2 = new Casa ("Via roma 2", 5, 90, 150000.0, false, 1990);

        //presentazione del programma
        System.out.println("---Benvenuto nel programma di gestione delle case!---");

        //stampa delle case create con il metodo toString
        System.out.println("---Casa 1---");
        System.out.println(casa1.toString());
        System.out.println("------------------------------------");
        System.out.println("---Casa 2---");
        System.out.println(casa2.toString());
        System.out.println("------------------------------------");

        //test costrottore di copia
        Casa casa3 = new Casa(casa1);
        System.out.println("---Casa 3 (copia di casa 1)---");
        System.out.println(casa3.toString());
        System.out.println("------------------------------------");
        Casa casa4 = new Casa(casa2);
        System.out.println("---Casa 4 (copia di casa 2)---");
        System.out.println(casa4.toString());
        System.err.println("------------------------------------");

        //modifico alcuni attributi con i setter
        casa3.setIndirizzo("Via Milano 10");
        casa3.setPrezzo(480000.0);
        System.out.println("---Casa 3 modificata---");
        System.out.println(casa3.toString());
        System.out.println("------------------------------------");

        //confronto tra le case
        System.out.println("---Confronto tra le case---");




    }
}