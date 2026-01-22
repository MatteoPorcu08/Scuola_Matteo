package array;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int v[];
        v = new int[5];
        for (int i = 0; i < v.length; i++) {
            System.out.println("Inserisci il valore per l'elemento " + i);
            v[i] = s.nextInt();
        }
        System.out.println("Elementi dell'array:");
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }
}