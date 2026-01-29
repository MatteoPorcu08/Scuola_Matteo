import tkinter as tk
from tkinter import ttk, scrolledtext

# ======================================================
#                     FUNZIONI
# ======================================================

def genera_codice():
    class_name = entry_class.get().strip()
    raw_vars = text_vars.get("1.0", tk.END).strip().split("\n")
    use_array = array_var.get()

    if not class_name or not raw_vars[0]:
        lbl_status.config(text="⚠ Inserisci il nome e almeno una variabile!", foreground="#f44336")
        return

    variables = []
    for line in raw_vars:
        if ":" in line:
            name, typ = line.split(":")
            name = name.strip()
            typ = typ.strip()
            if use_array:
                typ += "[]"
            variables.append((name, typ))

    # ==================================================
    #           GENERAZIONE CODICE JAVA
    # ==================================================

    code = f"/**\n"
    code += f" * Classe {class_name}\n"
    code += f" * Generata automaticamente.\n"
    code += f" */\n"
    code += f"public class {class_name} {{\n\n"

    # Attributi
    for name, typ in variables:
        code += f"    /**\n"
        code += f"     * {name.capitalize()} della classe\n"
        code += f"     */\n"
        code += f"    private {typ} {name};\n\n"

    # Costruttore principale
    code += f"    /**\n"
    code += f"     * Costruttore principale\n"
    for name, typ in variables:
        code += f"     * @param {name} valore di {name}\n"
    code += f"     */\n"
    code += f"    public {class_name}(" + ", ".join([f"{typ} {name}" for name, typ in variables]) + ") {{\n"
    for name, _ in variables:
        code += f"        this.{name} = {name};\n"
    code += "    }\n\n"

    # Costruttore di copia
    code += f"    /**\n"
    code += f"     * Costruttore di copia\n"
    code += f"     * @param other oggetto da copiare\n"
    code += f"     */\n"
    code += f"    public {class_name}({class_name} other) {{\n"
    for name, _ in variables:
        code += f"        this.{name} = other.get{name.capitalize()}();\n"
    code += "    }\n\n"

    # Getter e Setter
    for name, typ in variables:
        # Getter
        code += f"    /**\n"
        code += f"     * Restituisce {name}\n"
        code += f"     * @return {name}\n"
        code += f"     */\n"
        code += f"    public {typ} get{name.capitalize()}() {{\n"
        code += f"        return {name};\n"
        code += f"    }}\n\n"

        # Setter
        code += f"    /**\n"
        code += f"     * Imposta {name}\n"
        code += f"     * @param {name} nuovo valore\n"
        code += f"     */\n"
        code += f"    public void set{name.capitalize()}({typ} {name}) {{\n"
        code += f"        this.{name} = {name};\n"
        code += f"    }}\n\n"

    # toString
    code += "    /**\n"
    code += "     * Rappresentazione testuale dell'oggetto\n"
    code += "     * @return stringa descrittiva\n"
    code += "     */\n"
    code += "    @Override\n"
    code += "    public String toString() {\n"
    code += "        return \n"

    for i, (name, _) in enumerate(variables):
        prefix = '"\\n" + ' if i > 0 else ""
        code += f"            {prefix}\"{name.capitalize()}=\" + {name}"
        if i < len(variables) - 1:
            code += " +\n"
        else:
            code += ";\n"
    code += "    }\n"

    code += "}\n"

    text_output.delete("1.0", tk.END)
    animate_code(code)
    progress['value'] = 0
    animate_progress()


def animate_code(code, index=0):
    if index < len(code):
        text_output.insert(tk.END, code[index])
        text_output.see(tk.END)
        root.after(1, lambda: animate_code(code, index + 1))
    else:
        lbl_status.config(text="✔ Codice generato!", foreground="#4CAF50")
        root.after(2500, lambda: lbl_status.config(text=""))


def animate_progress(current=0):
    if current <= 100:
        progress['value'] = current
        root.after(5, lambda: animate_progress(current + 1))


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
#                        UI
# ======================================================

root = tk.Tk()
root.title("Generatore Professionale Classi Java")
root.geometry("1100x800")
root.configure(bg="#1e1e1e")

style = ttk.Style(root)
style.theme_use("clam")
style.configure("TLabel", background="#1e1e1e", foreground="white", font=("Segoe UI", 12))
style.configure("TFrame", background="#1e1e1e")

title = ttk.Label(root, text="Generatore Professionale di Classi Java",
                  font=("Segoe UI", 26, "bold"))
title.pack(pady=15)

frame = ttk.Frame(root)
frame.pack(pady=10)

ttk.Label(frame, text="Nome Classe:").grid(row=0, column=0, sticky="w", padx=10)
entry_class = ttk.Entry(frame, width=40)
entry_class.grid(row=0, column=1)

ttk.Label(frame, text="Variabili (es: nome : String)").grid(row=1, column=0, sticky="nw", padx=10)
text_vars = scrolledtext.ScrolledText(frame, width=40, height=10,
                                      bg="#292929", fg="white",
                                      insertbackground="white")
text_vars.grid(row=1, column=1)

# Checkbox array
array_var = tk.BooleanVar()
chk_array = tk.Checkbutton(frame, text="Usa Array ([])",
                           variable=array_var,
                           bg="#1e1e1e", fg="white",
                           selectcolor="#1e1e1e",
                           font=("Segoe UI", 11))
chk_array.grid(row=2, column=1, sticky="w", pady=10)

btn_frame = tk.Frame(root, bg="#1e1e1e")
btn_frame.pack(pady=10)

def make_button(text, cmd, color):
    return tk.Button(btn_frame, text=text, command=cmd,
                     bg=color, fg="white",
                     font=("Segoe UI", 11, "bold"),
                     relief="flat", padx=12, pady=6)

make_button("Genera Codice", genera_codice, "#4CAF50").pack(side="left", padx=10)
make_button("Copia Codice", copia_codice, "#2196F3").pack(side="left", padx=10)
make_button("Pulisci Tutto", pulisci_tutto, "#f44336").pack(side="left", padx=10)

progress = ttk.Progressbar(root, orient="horizontal", length=500, mode="determinate")
progress.pack(pady=10)

lbl_status = ttk.Label(root, text="")
lbl_status.pack()

text_output = scrolledtext.ScrolledText(root, width=120, height=24,
                                        bg="#292929", fg="white",
                                        insertbackground="white")
text_output.pack(pady=10)

root.mainloop()
