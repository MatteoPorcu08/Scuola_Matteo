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


}
