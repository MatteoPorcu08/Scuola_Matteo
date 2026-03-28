// INSERISCI QUI LA TUA CHIAVE API TRA LE VIRGOLETTE
const API_KEY = 'INSERISCI_LA_TUA_CHIAVE_QUI';

const chatBody = document.getElementById('chat-body');
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');
const darkModeToggle = document.getElementById('dark-mode-toggle');

// Carica la cronologia salvata nel browser (o crea un array vuoto se è la prima volta)
let chatHistory = JSON.parse(localStorage.getItem('chatHistory')) || [];

// Funzione per stampare i messaggi sullo schermo
function addMessage(text, sender, isMarkdown = false) {
  const div = document.createElement('div');
  div.classList.add('message', sender === 'user' ? 'user-message' : 'bot-message');
  
  const contentDiv = document.createElement('div');
  contentDiv.classList.add('message-content');
  
  if (isMarkdown && sender === 'bot') {
    contentDiv.innerHTML = marked.parse(text);
  } else {
    contentDiv.textContent = text;
  }
  
  div.appendChild(contentDiv);
  chatBody.appendChild(div);
  chatBody.scrollTop = chatBody.scrollHeight;
}

// Mostra la cronologia quando apri la pagina
function loadHistory() {
  if (chatHistory.length === 0) {
    addMessage("Ciao! Sono il tuo assistente. Come posso aiutarti oggi?", "bot");
  } else {
    chatHistory.forEach(msg => {
      addMessage(msg.text, msg.role === 'user' ? 'user' : 'bot', msg.role === 'model');
    });
  }
}

// Funzione principale per inviare e ricevere
async function sendMessage() {
  const text = userInput.value.trim();
  if (!text) return;

  // 1. Mostra il messaggio dell'utente e salvalo in memoria
  addMessage(text, 'user');
  chatHistory.push({ role: "user", text: text });
  localStorage.setItem('chatHistory', JSON.stringify(chatHistory));
  
  userInput.value = '';
  addMessage('⌛ Sto elaborando...', 'bot'); // Messaggio di attesa

  try {
    // 2. Prepara la cronologia nel formato che piace a Gemini
    const contents = chatHistory.map(msg => ({
      role: msg.role,
      parts: [{ text: msg.text }]
    }));

    // 3. Fai la chiamata API diretta a Google
    const response = await fetch(`https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=${API_KEY}`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ contents: contents })
    });

    const data = await response.json();
    
    // Rimuovi il "Sto elaborando..."
    chatBody.lastChild.remove();

    if (data.error) throw new Error(data.error.message);

    // 4. Prendi la risposta, mostrala e salvala
    const botReply = data.candidates[0].content.parts[0].text;
    addMessage(botReply, 'bot', true);
    
    chatHistory.push({ role: "model", text: botReply });
    localStorage.setItem('chatHistory', JSON.stringify(chatHistory));

  } catch (err) {
    chatBody.lastChild.remove();
    addMessage('❌ Errore di connessione. Controlla la tua API Key.', 'bot');
    console.error(err);
    // Rimuoviamo l'ultimo messaggio utente dalla memoria se la chiamata fallisce
    chatHistory.pop(); 
  }
}

// Event Listeners
sendBtn.addEventListener('click', sendMessage);
userInput.addEventListener('keydown', e => {
  if (e.key === 'Enter' && !e.shiftKey) {
    e.preventDefault();
    sendMessage();
  }
});
darkModeToggle.addEventListener('click', () => {
  document.body.classList.toggle('dark-mode');
  darkModeToggle.textContent = document.body.classList.contains('dark-mode') ? '☀️' : '🌙';
});

// Avvia!
loadHistory();