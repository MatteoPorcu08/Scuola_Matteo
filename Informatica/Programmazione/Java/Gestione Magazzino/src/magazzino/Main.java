package magazzino;
public class Main {
    public static void main(String[] args) {
        Magazzino magazzino = new Magazzino(100);

        try {
            magazzino.scaricaMerce(30);
            System.out.println("Merce scaricata. Quantità disponibile: " + magazzino.getQuantitaDisponibile());
            magazzino.scaricaMerce(80); // Questo causerà un'eccezione
        } catch (ProdottoEsauritoException e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            System.out.println("Operazione di scarico merce completata.");
        }
    }
}