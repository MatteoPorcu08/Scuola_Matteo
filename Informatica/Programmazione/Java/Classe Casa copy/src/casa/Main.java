package casa;
public class Main {
    public static void main(String[] args) {
        //creazione di due oggetti Casa
        Casa casa1 = new Casa("Via Musei 31", 10, 200, 450000.0, true, 2000);
        Casa casa2 = new Casa ("Via roma 2", 5, 90, 150000.0, false, 1990);

        //presentazione del programma
        System.out.println("---Benvenuto nel programma di gestione delle case!---");
        System.out.println("\n");

        //stampa delle case create con il metodo toString
        System.out.println("---Casa 1---");
        System.out.println(casa1.toString());
        System.out.println("------------------------------------");
        System.out.println("---Casa 2---");
        System.out.println(casa2.toString());
        System.out.println("------------------------------------");
        System.out.println("\n");

        //test costrottore di copia
        Casa casa3 = new Casa(casa1);
        System.out.println("---Casa 3 (copia di casa 1)---");
        System.out.println(casa3.toString());
        System.out.println("------------------------------------");
        Casa casa4 = new Casa(casa2);
        System.out.println("---Casa 4 (copia di casa 2)---");
        System.out.println(casa4.toString());
        System.err.println("------------------------------------");
        System.out.println("\n");

        //modifico alcuni attributi con i setter
        casa3.setIndirizzo("Via Milano 10");
        casa3.setPrezzo(480000.0);
        System.out.println("---Casa 3 modificata---");
        System.out.println(casa3.toString());
        System.out.println("------------------------------------");
        System.out.println("\n");

        //confronto tra le case
        System.out.println("---Confronto tra le case---");
        System.out.println("---Confronto superficie casa 1 e casa 2---");
        System.out.println(casa1.haSuperficieMaggioreDi(casa2));
        System.out.println("--------------------------------");
        System.out.println("---Confronto prezzo casa 1 e casa 2---");
        System.out.println(casa1.haPrezzoMinoreDi(casa2));
        System.out.println("--------------------------------");
        System.out.println("\n");

        //MAIN PROPRIETARIO
        //creazione di due oggetti Proprietario
        Proprietario proprietario1 = new Proprietario("Matteo", "Porcu", "PRCMTT00R31B354B", casa1);
        Proprietario proprietario2 = new Proprietario("Luca", "Rossi", "RSSLCU90A01C352B", casa2);

        //stampa dei proprietari con il metodo toString
        System.out.println("---Proprietario 1---");
        System.out.println(proprietario1.toString());
        System.out.println("------------------------------------");
        System.out.println("---Proprietario 2---");
        System.out.println(proprietario2.toString());
        System.out.println("------------------------------------");
        System.out.println("\n");

        //test costruttore di copia
        Proprietario proprietario3 = new Proprietario(proprietario1);
        System.out.println("---Proprietario 3 (copia di proprietario 1)---");
        System.out.println(proprietario3.toString());
        System.out.println("------------------------------------");
        Proprietario proprietario4 = new Proprietario(proprietario2);
        System.out.println("---Proprietario 4 (copia di proprietario 2)---");
        System.out.println(proprietario4.toString());
        System.out.println("------------------------------------");
        System.out.println("\n");

        //verifica se i proprietari hanno una casa con giardino
        System.out.println("---Verifica casa con giardino---");
        System.out.println("Proprietario 1 ha casa con giardino? " + proprietario1.haCasaConGiardino());
        System.out.println("Proprietario 2 ha casa con giardino? " + proprietario2.haCasaConGiardino());
        System.out.println("------------------------------------");
        System.out.println("\n");

        //aggiornamento casa del proprietario
        System.out.println("---Aggiornamento casa del proprietario 1---");
        String risultatoAggiornamento = proprietario1.aggiornaCasa(casa2);
        System.out.println(risultatoAggiornamento);
        System.out.println("Dati aggiornati del proprietario 1:");
        System.out.println(proprietario1.toString());
        System.out.println("------------------------------------");
    }
}