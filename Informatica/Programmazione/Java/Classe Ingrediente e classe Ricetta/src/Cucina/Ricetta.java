package Cucina;
public class Ricetta {
    private String nome;
    private int tempoPreparazione; // in minuti
    private String difficolta; // "Facile", "Media", "Difficile"
    private int porzioni;
    private Ingrediente ingredienti1, ingredienti2, ingredienti3;

    //Costruttore principale
    public Ricetta(String nome, int tempoPreparazione, String difficolta, int porzioni, Ingrediente ingredienti1, Ingrediente ingredienti2, Ingrediente ingredienti3) {
        this.nome = nome;
        this.tempoPreparazione = tempoPreparazione;
        this.difficolta = difficolta;
        this.porzioni = porzioni;
        this.ingredienti1 = new Ingrediente(ingredienti1);
        this.ingredienti2 = new Ingrediente(ingredienti2);
        this.ingredienti3 = new Ingrediente(ingredienti3);
    }

    //Costruttore di copia
    public Ricetta(Ricetta altra) {
        this.nome = altra.nome;
        this.tempoPreparazione = altra.tempoPreparazione;
        this.difficolta = altra.difficolta;
        this.porzioni = altra.porzioni;
        this.ingredienti1 = new Ingrediente(altra.ingredienti1);
        this.ingredienti2 = new Ingrediente(altra.ingredienti2);
        this.ingredienti3 = new Ingrediente(altra.ingredienti3);
    }

    //Metodi getter
    public String getNome() {
        return nome;
    }
    public int getTempoPreparazione() {
        return tempoPreparazione;
    }
    public String getDifficolta() {
        return difficolta;
    }
    public int getPorzioni() {
        return porzioni;
    }
    public Ingrediente getIngredienti1() {
        return new Ingrediente(ingredienti1);
    }
    public Ingrediente getIngredienti2() {
        return new Ingrediente(ingredienti2);
    }
    public Ingrediente getIngredienti3() {
        return new Ingrediente(ingredienti3);
    }

    //Metodi setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTempoPreparazione(int tempoPreparazione) {
        this.tempoPreparazione = tempoPreparazione;
    }
    public void setDifficolta(String difficolta) {
        this.difficolta = difficolta;
    }
    public void setPorzioni(int porzioni) {
        this.porzioni = porzioni;
    }
    public void setIngredienti1(Ingrediente ingredienti1) {
        this.ingredienti1 = new Ingrediente(ingredienti1);
    }
    public void setIngredienti2(Ingrediente ingredienti2) {
        this.ingredienti2 = new Ingrediente(ingredienti2);
    }
    public void setIngredienti3(Ingrediente ingredienti3) {
        this.ingredienti3 = new Ingrediente(ingredienti3);
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Ricetta: " + nome + "\n" +"Tempo di preparazione: " + tempoPreparazione + " minuti\n" +"Difficoltà: " + difficolta + "\n" +"Porzioni: " + porzioni + "\n" +"Ingredienti:\n" +"1. " + ingredienti1.toString() + "\n" +"2. " + ingredienti2.toString() + "\n" +"3. " + ingredienti3.toString();
    }

    //Metodo  scalaDosi(int nuovePorzioni)
    public void scalaDosi(int nuovePorzioni) {
        double fattoreScala = (double) nuovePorzioni / porzioni;
        ingredienti1.setQuantita(ingredienti1.getQuantita() * fattoreScala);
        ingredienti2.setQuantita(ingredienti2.getQuantita() * fattoreScala);
        ingredienti3.setQuantita(ingredienti3.getQuantita() * fattoreScala);
        porzioni = nuovePorzioni;
    }

    //Metodo calcolaCalorieTotali()
    public double calcolaCalorieTotali() {
        double calorieTotali = 0;
        calorieTotali += ingredienti1.calorieTotali();
        calorieTotali += ingredienti2.calorieTotali();
        calorieTotali += ingredienti3.calorieTotali();
        return calorieTotali;
    }

    //Mettodo stimaCostoTotale()
    public double stimaCostoTotale() {
        return ingredienti1.costoTotale()
            + ingredienti2.costoTotale()
            + ingredienti3.costoTotale();
    }

    //Metodo  isVegetariana()
    public boolean isVegetariana() {
        return ingredienti1.isVegetariano() && ingredienti2.isVegetariano() && ingredienti3.isVegetariano();
    }

    //Metodo  sostituisciIngrediente(int numeroIngrediente, Ingrediente nuovoIngrediente)
    public boolean sostituisciIngrediente(int numeroIngrediente, Ingrediente nuovoIngrediente) {
    if (numeroIngrediente == 1) {
        ingredienti1 = new Ingrediente(nuovoIngrediente);
        return true;
    } else if (numeroIngrediente == 2) {
        ingredienti2 = new Ingrediente(nuovoIngrediente);
        return true;
    } else if (numeroIngrediente == 3) {
        ingredienti3 = new Ingrediente(nuovoIngrediente);
        return true;
    }
    return false; // numero non valido
    }

    //Metodo confrontaDifficolta(Ricetta altra)
    public String confrontaDifficolta(Ricetta altra) {
    if (this.difficolta == altra.difficolta) {
        return "Stessa difficoltà";
    }
    if (this.difficolta == "Difficile") {
        return "Più difficile";
    }
    if (this.difficolta == "Media" && altra.difficolta == "Facile") {
        return "Più difficile";
    }
    if (this.difficolta == "Facile") {
        return "Meno difficile";
    }
    if (this.difficolta == "Media" && altra.difficolta == "Difficile") {
        return "Meno difficile";
    }
    return "Stessa difficoltà"; // caso generico
    }

    //Metodo adattaRicettaPerOspiti(int numOspiti)
    public void adattaRicettaPerOspiti(int numOspiti) {
        scalaDosi(numOspiti);
    }
}