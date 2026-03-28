// --- NUOVO CODICE PER IL DATABASE ---

// Funzione per caricare la cronologia all'avvio
async function loadHistory() {
  try {
    const res = await fetch('/history');
    const messages = await res.json();
    
    // Se ci sono messaggi nel DB, svuota il messaggio di benvenuto e caricali
    if (messages.length > 0) {
      chatBody.innerHTML = ''; // Pulisce la chat
      
      messages.forEach(msg => {
        // Usa isMarkdown = true solo per il bot
        const isBot = msg.sender === 'bot';
        addMessage(msg.text, msg.sender, isBot);
      });
    }
  } catch (err) {
    console.error("Errore nel caricamento della cronologia:", err);
  }
}

// Esegui la funzione appena la pagina ha finito di caricarsi
window.addEventListener('DOMContentLoaded', loadHistory);