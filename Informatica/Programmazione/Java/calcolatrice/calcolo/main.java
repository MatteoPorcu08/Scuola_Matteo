package calcolatrice.calcolo;

public class main {
    int a = 10;
    int b = 20;

    int somma = a + b;
    int sottrazione = a - b;
    int moltiplicazione = a * b;
    int divisione = a / b;

    public static void main(String[] args) {
        System.out.println("Il risultato della somma di " + a + "e "+b+:" + somma);
        System.out.println("Il risultato della sottrazione è:" + sottrazione);
        System.out.println("Il risultato della moltiplicazione è:" + moltiplicazione);
        System.out.println("Il risultato della divisione è:" + divisione);
    }
}
