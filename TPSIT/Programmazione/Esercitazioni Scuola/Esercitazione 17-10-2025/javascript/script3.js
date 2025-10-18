function calcola() {
  const copiesStr = document.getElementById("copiesInput").value;
  const costStr = document.getElementById("costInput").value;
  const scontoStr = document.getElementById("discountInput").value; // id corretto

  // Conversione semplice da stringa a numero
  const copies = parseFloat(copiesStr);
  const cost = parseFloat(costStr);
  const sconto = parseFloat(scontoStr);

  // Calcolo importo totale
  const importo = copies * cost;
  alert(`Importo da pagare: ${importo.toFixed(2)} euro`);

  // Applica sconto e mostra nuovo importo
  const nuovoImporto = importo * (1 - sconto / 100);
  alert(`Con il ${sconto}% di sconto dovrai pagare ${nuovoImporto.toFixed(2)} euro`);
}
