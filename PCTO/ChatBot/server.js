import express from 'express';
import dotenv from 'dotenv';
import fetch from 'node-fetch'; // per Node <18; se Node >=18 puoi usare fetch nativo
dotenv.config();

const app = express();
app.use(express.json());
app.use(express.static('public'));

const GEMINI_API_KEY = process.env.GEMINI_API_KEY;

app.post('/chat', async (req, res) => {
  const { message } = req.body;
  if (!message) return res.status(400).json({ error: 'Messaggio mancante' });

  try {
    const response = await fetch(
      'https://generativelanguage.googleapis.com/v1beta2/models/text-bison-001:generate',
      {
        method: 'POST',
        headers: {
          'Authorization': `Bearer ${GEMINI_API_KEY}`,
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          prompt: { text: message },
          temperature: 0.7,
          candidateCount: 1,
          maxOutputTokens: 300
        }),
      }
    );

    if (!response.ok) {
      const text = await response.text();
      console.error("Errore API Gemini:", text);
      return res.status(response.status).json({ error: "Errore API Gemini", details: text });
    }

    const data = await response.json();
    const botMessage = data.candidates?.[0]?.content?.[0]?.text || "Mi dispiace, non ho capito.";
    res.json({ reply: botMessage });

  } catch (err) {
    console.error("Errore server:", err);
    res.status(500).json({ error: 'Errore server', details: err.message });
  }
});

app.listen(3000, () => console.log('Server avviato su http://localhost:3000'));