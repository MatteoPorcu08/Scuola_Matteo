# Algoritmo di Steam Who?

## Panoramica

Steam Who? è un gioco ispirato ad Akinator che cerca di indovinare un personaggio storico scientifico ponendo domande a cui l'utente risponde con Sì o No.

## Database dei Personaggi

Il gioco contiene **20 personaggi** della storia della scienza, della tecnologia e della matematica. Ogni personaggio ha attributi booleani (vero/falso) come:

- `donna`: true/false
- `italiano`: true/false
- `fisico`: true/false
- `nobel`: true/false
- `matematica`: true/false
- `astronomia`: true/false
- `invenzione`: true/false
- `vivo`: true/false
- ecc.

## Algoritmo di Selezione delle Domande: Entropia di Shannon

### Cos'è l'Entropia di Shannon?

L'entropia di Shannon misura l'**incertezza** associata a una variabile casuale. In questo contesto, misura quanto una domanda è efficace nel dividere i personaggi rimanenti.

### Formula

```
H(X) = -[p_yes * log2(p_yes) + p_no * log2(p_no)]
```

Dove:

- `p_yes` = percentuale di personaggi che risponderebbero "Sì"
- `p_no` = percentuale di personaggi che risponderebbero "No"

### Come funziona nel gioco

1. **Calcolo per ogni domanda**: Per ogni domanda non ancora posta, contiamo quanti personaggi risponderebbero Sì e quanti No.

2. **Selezione della domanda migliore**: Si sceglie la domanda con l'**entropia più alta**, ovvero quella che produce la divisione più "equilibrata" (circa 50% Sì, 50% No).

3. **Perché questo funziona?**
   - Un'entropia ALTA significa che la domanda separa bene i personaggi
   - Un'entropia BASSA significa che quasi tutti rispondono uguale (domanda poco utile)
   - L'entropia MASSIMA (1) si ha quando esattamente metà dice Sì e metà dice No

### Esempio pratico

```
Personaggi rimanenti: 10

Domanda: "È una donna?"
- 4 donne (Sì), 6 uomini (No)
- Entropia = 0.97 (ALTA - ottima domanda)

Domanda: "Ha vinto il Nobel?"
- 1 Nobel (Sì), 9 non Nobel (No)
- Entropia = 0.47 (BASSA - domanda poco utile)
```

Verrà scelta la prima domanda perché ha entropia più alta.

## Sistema di Punteggio

### Assegnazione punteggi

Dopo ogni risposta:

- **Risposta CORRETTA** (corrisponde all'attributo): +5 punti
- **Risposta ERRATA** (non corrisponde): -2 punti

### Come si indovina

Quando rimangono pochi personaggi o sono finite le domande, il gioco mostra il personaggio con il punteggio più alto come tentativo.

### Perché punteggio invece di semplice esclusione?

Il punteggio permette di:

- Tenere traccia di risposte potenzialmente errate
- Gestire personaggi con attributi simili
- Avere una "graduatoria" di probabilità

## Flusso di Gioco

```
1. Inizio gioco
   └─> Tutti i 20 personaggi con score = 0

2. Selezione domanda (entropia più alta)
   └─> Mostra domanda all'utente

3. Utente risponde Sì/No
   └─> Aggiorna punteggi di tutti i personaggi

4. Controllo fine gioco
   ├─> Se rimane 1 personaggio → indovina
   ├─> Se finite le domande → indovina il migliore
   └─> Altrimenti → torna al passo 2

5. Tentativo di indovinare
   ├─> Se l'utente dice SÌ → VITTORIA!
   └─> Se l'utente dice NO → Sconfitta, ricomincia
```

## Vantaggi dell'Algoritmo

1. **Efficienza**: Le domande con entropia alta riducono rapidamente il numero di candidati
2. **Universalità**: Funziona con qualsiasi set di personaggi e domande
3. **Adattabilità**: Si adatta alle risposte dell'utente in tempo reale
4. **Minimizzazione domande**: In media indovina con meno domande rispetto a domande casuali

## Limitazioni

1. **Dipendenza dagli attributi**: La qualità dipende da quanto bene gli attributi descrivono i personaggi
2. **Risposte oneste necessarie**: Se l'utente mente, l'algoritmo non può funzionare
3. **Attributi booleani**: Non gestisce risposte parziali o sfumate (es. "forse")

## Confronto con Akinator originale

| Aspetto         | Steam Who?        | Akinator                                        |
| --------------- | ----------------- | ----------------------------------------------- |
| Domande         | 15 fisse          | Centinaia dinamiche                             |
| Personaggi      | 20                | Milioni                                         |
| Algoritmo       | Entropia semplice | Albero decisionale complesso + machine learning |
| Feedback utente | Sì/No             | Sì/No/Non so/Probabilmente                      |
