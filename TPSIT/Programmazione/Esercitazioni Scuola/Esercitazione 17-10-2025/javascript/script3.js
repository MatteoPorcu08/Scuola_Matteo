function calcola() {
  const copiesStr = document.getElementById("copiesInput").value;
  const costStr = document.getElementById("costInput").value;

  const copies = parseFloat(copiesStr);
  const cost = parseFloat(costStr);

  const importo = copies * cost;
  alert(`Importo da pagare: ${importo.toFixed(2)} euro`);

  const scontoStr = prompt("Inserisci lo sconto percentuale da applicare (es. 5):");
  const sconto = parseFloat(scontoStr);

  const nuovoImporto = importo * (1 - sconto / 100);
  alert(`Con il ${sconto}% di sconto dovrai pagare ${nuovoImporto.toFixed(2)} euro`);
}
