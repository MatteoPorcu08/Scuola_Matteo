package superclasse;

public class Main {
    public static void main(String[] args) {
        Automobile auto1 = new Automobile("Fiat", "Panda", 2020, 30.0, 5, "Benzina");
        Motocicletta moto1 = new Motocicletta("KTM", "EXC 125", 2010, 25.0, 125, false);
        Motocicletta moto2 = new Motocicletta("Honda", "CB500X", 2021, -10.0, 471, false);

        System.out.println("Dettagli dell'automobile:");
        auto1.stampaDettagli();
        System.out.println("Costo per 10 giorni: " + auto1.calcolaCosto(10) + " euro");

        System.out.println("\nDettagli della motocicletta:");
        moto1.stampaDettagli();
        System.out.println("Costo per 6 giorni: " + moto1.calcolaCosto(6) + " euro");

        System.out.println("\nDettagli della seconda motocicletta:");
        moto2.stampaDettagli();
        System.out.println("Costo per 6 giorni: " + moto2.calcolaCosto(6) + " euro");
    }
}