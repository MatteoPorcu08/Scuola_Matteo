import tkinter as tk
from tkinter import ttk, scrolledtext

# ======================================================
#                     FUNZIONI
# ======================================================

def genera_codice():
    class_name = entry_class.get().strip()
    raw_vars = text_vars.get("1.0", tk.END).strip().split("\n")
    
    if not class_name or not raw_vars[0]:
        lbl_status.config(text="⚠ Inserisci il nome e almeno una variabile!", foreground="#f44336")
        return

    variables = []
    for line in raw_vars:
        if ":" in line:
            name, typ = line.split(":")
            variables.append((name.strip(), typ.strip()))

    # Costruzione codice
    code = ""
    code += f"public class {class_name} {{\n\n"
    code += "    //Attributi\n"
    for name, typ in variables:
        code += f"    private {typ} {name};\n"
    code += "\n"
    code += "    //Costruttore Principale\n"
    code += f"    public {class_name}(" + ", ".join([f"{typ} {name}" for name, typ in variables]) + ") {{\n"
    for name, typ in variables:
        code += f"        this.{name} = {name};\n"
    code += "    }\n\n"
    code += "    //Costruttore di Copia\n"
    code += f"    public {class_name}({class_name} other) {{\n"
    for name, typ in variables:
        code += f"        this.{name} = other.get{name.capitalize()}();\n"
    code += "    }\n\n"
    code += "    //Getter\n"
    for name, typ in variables:
        code += f"    public {typ} get{name.capitalize()}() {{\n"
        code += f"        return this.{name};\n"
        code += "    }\n\n"
    code += "    //Setter\n"
    for name, typ in variables:
        code += f"    public void set{name.capitalize()}({typ} {name}) {{\n"
        code += f"        this.{name} = {name};\n"
        code += "    }\n\n"
    code += "    //toString\n"
    code += "    @Override\n"
    code += "    public String toString() {\n"
    code += f'        return "{class_name} {{" +\n'
    for i, (name, typ) in enumerate(variables):
        sep = '"' if i == len(variables)-1 else '" +\n'
        code += f'            " {name}=" + {name} + {sep}\n'
    code += "        \"}\";\n"
    code += "    }\n\n"
    code += "}\n"

    # Pulizia output precedente
    text_output.delete("1.0", tk.END)
    progress['value'] = 0

    # Avvia animazioni
    animate_code(code)
    animate_progress()

def animate_code(code, index=0):
    """Scrive il codice nel text widget carattere per carattere"""
    if index < len(code):
        text_output.insert(tk.END, code[index])
        text_output.see(tk.END)
        root.after(2, lambda: animate_code(code, index + 1))
    else:
        lbl_status.config(text="✔ Codice generato!", foreground="#4CAF50")
        root.after(2500, lambda: lbl_status.config(text=""))

def animate_progress(current=0):
    """Aggiorna la barra di progresso in modo fluido"""
    if current <= 100:
        progress['value'] = current
        root.after(10, lambda: animate_progress(current + 1))

def copia_codice():
    root.clipboard_clear()
    root.clipboard_append(text_output.get("1.0", tk.END))
    lbl_status.config(text="✔ Codice copiato!", foreground="#2196F3")
    root.after(2500, lambda: lbl_status.config(text=""))

def pulisci_tutto():
    entry_class.delete(0, tk.END)
    text_vars.delete("1.0", tk.END)
    text_output.delete("1.0", tk.END)
    lbl_status.config(text="")
    progress['value'] = 0

# ======================================================
#                  ANIMAZIONI PULSANTI
# ======================================================
def on_enter(e, btn):
    btn.configure(background="#ff9800")

def on_leave(e, btn, color):
    btn.configure(background=color)

# ======================================================
#                        UI
# ======================================================
root = tk.Tk()
root.title("Generatore Professionale di Classi Java")
root.geometry("1000x700")
root.configure(bg="#1e1e1e")

# Icona
try:
    root.iconbitmap("../Python/java.ico")
except:
    print("Icona java.ico non trovata.")

# Stili generali
style = ttk.Style(root)
style.theme_use("clam")
style.configure("TLabel", background="#1e1e1e", foreground="white", font=("Segoe UI", 12))
style.configure("TFrame", background="#1e1e1e")
style.configure("TEntry", fieldbackground="#2d2d2d", foreground="white")

# Titolo
title = ttk.Label(root, text="Generatore Professionale di Classi Java", font=("Segoe UI", 24, "bold"))
title.pack(pady=15)

# Frame principale
frame = ttk.Frame(root)
frame.pack(pady=10)

# Input classe
lbl_class = ttk.Label(frame, text="Nome della Classe:")
lbl_class.grid(row=0, column=0, sticky="w", pady=5)
entry_class = ttk.Entry(frame, width=40)
entry_class.grid(row=0, column=1, pady=5)

# Input variabili
lbl_vars = ttk.Label(frame, text="Variabili (es: prezzo : double):")
lbl_vars.grid(row=1, column=0, sticky="nw", pady=5)
text_vars = scrolledtext.ScrolledText(frame, width=40, height=10, bg="#2d2d2d", fg="white", insertbackground="white")
text_vars.grid(row=1, column=1, pady=5)

# Pulsanti
btn_generate = tk.Button(root, text="Genera Codice", command=genera_codice, bg="#4CAF50", fg="white", font=("Segoe UI", 11, "bold"), relief="flat")
btn_generate.pack(pady=5)
btn_generate.bind("<Enter>", lambda e: on_enter(e, btn_generate))
btn_generate.bind("<Leave>", lambda e: on_leave(e, btn_generate, "#4CAF50"))

btn_copy = tk.Button(root, text="Copia negli Appunti", command=copia_codice, bg="#2196F3", fg="white", font=("Segoe UI", 11, "bold"), relief="flat")
btn_copy.pack(pady=5)
btn_copy.bind("<Enter>", lambda e: on_enter(e, btn_copy))
btn_copy.bind("<Leave>", lambda e: on_leave(e, btn_copy, "#2196F3"))

btn_clear = tk.Button(root, text="Pulisci tutto", command=pulisci_tutto, bg="#f44336", fg="white", font=("Segoe UI", 11, "bold"), relief="flat")
btn_clear.pack(pady=5)
btn_clear.bind("<Enter>", lambda e: on_enter(e, btn_clear))
btn_clear.bind("<Leave>", lambda e: on_leave(e, btn_clear, "#f44336"))

# Barra di progresso
progress = ttk.Progressbar(root, orient="horizontal", length=500, mode="determinate")
progress.pack(pady=10)

# Messaggi di stato
lbl_status = ttk.Label(root, text="", font=("Segoe UI", 12))
lbl_status.pack()

# Output codice
lbl_output = ttk.Label(root, text="Codice Generato:")
lbl_output.pack()
text_output = scrolledtext.ScrolledText(root, width=110, height=22, bg="#2d2d2d", fg="white", insertbackground="white")
text_output.pack(pady=10)

root.mainloop()