package Videogiochi;

public class Main {
    public static void main(String[] args) {
        Guerriero guerriero = new Guerriero("Conan", 100);
        MagoBianco magoBianco = new MagoBianco("Merlino", 80);

        System.out.println("Nome del guerriero: " + guerriero.getNome());
        System.out.println("Punti vita del guerriero: " + guerriero.getPuntiVita());
        guerriero.attacca();
        guerriero.usaAbilitaSpeciale();

        System.out.println();

        System.out.println("Nome del mago bianco: " + magoBianco.getNome());
        System.out.println("Punti vita del mago bianco: " + magoBianco.getPuntiVita());
        magoBianco.attacca();
        magoBianco.curaAlleato();
        magoBianco.usaAbilitaSpeciale();
    }
}