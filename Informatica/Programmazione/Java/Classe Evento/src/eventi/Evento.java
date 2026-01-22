package eventi;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Classe che rappresenta un evento con data e descrizione.
 * @author La classe 4B Inf
 * @version 2.3
 */

public class Evento {

    /** Data dell'evento */
    private LocalDate data;
    /** Descrizione dell'evento */
    private String descrizione;

    /** Costruttore principale
     *  @param data La data dell'evento
     *  @param descrizione La descrizione dell'evento
     */
    public Evento(LocalDate data, String descrizione) {
        if (data != null && descrizione != null) {
            this.data = data;
            this.descrizione = descrizione;
        }
    }

    /** Costruttore di copia
        *  @param altro Un altro oggetto Evento da copiare
    */
    public Evento(Evento altro) {
        this.data = altro.data;
        this.descrizione = altro.descrizione;
    }

    /**
     * Restituisce la data dell'evento
     * @return La data dell'evento
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Restituisce la descrizione dell'evento
     * @return La descrizione dell'evento
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta la data dell'evento
     * @param d La nuova data dell'evento
     */
    public void setData(LocalDate d) {
        if (d != null) {
            this.data = d;
        }else {
            this.data = LocalDate.now();
        }
    }

    /**
     * Imposta la descrizione dell'evento
     * @param s La nuova descrizione dell'evento. Se null, viene impostata una stringa vuota
     */
    public void setDescrizione(String s) {
        if (s != null) {
            this.descrizione = s;
        } else {
            this.descrizione = "";
        }
    }


    /**
     * Restituisce la rappresentazione in stringa dell'evento
     * @return Una stringa contenente data e descrizione dell'evento
     */
    @Override
    public String toString() {
        return "Evento: [" + this.data + "] - Descrizione: " + this.descrizione;
    }

    /**
     * Verifica se l'evento è nel passato
     * @return true se la data dell'evento è prima della data odierna, false altrimenti
     */
    public boolean isPast() {
        return data.isBefore(LocalDate.now());
    }

    /**
     * Verifica se l'evento è nel futuro
     * @return true se la data dell'evento è dopo la data odierna, false altrimenti
     */
    public boolean isFuture() {
        return data.isAfter(LocalDate.now());
    }

    /**
     * Calcola il numero di giorni fino all'evento
     * @return Il numero di giorni tra oggi e la data dell'evento. Negativo se l'evento è nel passato
     */
    public long daysUntil() {
        return ChronoUnit.DAYS.between(LocalDate.now(), data);
    }

    /**
     * Sposta la data dell'evento di un numero specificato di giorni
     * @param giorni Il numero di giorni di cui spostare l'evento. Positivo per spostare avanti, negativo per spostare indietro
     */
    public void spostaDiGiorni(int giorni) {
        data = data.plusDays(giorni);
    }

    /**
     * Verifica se la descrizione contiene una parola chiave (case-insensitive)
     * @param keyword La parola chiave da cercare
     * @return true se la descrizione contiene la parola chiave, false altrimenti
     */
    public boolean contieneKeyword(String keyword) {
        return descrizione.toLowerCase().contains(keyword.toLowerCase());
    }

    /**
     * Restituisce la lunghezza della descrizione dell'evento
     * @return Il numero di caratteri della descrizione
     */
    public int lunghezzaDescrizione() {
        return descrizione.length();
    }

    /**
     * Aggiorna la descrizione dell'evento
     * @param nuovaDescrizione La nuova descrizione. Se null, la descrizione non viene modificata
     */
    public void aggiornaDescrizione(String nuovaDescrizione) {
        if (nuovaDescrizione != null) {
            descrizione = nuovaDescrizione;
        }
    }
}