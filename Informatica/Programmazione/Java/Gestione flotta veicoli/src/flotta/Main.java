package flotta;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Veicolo> veicoli = new ArrayList<>();

        Automobile auto = new Automobile("Fiat", "Panda", 170, 5, false, 70);

        Camion camion = new Camion("Iveco", "Daily", 130, 3500, 0, false, 80);

        Bicicletta bici = new Bicicletta("Trek", "Marlin", 40, 21);

        // Inserimento dei veicoli
        veicoli.add(auto);
        veicoli.add(camion);
        veicoli.add(bici);

        // Visualizzazione dei veicoli
        System.out.println("Lista dei veicoli:");

        for (int i = 0; i < veicoli.size(); i++) {
            System.out.println("Veicolo " + i + ": "+ veicoli.get(i).getMarca() + " "+ veicoli.get(i).getModello());

            veicoli.get(i).muovi();
        }

        // Rimozione di un veicolo
        veicoli.remove(1);

        for (int i = 0; i < veicoli.size(); i++) {
            System.out.println(veicoli.get(i).getMarca()
                    + " " + veicoli.get(i).getModello());
        }
    }
}