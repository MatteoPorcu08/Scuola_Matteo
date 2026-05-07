public class Main {
    public static void main(String[] args) {
        // Divisione per zero
        int a = 5;
        int b = 0;
        try {
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("Errore: divisione per zero");
        }

        // Array Index Out Of Bounds
        int[] arr = { 1, 2, 3 };
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Errore: indice fuori dai limiti dell'array");
        }

        /* Null Pointer Exception
        String str = null;
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Errore: riferimento null");
        }*/

        // Number Format Exception
        String numStr = "abc";
        try {
            int num = Integer.parseInt(numStr);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Errore: formato del numero non valido");
        }
    }
}