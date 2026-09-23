package Videogiochi;

public class Guerriero extends Personaggio implements Combattente {

    public Guerriero(String nome, int puntiVita) {
        super(nome, puntiVita);
    }

    @Override
    public void attacca() {
        System.out.println(nome + " colpisce il bersaglio con la sua ascia! ");
    }

    @Override
    public void usaAbilitaSpeciale() {
        System.out.println(nome + "  urla una provocazione per attirare i nemici!\"");
    }
}