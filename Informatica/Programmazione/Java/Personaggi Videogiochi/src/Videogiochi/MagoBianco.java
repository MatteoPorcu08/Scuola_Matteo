package Videogiochi;

public class MagoBianco extends Personaggio implements Curatore, Combattente {

    public MagoBianco(String nome, int puntiVita) {
        super(nome, puntiVita);
    }

    @Override
    public void usaAbilitaSpeciale() {
        System.out.println(nome + " evoca una barriera di luce protettiva!\"");
    }

    @Override
    public void attacca() {
        System.out.println(nome + " scaglia un dardo di energia magica!");
    }

    @Override
    public void curaAlleato() {
        System.out.println(nome + " recita un incantesimo e rigenera i punti vita del team!");
    }
}