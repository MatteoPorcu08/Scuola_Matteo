package podcast;

public class Main {
        public static void main(String[] args){
            Podcast p1 = new Podcast("p1", "autore1", 120, 2024, 140, null, false);
            Podcast p2 = new Podcast("P2", "autore2", 240, 2020, 12, null, false);
            AudioLibro a1 = new AudioLibro("a1", "autoreA", 150, 2023, 0, null, 0, false);
            AudioLibro a2 = new AudioLibro("a2", "autoreB", 160, 2021, 0, null, 0, false);

            //Chiamo ascolta() su piu contenuti
            p1.ascolta();
            p2.ascolta();
            a1.ascolta();
            a2.ascolta();


            //Stampo i contenuti con toString()
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(a1);
            System.out.println(a2);

            //Verifico il numero di riproduzioni
            System.out.println("Riproduzioni p1: " + p1.getNumeroRiproduzioni());
            System.out.println("Riproduzioni p2: " + p2.getNumeroRiproduzioni());
            System.out.println("Riproduzioni a1: " + a1.getNumeroRiproduzioni());
            System.out.println("Riproduzioni a2: " + a2.getNumeroRiproduzioni());

            //Verifico se un contenuto è popolare
            System.out.println("p1 è popolare: " + p1.isPopolare());
            System.out.println("p2 è popolare: " + p2.isPopolare());
            System.out.println("a1 è popolare: " + a1.isPopolare());
            System.out.println("a2 è popolare: " + a2.isPopolare());

            //Inserisco gli elementi nell'array
                Catalogo catalogo = new Catalogo();
                catalogo.aggiungiContenuto(p1);
                catalogo.aggiungiContenuto(p2);
                catalogo.aggiungiContenuto(a1);
                catalogo.aggiungiContenuto(a2);
            //Cerco un contenuto
                Contenuto trovato = catalogo.cercaContenuto("p1");
                if (trovato != null) {
                    System.out.println("Contenuto trovato: " + trovato);
                } else {
                    System.out.println("Contenuto non trovato");
                }
            //Uso il metodo visualizzaCatalogo()
                catalogo.visualizzaCatalogo();
            //Rimuovo un contenuto per titolo
                boolean rimosso = catalogo.rimuoviContenuto("P2");
                if (rimosso) {
                    System.out.println("Contenuto rimosso con successo");
                } else {
                    System.out.println("Contenuto non trovato per la rimozione");
                }
        }
}