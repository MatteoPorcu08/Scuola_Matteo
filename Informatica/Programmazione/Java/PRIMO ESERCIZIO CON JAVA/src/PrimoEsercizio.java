/*Realizzare un programma che dati due valori interi memorizzati nelle variabili varA e varB. In seguito, scambi il valore di tali variabili e stampi a schermo il nuovo contenuto. */

public class PrimoEsercizio {
    public static void main(String[] args) throws Exception {
        int varA = 5;
        int varB = 10;
        int varC;

        System.out.println("Valore di varA: " + varA);
        System.out.println("Valore di varB: " + varB);

        varC = varA;
        varA = varB;
        varB = varC;

        System.out.println("Nuovo valore di varA: " + varA);
        System.out.println("Nuovo valore di varB: " + varB);
    }
}

