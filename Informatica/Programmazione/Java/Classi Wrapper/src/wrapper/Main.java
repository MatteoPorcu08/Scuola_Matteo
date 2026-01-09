package wrapper;
public class Main {
    public static void main(String[] args) {

        // PARTE 1: Autoboxing e Unboxing
        int num1 = 10;
        int num2 = 20;

        Integer intObj1 = num1; // autoboxing
        Integer intObj2 = num2; // autoboxing

        System.out.println("PARTE 1:");
        System.out.println("Integer 1: " + intObj1);
        System.out.println("Integer 2: " + intObj2);

        // PARTE 2: Conversione da Stringa a Numero
        String str1 = "123";
        String str2 = "45.67";
        String str3 = "abc";

        Integer intFromString = Integer.valueOf(str1);
        System.out.println("\nPARTE 2:");
        System.out.println("Conversione di str1 in Integer: " + intFromString);

        Double doubleFromString = Double.valueOf(str2);
        System.out.println("Conversione di str2 in Double: " + doubleFromString);

        // PARTE 3: Conversione da Numero a Stringa
        Integer intNumber = 789;
        Double doubleNumber = 12.34;

        String intToString = intNumber.toString();
        String doubleToString = doubleNumber.toString();

        System.out.println("\nPARTE 3:");
        System.out.println("Integer convertito in String: " + intToString);
        System.out.println("Double convertito in String: " + doubleToString);
    }
}
