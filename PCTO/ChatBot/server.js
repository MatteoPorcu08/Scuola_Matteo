// script.js
const chatBody = document.getElementById('chat-body');
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');
const darkModeToggle = document.getElementById('dark-mode-toggle');

// Autoresize della textarea
userInput.addEventListener('input', function() {
  this.style.height = 'auto';
  this.style.height = (this.scrollHeight) + 'px';
  if(this.value === '') this.style.height = 'auto';
});

function addMessage(message, sender, isMarkdown = false) {
  const div = document.createElement('div');
  div.classList.add('message', sender === 'user' ? 'user-message' : 'bot-message');
  
  const contentDiv = document.createElement('div');
  contentDiv.classList.add('message-content');
  
  // Se è il bot, converto il markdown in HTML. Se è l'utente o il loading, uso testo normale.
  if (isMarkdown && sender === 'bot') {
    contentDiv.innerHTML = marked.parse(message);
  } else {
    const p = document.createElement('p');
    p.textContent = message;
    contentDiv.appendChild(p);
  }
  
  div.appendChild(contentDiv);
  chatBody.appendChild(div);
  chatBody.scrollTop = chatBody.scrollHeight;
}

async function sendMessage() {
  const msg = userInput.value.trim();
  if (!msg) return;
  
  addMessage(msg, 'user');
  userInput.value = '';
  userInput.style.height = 'auto'; // reset textarea
  
  addMessage('⌛ Sto elaborando...', 'bot');

  try {
    const res = await fetch('/chat', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ message: msg })
    });
    
    const data = await res.json();
    
    // Rimuovi il messaggio di caricamento
    chatBody.lastChild.remove();
    
    // Mostra la risposta reale renderizzando il Markdown
    addMessage(data.reply, 'bot', true);
  } catch (err) {
    chatBody.lastChild.remove();
    addMessage('Errore di connessione al server.', 'bot');
  }
}

sendBtn.addEventListener('click', sendMessage);

userInput.addEventListener('keydown', e => {
  if (e.key === 'Enter' && !e.shiftKey) {
    e.preventDefault(); // Evita l'accapo se premi solo Invio
    sendMessage();
  }
});

darkModeToggle.addEventListener('click', () => {
  document.body.classList.toggle('dark-mode');
  const isDark = document.body.classList.contains('dark-mode');
  darkModeToggle.textContent = isDark ? '☀️' : '🌙';
});