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
    array_object = None  # per gestire array di oggetti

    for line in raw_vars:

        if ":" not in line:
            show_message(f"Formato errato: {line}", "#f44336")
            return

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

            # ARRAY DI OGGETTI
            if base[0].isupper():
                array_object = (name, base, size)

                code += f"    private static final int NUM_MAX = {size};\n"
                code += f"    private {base}[] {name};\n"
                code += f"    private int numero{cap(name)};\n"

            else:
                code += f"    private {base}[] {name} = new {base}[{size}];\n"

        else:
            code += f"    private {typ} {name};\n"

    code += "\n"

    # ---------------- COSTRUTTORE ----------------

    code += f"""    //Costruttore
    public {class_name}() {{
"""

    if array_object:
        name, base, size = array_object
        code += f"        {name} = new {base}[NUM_MAX];\n"
        code += f"        numero{cap(name)} = 0;\n"

    else:
        for name, typ, size in variables:
            if size:
                base = typ.replace("[]", "")
                code += f"        {name} = new {base}[{size}];\n"

    code += "    }\n\n"

    # ---------------- COSTRUTTORE DI COPIA ----------------

    if var_copy.get():

        code += f"""    //Costruttore di copia
    public {class_name}({class_name} p) {{
"""

        if array_object:
            name, base, size = array_object

            code += f"        {name} = new {base}[NUM_MAX];\n"
            code += f"        numero{cap(name)} = p.numero{cap(name)};\n"
            code += f"        for (int i = 0; i < numero{cap(name)}; i++) {{\n"
            code += f"            {name}[i] = new {base}(p.{name}[i]);\n"
            code += f"        }}\n"

        else:
            for name, typ, size in variables:
                if size:
                    code += f"        this.{name} = p.{name}.clone();\n"
                else:
                    code += f"        this.{name} = p.{name};\n"

        code += "    }\n\n"

    # ---------------- GETTER / SETTER ----------------

    if var_getset.get():

        code += "    //Getter e Setter\n\n"

        for name, typ, size in variables:

            if size:
                code += f"""    public {typ} get{cap(name)}() {{
        return {name}.clone();
    }}

"""
                code += f"""    public void set{cap(name)}({typ} {name}) {{
        this.{name} = {name}.clone();
    }}

"""
            else:
                code += f"""    public {typ} get{cap(name)}() {{
        return {name};
    }}

"""
                code += f"""    public void set{cap(name)}({typ} {name}) {{
        this.{name} = {name};
    }}

"""

    # ---------------- TOSTRING ----------------

    code += f"""    //Metodo ToString
    @Override
    public String toString() {{
        return "{class_name}{{" +
"""

    for i, (name, _, _) in enumerate(variables):
        sep = '", ' if i < len(variables) - 1 else '"'
        code += f'               "{name}=" + {name} + {sep} +\n'

    code += """               '}';
    }

"""

    code += "}\n"

    text_output.delete("1.0", tk.END)
    animate_code(code)

    show_message("✔ Codice generato")