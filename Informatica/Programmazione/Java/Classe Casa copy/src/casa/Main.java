package casa;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s =new Scanner (System.in);

        Casa C1;
        String indirizzo;

        System.out.println("Inserici l'indirizzo della casa:");
        indirizzo=s.nextLine();
        s.nextLine();
        int numeroStanze;
        System.out.println("Quante stanza ha la casa?");
        numeroStanze=s.nextInt();
        s.nextLine();
        double a;
        System.out.println("Inseerisci la superficie della casa: ");
        a=s.nextDouble();
        s.nextLine();

        double p;
        System.out.println("Quanto costa la casa?");

}
}