package casa;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s =new Scanner (System.in);

        Casa C1;

        //CREAZIONE OGGETTO CASA
        String indirizzo;
        System.out.println("Inserici l'indirizzo della casa:");
        indirizzo=s.nextLine();
        s.nextLine();
        int numeroStanze;
        System.out.println("Quante stanza ha la casa?");
        numeroStanze=s.nextInt();
        s.nextLine();
        double a;
        System.out.println("Inserisci la superficie della casa: ");
        a=s.nextDouble();
        s.nextLine();
        double p;
        System.out.println("Quanto costa la casa?");
        p=s.nextDouble();
        s.nextLine();
        boolean g;
        System.out.println("Ha il giardino? (true/false)");
        g=s.nextBoolean();
        s.nextLine();
        int anno;
        System.out.println("In che hanno e stata costruita?");
        anno=s.nextInt();
        s.nextLine();

        C1=new Casa(indirizzo,numeroStanze,a,p,g,anno);

        //CREAZIONE OGGETTO PROPRIETARIO
        Proprietario p1;

        System.out.println("---Inserisic i dati del proprietario---");
        System.out.println("Inserisci il nome:");
        String nome= s.nextLine();
        System.out.println("Inserisci il cognome:");
        String cognome= s.nextLine();
        System.out.println("Inserisci il codice Fiscale:");
        String codFiscale= s.nextLine();
        p1=new Proprietario(nome,cognome,codFiscale,C1);
        System.out.println(p1.toString());
    }
}