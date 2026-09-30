package edu_asproni_fermi_esercizio1;

public class Destinatario {
    private String nome;
    private String codice;

    public Destinatario(String nome, String codice) {
        this.nome = nome;
        this.codice = codice;
    }

    // Getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}