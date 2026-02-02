package pacchetto;

public class Main {
    public static void main(String[] args) {

        CD cd = new CD("Greatest Hits", "Sony Music", 2024);

        Brano b1 = new Brano("Song One", "Artist A", 3.5f, 1);
        Brano b2 = new Brano("Song Two", "Artist B", 4.2f, 2);
        Brano b3 = new Brano("Song Three", "Artist C", 2.8f, 3);

        cd.aggiungiBrano(b1);
        cd.aggiungiBrano(b2);
        cd.aggiungiBrano(b3);

        System.out.println(cd);
        System.out.println("Durata totale: " + cd.durataTotale());

        System.out.println("Ricerca per titolo:");
        System.out.println(cd.cercaBrano("Song Two"));

        cd.rimuoviBrano("Song One");

        System.out.println("Brani sotto 4 minuti: " + cd.braniSotto4Minuti());
    }
}