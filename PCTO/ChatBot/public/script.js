// server.js
import express from 'express';
import dotenv from 'dotenv';
import { GoogleGenerativeAI } from '@google/generative-ai';

dotenv.config();

const app = express();
app.use(express.json());
app.use(express.static('public')); // Assicurati che HTML/CSS/JS siano nella cartella 'public'

// Inizializza l'SDK di Gemini
const genAI = new GoogleGenerativeAI(process.env.GEMINI_API_KEY);

// Variabile per memorizzare la sessione di chat (la "memoria")
let chatSession = null;

app.post('/chat', async (req, res) => {
  const { message } = req.body;
  if (!message) return res.status(400).json({ error: 'Messaggio mancante' });

  try {
    // Se la chat non esiste, inizializzala usando il modello più veloce e intelligente
    if (!chatSession) {
      const model = genAI.getGenerativeModel({ model: "gemini-1.5-flash" });
      chatSession = model.startChat({
        history: [], // Qui puoi inserire messaggi di sistema se vuoi dargli un "ruolo"
        generationConfig: {
          temperature: 0.7,
        },
      });
    }

    // Invia il messaggio alla sessione che ha memoria
    const result = await chatSession.sendMessage(message);
    const botMessage = result.response.text();
    
    res.json({ reply: botMessage });

  } catch (err) {
    console.error("Errore server:", err);
    res.status(500).json({ error: 'Errore server', details: err.message });
  }
});

app.listen(3000, () => console.log('🚀 Server avviato su http://localhost:3000'));