def genera_codice():
    class_name = entry_class.get().strip()
    raw_vars = [r.strip() for r in text_vars.get("1.0", tk.END).splitlines() if r.strip()]
    use_array = array_mode.get()

    if not class_name or not raw_vars:
        lbl_status.config(text="⚠ Inserisci il nome e almeno una variabile!", foreground="#f44336")
        return

    if use_array:
        num_max = entry_num.get().strip()
        if not num_max.isdigit():
            lbl_status.config(text="⚠ Inserisci un NUM_MAX valido!", foreground="#f44336")
            return

    variables = []
    for line in raw_vars:
        if ":" not in line:
            continue
        name, typ = map(str.strip, line.split(":", 1))
        variables.append((name, typ))

    if not variables:
        lbl_status.config(text="⚠ Variabili non valide!", foreground="#f44336")
        return

    def cap(n):
        return n[0].upper() + n[1:]

    # ==================================================
    #           GENERAZIONE CODICE JAVA
    # ==================================================

    code = f"/**\n"
    code += f" * Classe {class_name}\n"
    code += f" * Generata automaticamente\n"
    code += f" */\n"
    code += f"public class {class_name} {{\n\n"

    if use_array:
        code += f"    private static final int NUM_MAX = {num_max};\n\n"

    code += "    // ATTRIBUTI\n"
    for name, typ in variables:
        code += f"    private {typ}{'[]' if use_array else ''} {name};\n"
    code += "\n"

    code += f"    public {class_name}() {{\n"
    if use_array:
        for name, typ in variables:
            code += f"        {name} = new {typ}[NUM_MAX];\n"
    code += "    }\n\n"

    for name, typ in variables:
        tipo = f"{typ}[]" if use_array else typ

        code += f"    public {tipo} get{cap(name)}() {{\n"
        code += f"        return {name};\n"
        code += f"    }}\n\n"

        code += f"    public void set{cap(name)}({tipo} {name}) {{\n"
        code += f"        this.{name} = {name};\n"
        code += f"    }}\n\n"

    # ================= toString =================
    code += "    @Override\n"
    code += "    public String toString() {\n"

    if use_array:
        code += "        String s = \"\";\n"
        code += "        for (int i = 0; i < NUM_MAX; i++) {\n"
        code += "            if (" + " && ".join([f"{n}[i] != null" for n, _ in variables]) + ") {\n"
        code += "                s += i + \": \""
        for n, _ in variables:
            code += f" + {n}[i] + \" \""
        code += " + \"\\n\";\n"
        code += "            }\n"
        code += "        }\n"
        code += "        return s;\n"
    else:
        code += "        return "
        code += " + \", \" + ".join([n for n, _ in variables])
        code += ";\n"

    code += "    }\n"
    code += "}\n"

    text_output.delete("1.0", tk.END)
    animate_code(code)
    progress['value'] = 0
    animate_progress()