import tkinter as tk
from tkinter import ttk, scrolledtext

# ======================================================
#                     FUNZIONI
# ======================================================

def genera_codice():
    class_name = entry_class.get().strip()
    raw_vars = text_vars.get("1.0", tk.END).strip().split("\n")
    use_array = array_mode.get()

    if not class_name or not raw_vars[0]:
        lbl_status.config(text="⚠ Inserisci il nome e almeno una variabile!", foreground="#f44336")
        return

    if use_array:
        num_max = entry_num.get().strip()
        if not num_max.isdigit():
            lbl_status.config(text="⚠ Inserisci un NUM_MAX valido!", foreground="#f44336")
            return

    variables = []
    for line in raw_vars:
        if ":" in line:
            name, typ = line.split(":")
            name = name.strip()
            typ = typ.strip()
            variables.append((name, typ))

    # ==================================================
    #           GENERAZIONE CODICE JAVA
    # ==================================================

    code = f"/**\n"
    code += f" * Classe {class_name}\n"
    code += f" * Generata automaticamente\n"
    code += f" */\n"
    code += f"public class {class_name} {{\n\n"

    # NUM_MAX
    if use_array:
        code += f"    private static final int NUM_MAX = {num_max};\n\n"

    # Attributi
    code += "    // ATTRIBUTI\n"
    for name, typ in variables:
        if use_array:
            code += f"    private {typ}[] {name};\n"
        else:
            code += f"    private {typ} {name};\n"
    code += "\n"

    # Costruttore
    code += f"    /**\n"
    code += f"     * Costruttore\n"
    code += f"     */\n"
    code += f"    public {class_name}() {{\n"
    if use_array:
        for name, typ in variables:
            code += f"        {name} = new {typ}[NUM_MAX];\n"
    code += f"    }}\n\n"

    # Getter e Setter
    for name, typ in variables:
        tipo = f"{typ}[]" if use_array else typ

        # Getter
        code += f"    public {tipo} get{name.capitalize()}() {{\n"
        code += f"        return {name};\n"
        code += f"    }}\n\n"

        # Setter
        code += f"    public void set{name.capitalize()}({tipo} {name}) {{\n"
        code += f"        this.{name} = {name};\n"
        code += f"    }}\n\n"

    # toString
    code += "    @Override\n"
    code += "    public String toString() {\n"
    if use_array:
        code += "        String s = \"\";\n"
        code += "        for (int i = 0; i < NUM_MAX; i++) {\n"
        code += "            if (" + variables[0][0] + "[i] != null) {\n"
        code += "                s += i + \") \" + " + variables[0][0] + "[i] + \"\\n\";\n"
        code += "            }\n"
        code += "        }\n"
        code += "        return s;\n"
    else:
        code += "        return \""
        for i, (name, _) in enumerate(variables):
            if i > 0:
                code += " + \", \" + "
            code += f"{name}"
        code += "\";\n"
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
    entry_num.delete(0, tk.END)
    lbl_status.config(text="")
    progress['value'] = 0


def toggle_array():
    if array_mode.get():
        lbl_num.grid(row=3, column=0, sticky="w", padx=10)
        entry_num.grid(row=3, column=1, sticky="w")
    else:
        lbl_num.grid_remove()
        entry_num.grid_remove()

# ======================================================
#                        UI
# ======================================================

root = tk.Tk()
root.title("Generatore Professionale Classi Java")
root.geometry("1100x780")
root.configure(bg="#1e1e1e")

style = ttk.Style(root)
style.theme_use("clam")
style.configure("TLabel", background="#1e1e1e", foreground="white", font=("Segoe UI", 12))
style.configure("TFrame", background="#1e1e1e")

ttk.Label(root, text="Generatore Professionale di Classi Java",
          font=("Segoe UI", 26, "bold")).pack(pady=15)

frame = ttk.Frame(root)
frame.pack(pady=15)

ttk.Label(frame, text="Nome Classe:").grid(row=0, column=0, sticky="w", padx=10)
entry_class = ttk.Entry(frame, width=40)
entry_class.grid(row=0, column=1)

ttk.Label(frame, text="Variabili (es: elenco : Persona)").grid(row=1, column=0, sticky="nw", padx=10)
text_vars = scrolledtext.ScrolledText(frame, width=40, height=8,
                                      bg="#292929", fg="white",
                                      insertbackground="white")
text_vars.grid(row=1, column=1)

array_mode = tk.BooleanVar()
chk_array = tk.Checkbutton(frame, text="Usa Array",
                           variable=array_mode,
                           command=toggle_array,
                           bg="#1e1e1e", fg="white",
                           selectcolor="#1e1e1e",
                           font=("Segoe UI", 11))
chk_array.grid(row=2, column=1, sticky="w", pady=5)

lbl_num = ttk.Label(frame, text="NUM_MAX:")
entry_num = ttk.Entry(frame, width=10)

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

text_output = scrolledtext.ScrolledText(root, width=120, height=26,
                                        bg="#292929", fg="white",
                                        insertbackground="white")
text_output.pack(pady=10)

root.mainloop()
