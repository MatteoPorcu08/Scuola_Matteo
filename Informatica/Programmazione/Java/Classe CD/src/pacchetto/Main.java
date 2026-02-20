package pacchetto;

public class Main {
    public static void main(String[] args) {

        CD cd = new CD("Greatest Hits", "Sony Music", 2024);

        Brano b1 = new Brano("Canzone 1", "Artist A", 3.5f, 1);
        Brano b2 = new Brano("Canzone 2", "Artist B", 4.2f, 2);
        Brano b3 = new Brano("Canzone 3", "Artist C", 2.8f, 3);

        cd.aggiungiBrano(b1);
        cd.aggiungiBrano(b2);
        cd.aggiungiBrano(b3);

        System.out.println(cd);
        System.out.println("Durata totale: " + cd.durataTotale());

        //System.out.println("Ricerca per titolo:");
        //System.out.println(cd.cercaBrano("Canzone 2"));

        //cd.rimuoviBrano("Canzone 1");

        System.out.println("Brani sotto 4 minuti: " + cd.braniSotto4Minuti());
    }
}