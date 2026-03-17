import tkinter as tk
from tkinter import ttk, filedialog

# ---------------- UTIL ----------------

def cap(n):
    return n[0].upper() + n[1:]


# ---------------- MESSAGGI ANIMATI ----------------

def show_message(msg, color="#4CAF50"):

    popup = tk.Label(
        root,
        text=msg,
        bg=color,
        fg="white",
        font=("Segoe UI", 11, "bold"),
        padx=20,
        pady=6
    )

    popup.place(relx=0.5, rely=0.92, anchor="center")

    root.after(1800, popup.destroy)


# ---------------- ANIMAZIONE CODICE ----------------

def animate_code(text, index=0):

    if index < len(text):
        text_output.insert(tk.END, text[index])
        text_output.after(1, animate_code, text, index + 1)
    else:
        highlight_java()


# ---------------- COLORAZIONE JAVA ----------------

def highlight_java():

    text_output.tag_remove("keyword", "1.0", tk.END)
    text_output.tag_remove("type", "1.0", tk.END)
    text_output.tag_remove("comment", "1.0", tk.END)

    keywords = ["public", "class", "private", "return", "new"]
    types = ["String", "int", "double", "boolean"]

    for word in keywords:
        start = "1.0"
        while True:
            start = text_output.search(word, start, stopindex=tk.END)
            if not start:
                break
            end = f"{start}+{len(word)}c"
            text_output.tag_add("keyword", start, end)
            start = end

    for word in types:
        start = "1.0"
        while True:
            start = text_output.search(word, start, stopindex=tk.END)
            if not start:
                break
            end = f"{start}+{len(word)}c"
            text_output.tag_add("type", start, end)
            start = end

    start = "1.0"
    while True:
        start = text_output.search("//", start, stopindex=tk.END)
        if not start:
            break
        end = text_output.search("\n", start, stopindex=tk.END)
        if not end:
            end = tk.END
        text_output.tag_add("comment", start, end)
        start = end


# ---------------- GENERAZIONE CODICE ----------------

def genera_codice():

    class_name = entry_class.get().strip()

    raw_vars = [
        v.strip()
        for v in text_vars.get("1.0", tk.END).splitlines()
        if v.strip()
    ]

    if not class_name:
        show_message("Inserisci il nome della classe", "#f44336")
        return

    variables = []
    array_object = None

    for line in raw_vars:

        if ":" not in line:
            continue

        name, typ = map(str.strip, line.split(":"))

        size = None

        if "[" in typ and "]" in typ:
            base = typ[:typ.index("[")]
            size = typ[typ.index("[") + 1:typ.index("]")]
            typ = base + "[]"

        variables.append((name, typ, size))

    code = f"public class {class_name} {{\n\n"

    # ---------------- VARIABILI ----------------

    for name, typ, size in variables:

        if size:
            base = typ.replace("[]", "")
            array_object = (name, base, size)

            code += f"    private static final int NUM_MAX = {size};\n"
            code += f"    private {base}[] {name};\n"
            code += f"    private int numero{cap(name)};\n"

        else:
            code += f"    private {typ} {name};\n"

    code += "\n"

    # ---------------- COSTRUTTORE ----------------

    if var_costruttore_vuoto.get():

        code += f"""    //Costruttore
    public {class_name}() {{
"""

        if array_object:
            name, base, size = array_object
            code += f"        {name} = new {base}[NUM_MAX];\n"
            code += f"        this.numero{cap(name)} = 0;\n"

        code += "    }\n\n"

    else:

        params = []

        for name, typ, size in variables:
            if not size:
                params.append(f"{typ} {name}")

        param_string = ", ".join(params)

        code += f"""    //Costruttore
    public {class_name}({param_string}) {{
"""

        for name, typ, size in variables:
            if not size:
                code += f"        this.{name} = {name};\n"

        code += "    }\n\n"

    # ---------------- COSTRUTTORE DI COPIA ----------------

    if var_copy.get():

        code += f"""    //Costruttore di copia
    public {class_name}({class_name} altro) {{
"""

        if array_object:
            name, base, size = array_object

            code += f"        {name} = new {base}[NUM_MAX];\n"
            code += f"        numero{cap(name)} = altro.numero{cap(name)};\n"
            code += f"        for (int i = 0; i < numero{cap(name)}; i++) {{\n"
            code += f"            {name}[i] = new {base}(altro.{name}[i]);\n"
            code += f"        }}\n"

        else:
            for name, typ, size in variables:
                code += f"        this.{name} = altro.{name};\n"

        code += "    }\n\n"

    # ---------------- GETTER / SETTER ----------------

    if var_getset.get():

        code += "    //Getter e Setter\n\n"

        for name, typ, size in variables:

            code += f"""    public {typ} get{cap(name)}() {{
        return {name};
    }}

"""

            code += f"""    public void set{cap(name)}({typ} {name}) {{
        this.{name} = {name};
    }}

"""

    # ---------------- TOSTRING ----------------

    if var_tostring.get():

        code += """    //Metodo ToString
    @Override
    public String toString() {
        return \"
"""

        for name, _, _ in variables:
            code += f"{name}=\" + {name} + \" "

        code += """\";
    }

"""

    code += "}\n"

    text_output.delete("1.0", tk.END)
    animate_code(code)
    show_message("✔ Codice generato")


# ---------------- COPIA ----------------

def copia_codice():

    code = text_output.get("1.0", tk.END)

    root.clipboard_clear()
    root.clipboard_append(code)

    show_message("📋 Codice copiato")


# ---------------- SALVA ----------------

def salva_file():

    code = text_output.get("1.0", tk.END)

    file = filedialog.asksaveasfilename(
        defaultextension=".java",
        filetypes=[("Java file", "*.java")]
    )

    if file:
        with open(file, "w") as f:
            f.write(code)

        show_message("💾 File salvato")


# ---------------- NUMERI DI RIGA ----------------

def update_lines(event=None):

    lines = text_output.index("end-1c").split(".")[0]

    line_numbers.config(state="normal")
    line_numbers.delete("1.0", tk.END)

    for i in range(1, int(lines) + 1):
        line_numbers.insert(tk.END, str(i) + "\n")

    line_numbers.config(state="disabled")


# ---------------- GUI ----------------

root = tk.Tk()
root.title("Java Class Generator")
root.geometry("1000x700")
root.configure(bg="#1e1e1e")

main = ttk.Frame(root, padding=20)
main.pack(fill="both", expand=True)

ttk.Label(main, text="Java Class Generator",
          font=("Segoe UI", 20)).pack(pady=(0, 10))

ttk.Label(main, text="Nome Classe").pack(anchor="w")

entry_class = ttk.Entry(main)
entry_class.pack(fill="x")

ttk.Label(main, text="Variabili (nome:tipo)").pack(anchor="w")

text_vars = tk.Text(main, height=6)
text_vars.pack(fill="x")

options = ttk.Frame(main)
options.pack(pady=10)

var_getset = tk.BooleanVar(value=True)
var_costruttore_vuoto = tk.BooleanVar()
var_copy = tk.BooleanVar()
var_tostring = tk.BooleanVar(value=True)

ttk.Checkbutton(options, text="Getter + Setter",
                variable=var_getset).grid(row=0, column=0, padx=10)

ttk.Checkbutton(options, text="Costruttore vuoto",
                variable=var_costruttore_vuoto).grid(row=0, column=1, padx=10)

ttk.Checkbutton(options, text="Costruttore di copia",
                variable=var_copy).grid(row=0, column=2, padx=10)

ttk.Checkbutton(options, text="ToString",
                variable=var_tostring).grid(row=0, column=3, padx=10)

buttons = ttk.Frame(main)
buttons.pack(pady=10)

ttk.Button(buttons, text="Genera codice",
           command=genera_codice).pack(side="left", padx=5)

ttk.Button(buttons, text="Copia codice",
           command=copia_codice).pack(side="left", padx=5)

ttk.Button(buttons, text="Salva file .java",
           command=salva_file).pack(side="left", padx=5)

editor_frame = tk.Frame(main)
editor_frame.pack(fill="both", expand=True)

line_numbers = tk.Text(
    editor_frame,
    width=4,
    bg="#252526",
    fg="#858585",
    state="disabled",
    font=("Consolas", 11)
)

line_numbers.pack(side="left", fill="y")

text_output = tk.Text(
    editor_frame,
    bg="#1e1e1e",
    fg="#d4d4d4",
    insertbackground="white",
    font=("Consolas", 11)
)

text_output.pack(fill="both", expand=True)

text_output.bind("<KeyRelease>", update_lines)
text_output.bind("<MouseWheel>", update_lines)

text_output.tag_config("keyword", foreground="#569CD6")
text_output.tag_config("type", foreground="#4EC9B0")
text_output.tag_config("comment", foreground="#6A9955")

update_lines()

root.mainloop()