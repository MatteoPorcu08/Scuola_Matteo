import tkinter as tk
from tkinter import scrolledtext
from openai import OpenAI
import os

# 🔑 Inserisci qui la tua API Key
os.environ["OPENAI_API_KEY"] = "INSERISCI_LA_TUA_API_KEY"

client = OpenAI()

def chiedi_ai(test_input):
    risposta = client.responses.create(
        model="gpt-4.1",
        input=test_input
    )
    return risposta.output_text

def invia_domanda():
    domanda = entry.get("1.0", tk.END).strip()
    if domanda == "":
        return
    
    output_box.delete("1.0", tk.END)
    output_box.insert(tk.END, "⏳ L'AI sta pensando...\n")
    finestra.update()

    try:
        risposta = chiedi_ai(domanda)
        output_box.delete("1.0", tk.END)
        output_box.insert(tk.END, risposta)
    except Exception as e:
        output_box.delete("1.0", tk.END)
        output_box.insert(tk.END, f"Errore: {e}")

# ---------------------------
# Interfaccia grafica Tkinter
# ---------------------------

finestra = tk.Tk()
finestra.title("AI con OpenAI - GUI")
finestra.geometry("600x500")
finestra.resizable(False, False)

titolo = tk.Label(finestra, text="Assistente AI", font=("Arial", 20, "bold"))
titolo.pack(pady=10)

# Input utente
entry_label = tk.Label(finestra, text="Scrivi la tua domanda:", font=("Arial", 12))
entry_label.pack()

entry = scrolledtext.ScrolledText(finestra, height=5, width=70, font=("Arial", 11))
entry.pack(pady=5)

# Pulsante invio
btn = tk.Button(finestra, text="Invia", font=("Arial", 12), bg="#4CAF50", fg="white", command=invia_domanda)
btn.pack(pady=10)

# Output AI
output_label = tk.Label(finestra, text="Risposta dell'AI:", font=("Arial", 12))
output_label.pack()

output_box = scrolledtext.ScrolledText(finestra, height=12, width=70, font=("Arial", 11))
output_box.pack(pady=5)

# Avvia la finestra
finestra.mainloop()
