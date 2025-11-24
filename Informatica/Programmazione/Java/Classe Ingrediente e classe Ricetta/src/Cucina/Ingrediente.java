package Cucina;
public class Ingrediente {
    private String nome;
    private double quantita; // in grammi
    private String unita;
    private double caloriePerUnita;
    private double costoPerUnita;
    private boolean vegetariano;

    //Costruttore principale
    public Ingrediente(String nome, double quantita, String unita, double caloriePerUnita, double costoPerUnita, boolean vegetariano) {
        this.nome = nome;
        this.quantita = quantita;
        this.unita = unita;
        this.caloriePerUnita = caloriePerUnita;
        this.costoPerUnita = costoPerUnita;
        this.vegetariano = vegetariano;


}
}