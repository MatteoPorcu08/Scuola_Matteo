import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual è il tuo nome? ");
        String name = scanner.nextLine();

        System.out.print("Qual è la tua età? ");
        int age = scanner.nextInt();

        System.out.println("Ciao " + name + ", hai " + age + " anni.");

        scanner.close();
    }
}