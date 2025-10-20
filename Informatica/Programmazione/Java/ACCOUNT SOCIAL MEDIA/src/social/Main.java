package social;

public class Main {
    public static void main(String[] args) {
        SocialMedia profilo1 = new SocialMedia("__matteoporcu_", "Matteo Porcu", 20000, 30);
        SocialMedia profilo2 = new SocialMedia("anna_rossi", "Anna Rossi", 9999, 15);

        //Spazio
        System.out.println("");

        //Stampa le informazioni iniziali
        System.out.println("Informazioni iniziali:");
        System.out.println("Profilo 1:");
        System.out.println(profilo1.toString());
        System.out.println("Influencer?:");
        System.out.println(profilo1.isInfluencer());
        System.out.println("");
        System.out.println("Profilo 2:");
        System.out.println(profilo2.toString());
        System.out.println("Influencer?:");
        System.out.println(profilo2.isInfluencer());

        //Aggiunge post ai profili
        profilo1.pubblica();
        profilo2.pubblica();

        //Aggiunge follower ai profili
        profilo1.aggiungiFollower();
        profilo2.aggiungiFollower();

        /*Rimuove follower
        profilo1.rimuoviFollower();
        profilo2.rimuoviFollower();
        */
        
        //Spazio
        System.out.println("");

        //Stampa le informazioni aggiornate
        System.out.println("Dopo gli aggiornamenti:");
        System.out.println("Profilo 1:");
        System.out.println(profilo1.toString());
        System.out.println("Diventato influencer?:");
        System.out.println(profilo1.isInfluencer());
        System.out.println("");
        System.out.println("Profilo 2:");
        System.out.println(profilo2.toString());
        System.out.println("Diventato influencer?:");
        System.out.println(profilo2.isInfluencer());

    }
}