import express from 'express';
import dotenv from 'dotenv';
import { GoogleGenerativeAI } from '@google/generative-ai';
import sqlite3 from 'sqlite3';

dotenv.config();

const app = express();
app.use(express.json());
app.use(express.static('public'));

// 1. Inizializza il Database SQLite
const sql = sqlite3.verbose();
const db = new sql.Database('./chat.db', (err) => {
  if (err) console.error("Errore DB:", err.message);
  else console.log("💾 Connesso al database SQLite (chat.db)");
});

// Crea la tabella per salvare i messaggi (se non esiste già)
db.run(`CREATE TABLE IF NOT EXISTS messages (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  sender TEXT,
  text TEXT,
  timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
)`);

// 2. Inizializza Gemini
const genAI = new GoogleGenerativeAI(process.env.GEMINI_API_KEY);
let chatSession = null;

// 3. Nuova Rotta: Recupera la cronologia quando apri il sito
app.get('/history', (req, res) => {
  db.all("SELECT * FROM messages ORDER BY id ASC", [], (err, rows) => {
    if (err) return res.status(500).json({ error: err.message });
    res.json(rows);
  });
});

// 4. Rotta Chat: Parla con Gemini e salva nel DB
app.post('/chat', async (req, res) => {
  const { message } = req.body;
  if (!message) return res.status(400).json({ error: 'Messaggio mancante' });

  // Salva il messaggio dell'utente nel database
  db.run("INSERT INTO messages (sender, text) VALUES (?, ?)", ['user', message]);

  try {
    if (!chatSession) {
      const model = genAI.getGenerativeModel({ model: "gemini-1.5-flash" });
      chatSession = model.startChat({
        history: [], 
        generationConfig: { temperature: 0.7 },
      });
    }

    // Chiedi a Gemini
    const result = await chatSession.sendMessage(message);
    const botMessage = result.response.text();
    
    // Salva la risposta del bot nel database
    db.run("INSERT INTO messages (sender, text) VALUES (?, ?)", ['bot', botMessage]);

    res.json({ reply: botMessage });

  } catch (err) {
    console.error("Errore server:", err);
    res.status(500).json({ error: 'Errore server', details: err.message });
  }
});

app.listen(3000, () => console.log('🚀 Server avviato su http://localhost:3000'));