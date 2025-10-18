function calcolaVelocita() {
    const spazioStr = prompt("Inserisci lo spazio percorso in metri:");
    const tempoStr = prompt("Inserisci il tempo impiegato in secondi:");

    const spazio = parseFloat((spazioStr || "").replace(",", ".").trim());
    const tempo = parseFloat((tempoStr || "").replace(",", ".").trim());

    // Controlli essenziali
    if (isNaN(spazio) || isNaN(tempo) || tempo <= 0) {
      alert("Valori non validi. Inserisci numeri e un tempo maggiore di 0.");
      return;
    }

    const v = spazio / tempo; // m/s
    alert(`Per uno spazio di ${spazio} metri e un tempo di ${tempo} secondi, la velocità è ${v.toFixed(2)} m/s.`);
  }