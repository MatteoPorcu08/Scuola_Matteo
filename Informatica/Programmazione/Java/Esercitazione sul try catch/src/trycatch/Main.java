package trycatch;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Inserisci la tua età:");
            int age = Integer.parseInt(System.console().readLine());
            if (age < 0) {
                throw new IllegalArgumentException("L'età non può essere negativa.");
            }
            System.out.println("La tua età è: " + age);
        } catch (NumberFormatException e) {
            System.out.println("Errore: input non numerico. Per favore, inserisci un numero valido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}