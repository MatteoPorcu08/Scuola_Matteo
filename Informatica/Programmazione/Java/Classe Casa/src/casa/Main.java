package casa;
public class Main {
    public static void main(String[] args) {
        Casa casa1 = new Casa("Via Musei 31", 10, 200, 450000.0, true, 2000);
        Casa casa2 = new Casa ("Via roma 2", 5, 90, 150000.0, false, 1990);

        //presentazione del programma
        System.out.println("---Benvenuto nel programma di gestione delle case!---");

        //stampa delle case create
        System.out.println(casa1.toString());
        System.out.println(casa2.toString());



    }
}