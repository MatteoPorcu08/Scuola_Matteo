import tkinter as tk
from tkinter import ttk, scrolledtext

# ---------------- GENERATORE CODICE ----------------

def genera_codice():
    class_name = entry_class.get().strip()
    raw_vars = text_vars.get("1.0", tk.END).strip().split("\n")

    variables = []
    for line in raw_vars:
        if ":" in line:
            name, typ = line.split(":")
            variables.append((name.strip(), typ.strip()))

    code = f"public class {class_name} {{\n\n"
    for name, typ in variables:
        code += f"    private {typ} {name};\n"
    code += "\n"

    code += f"    public {class_name}(" + ", ".join([f"{typ} {name}" for name, typ in variables]) + ") {{\n"
    for name, typ in variables:
        code += f"        this.{name} = {name};\n"
    code += "    }\n\n"

    code += f"    public {class_name}({class_name} other) {{\n"
    for name, typ in variables:
        code += f"        this.{name} = other.get{name.capitalize()}();\n"
    code += "    }\n\n"

    for name, typ in variables:
        code += f"    public {typ} get{name.capitalize()}() {{\n"
        code += f"        return this.{name};\n"
    code += "    }\n\n"

    for name, typ in variables:
        code += f"    public void set{name.capitalize()}({typ} {name}) {{\n"
        code += f"        this.{name} = {name};\n"
    code += "    }\n\n"

    code += "    @Override\n    public String toString() {\n"
    code += '        return "' + class_name + ' {" +\n'
    for i, (name, typ) in enumerate(variables):
        sep = '"' if i == len(variables)-1 else '", " +'
        code += f'            " {name}=" + {name} + {sep}\n'
    code += '        "}";\n'
    code += "    }\n\n"
    code += "}\n"

    text_output.delete("1.0", tk.END)
    text_output.insert(tk.END, code)

# ---------------- UI ----------------

root = tk.Tk()
root.title("Assistente per la Creazione di Classi Java")
root.geometry("980x720")
root.configure(bg="#1e1e1e")

# Icona: metti un file java.ico nella stessa cartella dello script
try:
    root.iconbitmap("../Python/java.ico")
except:
    pass  # se non c'è, va avanti lo stesso

# Stile ttk
style = ttk.Style(root)
style.theme_use("clam")  # tema base per personalizzare

style.configure("TLabel", background="#1e1e1e", foreground="white", font=("Segoe UI", 12))
style.configure("TButton", background="#4CAF50", foreground="white", font=("Segoe UI", 11), padding=6)
style.map("TButton", background=[("active", "#45a049")])
style.configure("TEntry", fieldbackground="#2d2d2d", foreground="white")
style.configure("TFrame", background="#1e1e1e")

# Titolo
title = ttk.Label(root, text="Assistente per la Creazione di Classi Java", font=("Segoe UI", 22, "bold"))
title.pack(pady=15)

# Frame principale
frame = ttk.Frame(root)
frame.pack(pady=10)

# Nome classe
lbl_class = ttk.Label(frame, text="Nome della Classe:")
lbl_class.grid(row=0, column=0, sticky="w", pady=5)
entry_class = ttk.Entry(frame, width=40)
entry_class.grid(row=0, column=1, pady=5)

# Variabili
lbl_vars = ttk.Label(frame, text="Variabili (es: prezzo : double):")
lbl_vars.grid(row=1, column=0, sticky="nw", pady=5)
text_vars = scrolledtext.ScrolledText(frame, width=40, height=10, bg="#2d2d2d", fg="white", insertbackground="white")
text_vars.grid(row=1, column=1, pady=5)

# Bottone genera codice
btn = ttk.Button(root, text="Genera Codice", command=genera_codice)
btn.pack(pady=15)

# Output
lbl_output = ttk.Label(root, text="Codice Generato:")
lbl_output.pack()
text_output = scrolledtext.ScrolledText(root, width=110, height=22, bg="#2d2d2d", fg="white", insertbackground="white")
text_output.pack(pady=10)

root.mainloop()