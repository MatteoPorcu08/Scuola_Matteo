package programmi;

public class Main {
    public static void main(String[] args) {
        ProgrammiComputer programma1 = new ProgrammiComputer("AutoCAD", "Autodesk", "1.0", "Windows", 1982);
        ProgrammiComputer programma2 = new ProgrammiComputer("Visual Studio Code", "Microsoft", "2.0", "Linux", 2015);

        // Confronto tra i due programmi
        int confronto = programma1.compareAnno(programma2);
        if (confronto < 0) {
            System.out.println(programma1.getDenominazione() + " è stato rilasciato prima di " + programma2.getDenominazione());
        } else if (confronto > 0) {
            System.out.println(programma1.getDenominazione() + " è stato rilasciato dopo di " + programma2.getDenominazione());
        } else {
            System.out.println("Entrambi i programmi sono stati rilasciati nello stesso anno.");
        }

        //Metodo toString
        System.out.println("\nDettagli Programma 1:");
        System.out.println(programma1.toString());
        System.out.println("\nDettagli Programma 2:");
        System.out.println(programma2.toString());
    }
}