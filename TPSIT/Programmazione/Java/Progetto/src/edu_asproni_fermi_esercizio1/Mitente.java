package edu_asproni_fermi_esercizio1;

public class Mitente {
    public void inviaMessaggio(Destinatario destinatario, String messaggio) {
        System.out.println("Messaggio inviato a " + destinatario.getNome() + ": " + messaggio);
    }
}