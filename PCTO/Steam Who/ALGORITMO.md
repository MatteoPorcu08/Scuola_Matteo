# Documentazione Algoritmo - Steam Who?

## Indice
1. [Panoramica](#panoramica)
2. [Struttura Dati](#struttura-dati)
3. [Entropia di Shannon](#entropia-di-shannon)
4. [Sistema di Punteggio](#sistema-di-punteggio)
5. [Flusso di Gioco](#flusso-di-gioco)
6. [Domande Bonus (Killer Questions)](#domande-bonus-killer-questions)
7. [Gestione Vittoria/Sconfitta](#gestione-vittoriasconfitta)

---

## Panoramica

Steam Who? è un gioco ispirato ad Akinator che cerca di indovinare un personaggio storico scientifico basandosi su 40 domande a cui l'utente risponde con Sì o No. Il gioco utilizza l'**entropia di Shannon** per selezionare la domanda ottimale in ogni momento.

---

## Struttura Dati

### Database Personaggi (`characters`)
```javascript
{
    nome: "Nome Completo",
    img: "percorso/immagine.png",
    donna: true/false,
    italiano: true/false,
    informatico: true/false,
    fisico: true/false,
    antico: true/false,
    nobel: true/false,
    matematica: true/false,
    // ... 40+ attributi totali
    domanda_bonus: "Testo della domanda unica per questo personaggio"
}
```

Il database contiene **20 personaggi** della storia della scienza, tecnologia e matematica.

### Database Domande (`questions`)
```javascript
{
    testo: "Testo della domanda",
    key: "nome_attributo"  // riferimento all'attributo nel personaggio
}
```

Sono presenti **40 domande** che coprono vari aspetti: genere, nazionalità, campo scientifico, epoca, vita personale, contributi specifici.

---

## Entropia di Shannon

### Concetto Matematico
L'entropia di Shannon misura l'incertezza informativa. Più alta è l'entropia, più "equilibrata" è la divisione tra Sì e No.

### Formula
```
H = -[p_yes × log2(p_yes) + p_no × log2(p_no)]
```

Dove:
- `p_yes` = percentuale di personaggi che risponderebbero "Sì"
- `p_no` = percentuale di personaggi che risponderebbero "No"

### Implementazione JavaScript
```javascript
function shannonEntropy(yesCount, noCount) {
    let total = yesCount + noCount;
    if (total === 0) return 0;
    let pYes = yesCount / total;
    let pNo = noCount / total;
    if (pYes === 0 || pNo === 0) return 0;
    return -(pYes * Math.log2(pYes) + pNo * Math.log2(pNo));
}
```

### Selezione Domanda Migliore
```javascript
questions.forEach(q => {
    if (usedQuestions.includes(q)) return;
    let yesCount = 0, noCount = 0;
    let topCandidates = available.slice(0, 8); // Considera solo i top 8
    topCandidates.forEach(p => {
        if (p[q.key]) yesCount++;
        else noCount++;
    });
    let entropy = shannonEntropy(yesCount, noCount);
    if (entropy > bestEntropy) {
        bestEntropy = entropy;
        best = q;
    }
});
```

**Nota**: Si considerano solo gli 8 personaggi con punteggio più alto per calcolare l'entropia, rendendo le domande più mirate.

---

## Sistema di Punteggio

### Assegnazione Punteggi
```javascript
if (p[currentQuestion.key] === answer) {
    p.score += 6;  // Risposta corretta: +6 punti
} else {
    p.score -= 4;  // Risposta errata: -4 punti
}
```

### Calcolo Confidenza
```javascript
let confidence = sorted[0].score - sorted[1].score;
let basePercent = (usedQuestions.length / MIN_QUESTIONS_BEFORE_GUESS) * 20;
let scorePercent = (confidence / CONFIDENCE_THRESHOLD) * 80;
let percent = Math.min(98, Math.max(2, basePercent + scorePercent));
```

La barra di confidenza combina:
- Numero di domande fatte (20% del peso)
- Differenza punteggio tra primo e secondo classificato (80% del peso)

### Costanti Configurabili
```javascript
const MIN_QUESTIONS_BEFORE_GUESS = 5;  // Minimo domande prima di tentare
const CONFIDENCE_THRESHOLD = 15;       // Soglia punteggio per azzardare
```

---

## Flusso di Gioco

```
┌─────────────────────────────────────────────────────────┐
│                    START GAME                           │
│  - Reset punteggi a 0                                   │
│  - Reset domande usate                                  │
│  - Reset personaggi indovinati                          │
└─────────────────────┬───────────────────────────────────┘
                      ▼
┌─────────────────────────────────────────────────────────┐
│                  NEXT QUESTION                          │
│                                                         │
│  1. Calcola personaggi disponibili                      │
│  2. Se 0 personaggi → surrender()                      │
│  3. Se 1 personaggio → showGuess()                     │
│  4. Calcola differenza punteggio top 2                 │
│  5. Controlla domanda bonus (killer question)           │
│  6. Controlla soglia confidenza                        │
│  7. Cerca domanda con entropia massima                 │
│  8. Se no domande utili → showGuess() o surrender()    │
└─────────────────────┬───────────────────────────────────┘
                      ▼
┌─────────────────────────────────────────────────────────┐
│                    MOVE(answer)                         │
│                                                         │
│  - Se domanda bonus: controlla se risposta = Sì         │
│    → Sì: mostra personaggio                             │
│    → No: escludi personaggio, continua                  │
│                                                         │
│  - Se domanda normale:                                   │
│    → Aggiorna punteggi (+6/-4)                         │
│    → Controlla confidenza                               │
│    → Vai a nextQuestion()                               │
└─────────────────────┬───────────────────────────────────┘
                      ▼
┌─────────────────────────────────────────────────────────┐
│                   SHOW GUESS                            │
│                                                         │
│  - Mostra personaggio con punteggio più alto            │
│  - Utente sceglie SÌ o NO                              │
│                                                         │
│  Se SÌ: → Vittoria! (genio felice)                     │
│  Se NO:  → Escludi personaggio                          │
│           → Riduci punteggio di tutti (-2)              │
│           → Torna a nextQuestion()                      │
└─────────────────────────────────────────────────────────┘
```

---

## Domande Bonus (Killer Questions)

### Concetto
Ogni personaggio ha una domanda unica che solo lui può soddisfare (es. "Hai scoperto il Radio?" per Marie Curie).

### Attivazione
```javascript
let scoreDiff = available[0].score - available[1].score;

if (scoreDiff >= 8 && Math.random() > 0.5 && !topChar.bonusAsked && usedQuestions.length >= 3) {
    topChar.bonusAsked = true;
    currentQuestion = { 
        testo: topChar.domanda_bonus, 
        isBonusFor: topChar.nome 
    };
}
```

**Condizioni per attivare**:
1. Differenza punteggio ≥ 8
2. Casualità (> 50% di possibilità)
3. Domanda bonus non ancora chiesta
4. Almeno 3 domande già fatte

### Gestione Risposta
```javascript
if (currentQuestion.isBonusFor) {
    if (answer === true) {
        showGuess(winner);  // Ha risposto Sì → probabilmente è lui!
    } else {
        guessedCharacters.push(currentQuestion.isBonusFor);  // Escludi
        nextQuestion();  // Continua con altri
    }
}
```

---

## Gestione Vittoria/Sconfitta

### Vittoria
```javascript
document.getElementById("correctBtn").onclick = () => {
    gameGenio.src = "../img/genioFelice.png";
    result.innerHTML = `<h2>HAI VINTO! Sapevo che era ${best.nome}!</h2>`;
    confidenceBar.style.width = "100%";
    restartBtn.style.display = "inline-block";
};
```

### Sconfitta (Non era il personaggio)
```javascript
document.getElementById("wrongBtn").onclick = () => {
    guessedCharacters.push(best.nome);  // Escludi il personaggio
    characters.forEach(p => p.score -= 2);  // Penalizza tutti
    nextQuestion();  // Prova con un altro
};
```

### Resa (Non ci sono più opzioni)
```javascript
function surrender() {
    gameGenio.src = "../img/genioTriste.png";
    question.innerText = "Mi arrendo...";
    result.innerHTML = "<h3>Sei riuscito a confondermi!</h3>";
    restartBtn.style.display = "inline-block";
}
```

---

## Riepilogo Costanti

| Costante | Valore | Descrizione |
|----------|--------|------------|
| `MIN_QUESTIONS_BEFORE_GUESS` | 5 | Domande minime prima di tentare |
| `CONFIDENCE_THRESHOLD` | 15 | Differenza punteggio per azzardare |
| Bonus Score | +6 | Punti per risposta corretta |
| Penalty Score | -4 | Punti per risposta errata |
| Guess Penalty | -2 | Penalità dopo guess sbagliato |
| Bonus Threshold | 8 | Differenza per attivare domanda bonus |

---

## Ottimizzazioni Algoritmo

1. **Top 8 Candidates**: Calcola l'entropia solo sui primi 8 personaggi per domande più mirate

2. **Entropy Zero Guard**: Se tutte le domande hanno entropia 0, il gioco tenta comunque se c'è un minimo di differenza punteggio

3. **Bonus Question Randomization**: La casualità nella domanda bonus evita prevedibilità

4. **Score Normalization**: Penalità progressive (-2 a tutti dopo guess sbagliato) per "resettare" la graduatoria
