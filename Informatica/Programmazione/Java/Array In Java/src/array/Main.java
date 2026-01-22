package array;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int v1[];
        int[] v2;
        v1= new int[5];
        v2= new int[6];

        for (int i=0; i<5; i++) {
            System.out.println("Inserisci un intero: ");
            v1[i]=s.nextInt();
            s.nextLine();
    }

        for (int i=0; i<5; i++) {
            System.out.println("v1["+(i+1)+"]="+v1[i]);
    }

       //Dentro v2 inserisco i successivi di v1

        for (int i=0; i<5; i++ ) {
            v2[i]=v1[i]+1;
    }
        v2[5]=100;
        for (int i=0; i<6; i++) {
            System.out.println("v2["+(i+1)+"]="+v2[i]);
        }
    }
}