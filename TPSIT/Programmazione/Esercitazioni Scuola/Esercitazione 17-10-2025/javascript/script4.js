function calcolaVelocita() {
  // 1) Leggi i valori dagli input HTML
  const spazioStr = document.getElementById("spaceInput").value;
  const tempoStr = document.getElementById("timeInput").value;

  // 2) Converti in numeri
  const spazio = parseFloat(spazioStr);
  const tempo = parseFloat(tempoStr);

  // 3) Esegui solo i calcoli
  const v = spazio / tempo;

  // 4) Mostra il risultato con alert
  alert(`Per uno spazio di ${spazio} metri e un tempo di ${tempo} secondi, la velocità è ${v.toFixed(2)} m/s.`);
}
