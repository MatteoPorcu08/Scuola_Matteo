# Algoritmo di Steam Who?

## Panoramica

Steam Who? è un gioco ispirato ad Akinator che cerca di indovinare un personaggio storico scientifico ponendo domande a cui l'utente risponde con Sì o No.

## Database dei Personaggi

Il gioco contiene **20 personaggi** della storia della scienza, della tecnologia e della matematica. Ogni personaggio ha **40 attributi booleani** (vero/falso) e una domanda speciale, come ad esempio:

- `donna`: true/false
- `fisico`: true/false
- `nobel`: true/false
- `elemento_chimico`: true/false
- `fuga_esilio`: true/false
- `domanda_bonus`: "Hai scoperto il fattore di crescita nervoso (NGF)?"
- ecc.

## Algoritmo di Selezione delle Domande: Entropia di Shannon

### Cos'è l'Entropia di Shannon?

L'entropia di Shannon misura l'**incertezza** associata a una variabile casuale. In questo contesto, misura quanto una domanda è efficace nel dividere i personaggi rimanenti.

### Formula

```text
H(X) = -[p_yes * log2(p_yes) + p_no * log2(p_no)]