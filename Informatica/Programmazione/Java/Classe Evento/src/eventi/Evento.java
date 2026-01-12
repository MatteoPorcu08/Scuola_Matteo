package eventi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Evento {

    private LocalDate data;
    private String descrizione;

    // Costruttore principale
    public Evento(LocalDate data, String descrizione) {
        if (data != null && descrizione != null) {
            this.data = data;
            this.descrizione = descrizione;
        }
    }

    // Costruttore di copia
    public Evento(Evento e) {
        this.data = e.data;
        this.descrizione = e.descrizione;
    }

    // Getter e Setter
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate d) {
        if (d != null) {
            data = d;
        }
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String s) {
        if (s != null) {
            descrizione = s;
        }
    }

    // toString
    public String toString() {
        return "Evento: [" + data + "] - Descrizione: " + descrizione;
    }

    // Metodi su LocalDate
    public boolean isPast() {
        return data.isBefore(LocalDate.now());
    }

    public boolean isFuture() {
        return data.isAfter(LocalDate.now());
    }

    public long daysUntil() {
        return ChronoUnit.DAYS.between(LocalDate.now(), data);
    }

    public void spostaDiGiorni(int giorni) {
        data = data.plusDays(giorni);
    }

    // Metodi su String
    public boolean contieneKeyword(String keyword) {
        return descrizione.toLowerCase().contains(keyword.toLowerCase());
    }

    public int lunghezzaDescrizione() {
        return descrizione.length();
    }

    public void aggiornaDescrizione(String nuovaDescrizione) {
        if (nuovaDescrizione != null) {
            descrizione = nuovaDescrizione;
        }
    }
}