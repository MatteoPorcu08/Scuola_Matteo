import tkinter as tk
from tkinter import ttk, messagebox
import secrets
import string

# ======================================================
#               GENERATORE PASSWORD MIGLIORATO
# ======================================================

def generate_password(length=12, use_lower=True, use_upper=True, use_digits=True, use_specials=True):
    if length < 4:
        raise ValueError("La password deve essere lunga almeno 4 caratteri.")

    groups = []

    if use_lower:
        groups.append(string.ascii_lowercase)
    if use_upper:
        groups.append(string.ascii_uppercase)
    if use_digits:
        groups.append(string.digits)
    if use_specials:
        groups.append("!@#$%^&*()-_=+[]{};:,.<>/?|")

    if not groups:
        raise ValueError("Seleziona almeno un tipo di carattere.")

    # Garantire almeno un carattere per ogni categoria scelta
    password = [secrets.choice(group) for group in groups]

    all_chars = "".join(groups)

    password += [secrets.choice(all_chars) for _ in range(length - len(password))]
    secrets.SystemRandom().shuffle(password)

    return ''.join(password)

# ======================================================
#             VALUTAZIONE DELLA FORZA PASSWORD
# ======================================================

def valuta_password(pwd: str):
    score = 0
    length = len(pwd)

    # Lunghezza
    if length >= 8:  score += 20
    if length >= 12: score += 20
    if length >= 16: score += 10

    # Varietà caratteri
    if any(c.islower() for c in pwd): score += 10
    if any(c.isupper() for c in pwd): score += 10
    if any(c.isdigit() for c in pwd): score += 10
    if any(c in "!@#$%^&*()-_=+[]{};:,.<>/?|" for c in pwd): score += 10

    # Penalità ripetizioni
    if len(set(pwd)) < len(pwd) * 0.6:
        score -= 10  

    # Penalità sequenze comuni
    sequenze = ["123", "abc", "password", "qwerty", "111", "aaa"]
    if any(seq in pwd.lower() for seq in sequenze):
        score -= 15

    # Normalizza
    score = max(0, min(100, score))

    # Classificazione + colore
    if score < 30:
        return score, "Debole", "#f44336"
    elif score < 60:
        return score, "Media", "#ff9800"
    elif score < 80:
        return score, "Forte", "#ffc107"
    else:
        return score, "Molto forte", "#4caf50"

# ======================================================
#                          GUI
# ======================================================

def genera():
    try:
        length = int(entry_lunghezza.get())
        pwd = generate_password(
            length,
            check_lower.get(),
            check_upper.get(),
            check_digits.get(),
            check_special.get()
        )

        output_var.set(pwd)

        # Valutazione forza password
        score, testo, colore = valuta_password(pwd)
        lbl_forza.config(text=f"Forza: {testo} ({score}/100)", foreground=colore)

        # Barra grafica
        progress_strength["value"] = score
        style.configure("Strength.Horizontal.TProgressbar", troughcolor="#333", background=colore)

        lbl_status.config(text="✔ Password generata!", foreground="#4CAF50")

    except Exception as e:
        messagebox.showerror("Errore", str(e))
        lbl_status.config(text="Errore nella generazione", foreground="#f44336")

def copia():
    pwd = output_var.get()
    if pwd.strip():
        root.clipboard_clear()
        root.clipboard_append(pwd)
        lbl_status.config(text="✔ Copiata negli appunti!", foreground="#2196F3")
    else:
        lbl_status.config(text="Nessuna password da copiare", foreground="#f44336")

# ======================================================
#                    INTERFACCIA UTENTE
# ======================================================

root = tk.Tk()
root.title("Password Generator Pro")
root.geometry("480x600")
root.configure(bg="#1e1e1e")
root.resizable(False, False)

# Stile
style = ttk.Style()
style.theme_use("clam")

style.configure("TLabel", background="#1e1e1e", foreground="white", font=("Segoe UI", 12))
style.configure("TCheckbutton", background="#1e1e1e", foreground="white")
style.configure("TEntry", fieldbackground="#2d2d2d", foreground="white")
style.configure("TButton", font=("Segoe UI", 11, "bold"))
style.configure("Strength.Horizontal.TProgressbar", troughcolor="#333", background="#4caf50")

# Titolo
lbl_title = ttk.Label(root, text="🔐 Password Generator Pro", font=("Segoe UI", 22, "bold"))
lbl_title.pack(pady=15)

# Frame
frame = ttk.Frame(root)
frame.pack(pady=10)

# Lunghezza password
ttk.Label(frame, text="Lunghezza password:").grid(row=0, column=0, sticky="w", pady=5)
entry_lunghezza = ttk.Entry(frame, width=10)
entry_lunghezza.grid(row=0, column=1, padx=10)
entry_lunghezza.insert(0, "12")

# Checkbox opzioni
check_lower = tk.BooleanVar(value=True)
check_upper = tk.BooleanVar(value=True)
check_digits = tk.BooleanVar(value=True)
check_special = tk.BooleanVar(value=True)

ttk.Checkbutton(frame, text="Lettere minuscole", variable=check_lower).grid(row=1, column=0, sticky="w", pady=5)
ttk.Checkbutton(frame, text="Lettere maiuscole", variable=check_upper).grid(row=2, column=0, sticky="w")
ttk.Checkbutton(frame, text="Numeri", variable=check_digits).grid(row=3, column=0, sticky="w", pady=5)
ttk.Checkbutton(frame, text="Caratteri speciali", variable=check_special).grid(row=4, column=0, sticky="w")

# Pulsante genera
btn_gen = tk.Button(root, text="Genera Password", command=genera,
                    bg="#4CAF50", fg="white", relief="flat", padx=10, pady=6, font=("Segoe UI", 12, "bold"))
btn_gen.pack(pady=20)

# Output password
output_var = tk.StringVar()
entry_output = ttk.Entry(root, textvariable=output_var, font=("Segoe UI", 16), width=30)
entry_output.pack(pady=10)

# Copia
btn_copy = tk.Button(root, text="Copia", command=copia,
                     bg="#2196F3", fg="white", relief="flat", padx=10, pady=6)
btn_copy.pack(pady=5)

# Barra forza password
lbl_forza = ttk.Label(root, text="", font=("Segoe UI", 12))
lbl_forza.pack(pady=10)

progress_strength = ttk.Progressbar(root, style="Strength.Horizontal.TProgressbar",
                                    orient="horizontal", length=350, mode="determinate")
progress_strength.pack(pady=5)

# Stato
lbl_status = ttk.Label(root, text="", font=("Segoe UI", 12))
lbl_status.pack(pady=10)

root.mainloop()