package elaboratori;
public class Main {
    public static void main(String[] args) {
        elaboratori.Computer pc1 = new elaboratori.Computer("Asus", "ZenBook", 999.99, "Intel i7", 16, 512);
        elaboratori.Computer pc2 = new elaboratori.Computer("Dell", "XPS 13", 1199.99, "Intel i5", 8, 256);

        // Stampa le informazioni dei computer
        System.out.println("Computer 1:");
        System.out.println("Marca: " + pc1.getMarca());
        System.out.println("Modello: " + pc1.getModello());
        System.out.println("Prezzo: " + pc1.getPrezzo());
        System.out.println("CPU: " + pc1.getCpu());
        System.out.println("RAM: " + pc1.getRam() + "GB");
        System.out.println("Storage: " + pc1.getStorage() + "GB");
        System.out.println(\n);
        System.out.println("Computer 2:");
        System.out.println("Marca: " + pc2.getMarca());
        System.out.println("Modello: " + pc2.getModello());
        System.out.println("Prezzo: " + pc2.getPrezzo());
        System.out.println("CPU: " + pc2.getCpu());
        System.out.println("RAM: " + pc2.getRam() + "GB");
        System.out.println("Storage: " + pc2.getStorage() + "GB");
    }
}
