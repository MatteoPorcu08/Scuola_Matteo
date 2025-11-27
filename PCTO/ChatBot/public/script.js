const chatBody = document.getElementById('chat-body');
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');
const darkModeToggle = document.getElementById('dark-mode-toggle');

function addMessage(message,sender){
  const div = document.createElement('div');
  div.classList.add('message',sender==='user'?'user-message':'bot-message');
  const p = document.createElement('p');
  p.textContent = message;
  div.appendChild(p);
  chatBody.appendChild(div);
  chatBody.scrollTop = chatBody.scrollHeight;
}

async function sendMessage(){
  const msg = userInput.value.trim();
  if(!msg) return;
  addMessage(msg,'user');
  userInput.value='';
  addMessage('⌛ Sto pensando...','bot');

  try{
    const res = await fetch('/chat',{
      method:'POST',
      headers:{'Content-Type':'application/json'},
      body: JSON.stringify({message: msg})
    });
    const data = await res.json();
    chatBody.lastChild.remove();
    addMessage(data.reply,'bot');
  }catch(err){
    chatBody.lastChild.remove();
    addMessage('Errore server. Riprova.','bot');
  }
}

sendBtn.addEventListener('click',sendMessage);
userInput.addEventListener('keypress',e=>{if(e.key==='Enter')sendMessage();});
darkModeToggle.addEventListener('click',()=>document.body.classList.toggle('dark-mode'));