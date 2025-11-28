package Cucina;

public class Ingrediente {
    private String nome;
    private double quantita; // in grammi
    private String unita;
    private double caloriePerUnita;
    private double costoPerUnita;
    private boolean vegetariano;

    // Costruttore principale
    public Ingrediente(String nome, double quantita, String unita, double caloriePerUnita, double costoPerUnita,
            boolean vegetariano) {
        this.nome = nome;
        this.quantita = quantita;
        this.unita = unita;
        this.caloriePerUnita = caloriePerUnita;
        this.costoPerUnita = costoPerUnita;
        this.vegetariano = vegetariano;
    }

    // Costruttore di copia
    public Ingrediente(Ingrediente altro) {
        this.nome = altro.nome;
        this.quantita = altro.quantita;
        this.unita = altro.unita;
        this.caloriePerUnita = altro.caloriePerUnita;
        this.costoPerUnita = altro.costoPerUnita;
        this.vegetariano = altro.vegetariano;
    }

    // Metodi getter
    public String getNome() {
        return nome;
    }

    public double getQuantita() {
        return quantita;
    }

    public String getUnita() {
        return unita;
    }

    public double getCaloriePerUnita() {
        return caloriePerUnita;
    }

    public double getCostoPerUnita() {
        return costoPerUnita;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    // Metodi setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantita(double quantita) {
        this.quantita = quantita;
    }

    public void setUnita(String unita) {
        this.unita = unita;
    }

    public void setCaloriePerUnita(double caloriePerUnita) {
        this.caloriePerUnita = caloriePerUnita;
    }

    public void setCostoPerUnita(double costoPerUnita) {
        this.costoPerUnita = costoPerUnita;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    @Override
    public String toString() {
        return "Nome=" + this.nome +"\n" + "Quantita=" + this.quantita +"\n" + "Unita=" + this.unita +"\n" + "Calorieperunita=" + this.caloriePerUnita +"\n" + "Costoperunita=" + this.costoPerUnita +"\n" + "Vegetariano=" + this.vegetariano;
    }

     // Scala quantità
    public void scalaQuantita(double fattore) {
        if (fattore > 0) {
            this.quantita *= fattore;
        }
    }

    // Calorie totali
    public double calorieTotali() {
        return quantita * caloriePerUnita;
    }

    // Costo totale
    public double costoTotale() {
        return quantita * costoPerUnita;
    }
}