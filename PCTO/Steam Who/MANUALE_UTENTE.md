# Manuale Utente - Steam Who?

## Indice
1. [Cos'è Steam Who?](#cosè-steam-who)
2. [Come Giocare](#come-giocare)
3. [Interfaccia Grafica](#interfaccia-grafica)
4. [Personaggi Disponibili](#personaggi-disponibili)
5. [Tipi di Domande](#tipi-di-domande)
6. [Domande Bonus](#domande-bonus)
7. [Barra di Confidenza](#barra-di-confidenza)
8. [Fine Gioco](#fine-gioco)

---

## Cos'è Steam Who?

Steam Who? è un gioco di indovinare personaggi ispirato ad Akinator. Il tuo obiettivo è pensare a uno dei 20 personaggi scientifici disponibili e il Genio cercherà di indovinarlo ponendoti domande a cui dovrai rispondere solo con **SÌ** o **NO**.

---

## Come Giocare

### Passi Base

1. **Pensa a un personaggio**: Scegli mentalmente uno dei 20 personaggi scientifici disponibili
2. **Clicca "Inizia il gioco"**: Il Genio inizierà a farti domande
3. **Rispondi onestamente**: Clicca **SÌ** (verde) o **NO** (rosso)
4. **Continua** finché il Genio non indovina il personaggio

### Regole
- Rispondi onestamente per aiutare il Genio a indovinare
- Non c'è limite di tempo
- Puoi arrenderti se pensi che il Genio non riesca a indovinare

---

## Interfaccia Grafica

### Schermata Iniziale
```
┌─────────────────────────────────────────┐
│                                         │
│           [Immagine Genio]              │
│                                         │
│            STEAM WHO?                   │
│                                         │
│   Pensa a un grande personaggio         │
│   della scienza, della tecnologia        │
│   o della matematica e io proverò       │
│   a indovinarlo!                        │
│                                         │
│        [ Inizia il gioco ]              │
│                                         │
└─────────────────────────────────────────┘
```

### Schermata di Gioco
```
┌─────────────────────────────────────────┐
│  [Barra Confidenza] ████░░░░░░  45%    │
├─────────────────────────────────────────┤
│                                         │
│           [Immagine Genio]              │
│         (cambia espressione)            │
│                                         │
│  "È una donna?"                         │
│                                         │
│     [SÌ]         [NO]                  │
│                                         │
│  ─────────────────────────────────────  │
│                                         │
│  [Domanda attuale / Risultato]          │
│                                         │
└─────────────────────────────────────────┘
```

### Espressioni del Genio

| Espressione | Quando appare |
|-------------|---------------|
| 😐 Neutro | Durante le domande normali |
| 🤔 Confuso | Prima di fare un tentativo |
| 😊 Felice | Quando indovina il personaggio |
| 😢 Triste | Quando non riesce a indovinare |

---

## Personaggi Disponibili

Il gioco include **20 personaggi** della storia della scienza, tecnologia e matematica:

### Italiani
| Personaggio | Immagine |
|------------|----------|
| Rita Levi-Montalcini | 🖼️ |
| Galileo Galilei | 🖼️ |
| Leonardo da Vinci | 🖼️ |
| Enrico Fermi | 🖼️ |
| Margherita Hack | 🖼️ |
| Fabiola Gianotti | 🖼️ |
| Guglielmo Marconi | 🖼️ |
| Evangelista Torricelli | 🖼️ |
| Luigi Galvani | 🖼️ |
| Giuseppe Lagrange | 🖼️ |
| Lucia Votano | 🖼️ |
| Anna Grassellino | 🖼️ |
| Alfio Quarteroni | 🖼️ |
| Giuseppina Carniel | 🖼️ |

### Stranieri
| Personaggio | Nazionalità |
|------------|-------------|
| Sofia Kovalevskaya | Russa |
| Ada Lovelace | Britannica |
| Alan Turing | Britannico |
| Marie Curie | Polacca/Francese |
| Albert Einstein | Tedesco/Americano |
| Isaac Newton | Britannico |

---

## Tipi di Domande

### Domande Generali
- "È una donna?"
- "È italiano/a?"
- "È nato/a prima del 1800?"
- "Questa persona è attualmente in vita?"

### Domande sul Campo Scientifico
- "È famoso/a principalmente per la fisica?"
- "È un matematico/a?"
- "È legato/a all'astronomia o allo spazio?"
- "Ha vinto il premio Nobel?"

### Domande sulla Vita Personale
- "È stato costretto a fuggire dal proprio paese?"
- "Ha subito discriminazioni per le sue idee?"
- "È morto/a giovane?"

### Domande Geografiche
- "Ha vissuto o lavorato a lungo negli Stati Uniti?"
- "È nato/a in Germania?"
- "Ha lavorato al CERN di Ginevra?"

---

## Domande Bonus

Quando il Genio è molto sicuro di un personaggio (differenza di punteggio alta), potrebbe farti una **domanda bonus** specifica per confermare.

### Esempi di Domande Bonus
- **Marie Curie**: "Hai scoperto il Radio e il Polonio, vincendo due premi Nobel?"
- **Einstein**: "Hai formulato la famosa teoria della relatività e l'equazione E=mc²?"
- **Galileo**: "Sei famoso per aver puntato il cannocchiale verso le stelle?"

Se rispondi **SÌ** a una domanda bonus, il Genio ti mostrerà quel personaggio come tentativo finale.

---

## Barra di Confidenza

La barra in alto mostra quanto il Genio è sicuro della sua risposta:

| Percentuale | Significato |
|-------------|-------------|
| 0-20% | Il Genio è molto incerto, ci sono ancora molti candidati |
| 20-50% | Il Genio sta iniziando a capire chi potrebbe essere |
| 50-80% | Il Genio ha buone probabilità di indovinare |
| 80-100% | Il Genio è quasi certo, presto farà un tentativo |

### Come Funziona
La barra si riempie in base a:
- **Numero di domande fatte** (20% del calcolo)
- **Differenza di punteggio** tra i primi due candidati (80%)

---

## Fine Gioco

### 🎉 Vittoria!
Se il Genio indovina, vedrai:
```
┌─────────────────────────────────────────┐
│                                         │
│              [Genio Felice]             │
│                                         │
│         HAI VINTO!                      │
│     Sapevo che era [Nome]!              │
│                                         │
│    Sono un vero genio!                  │
│    Vuoi giocare ancora?                  │
│                                         │
│         [ Ricomincia ]                  │
│                                         │
└─────────────────────────────────────────┘
```

### 😢 Sconfitta
Se il Genio non riesce a indovinare, vedrai:
```
┌─────────────────────────────────────────┐
│                                         │
│              [Genio Triste]             │
│                                         │
│           Mi arrendo...                 │
│                                         │
│    Sei riuscito a confondermi!          │
│    Non ho abbastanza indizi             │
│    per capire a chi stavi pensando.     │
│                                         │
│         [ Ricomincia ]                  │
│                                         │
└─────────────────────────────────────────┘
```

---

## Suggerimenti

1. **Rispondi onestamente** - Le risposte false confonderanno l'algoritmo
2. **Pensa a tutti gli attributi** - Considera nazionalità, epoca, campo di studi
3. **Non arrenderti subito** - A volte il Genio ha bisogno di più domande
4. **Guarda la barra di confidenza** - Ti dice quanto il Genio è sicuro

---

## Menu di Navigazione

Dal menu ☰ puoi accedere a:
- **Home**: Torna alla schermata iniziale
- **Personaggi**: Visualizza la lista di tutti i 20 personaggi disponibili
- **Manuale Utente**: Questa guida

---

Buon divertimento con Steam Who? 🎯
