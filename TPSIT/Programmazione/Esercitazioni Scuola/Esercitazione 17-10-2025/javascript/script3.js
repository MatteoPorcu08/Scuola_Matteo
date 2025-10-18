function calcola() {
  const copiesStr = document.getElementById("copiesInput").value;
  const costStr = document.getElementById("costInput").value;
  const scontoStr = document.getElementById("scontoInput").value;

  // Conversione semplice da stringa a numero
  const copies = parseFloat(copiesStr);
  const cost = parseFloat(costStr);

  // Calcolo importo totale
  const importo = copies * cost;
  alert(`Importo da pagare: ${importo.toFixed(2)} euro`);

  // Chiede lo sconto via prompt e mostra il nuovo importo
  const sconto = parseFloat(scontoStr);

  const nuovoImporto = importo * (1 - sconto / 100);
  alert(`Con il ${sconto}% di sconto dovrai pagare ${nuovoImporto.toFixed(2)} euro`);
}
