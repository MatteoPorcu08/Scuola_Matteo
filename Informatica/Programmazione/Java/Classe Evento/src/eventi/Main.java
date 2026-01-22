package eventi;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Evento e1 = new Evento(LocalDate.of(2026, 1, 11), "Riunione dipartimento");
        Evento e2 = new Evento(LocalDate.now().plusDays(7), "Verifica TPSIT");
        Evento e3 = new Evento(e1); // copia

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println();

        System.out.println("e1 passato? " + e1.isPast());
        System.out.println("e2 futuro? " + e2.isFuture());

        System.out.println("Giorni mancanti e2: " + e2.daysUntil());
        System.out.println("Lunghezza descrizione e1: " + e1.lunghezzaDescrizione());

        System.out.println("Contiene 'riunione'? " + e1.contieneKeyword("riunione"));

        System.out.println();
        System.out.println("Data prima: " + e2.getData());
        e2.spostaDiGiorni(3);
        System.out.println("Data dopo: " + e2.getData());
    }
}
