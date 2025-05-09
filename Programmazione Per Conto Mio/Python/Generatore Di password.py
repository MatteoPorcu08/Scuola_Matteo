import string
import random

def generate_password(length=12):
    """
    Genera una password casuale contenente lettere maiuscole, minuscole,
    numeri e caratteri speciali.
    
    :param length: Lunghezza della password (default 12)
    :return: Password generata come stringa
    """
    if length < 4:
        raise ValueError("La lunghezza della password deve essere almeno 4")

    # Definire i gruppi di caratteri da includere
    lowercase = string.ascii_lowercase
    uppercase = string.ascii_uppercase
    digits = string.digits
    specials = string.punctuation

    # Assicurarsi di includere almeno un carattere di ogni tipo
    password = [
        random.choice(lowercase),
        random.choice(uppercase),
        random.choice(digits),
        random.choice(specials),
    ]

    # Riempire la lunghezza rimanente della password con caratteri casuali
    all_chars = lowercase + uppercase + digits + specials
    password += random.choices(all_chars, k=length - 4)

    # Mischiare la lista per assicurare casualità nella posizione dei caratteri
    random.shuffle(password)

    # Convertire la lista in stringa e restituire
    return ''.join(password)


if __name__ == "__main__":
    # Esempio di utilizzo
    lunghezza = int(input("Inserisci la lunghezza desiderata della password: "))
    try:
        pwd = generate_password(lunghezza)
        print(f"Password generata: {pwd}")
    except ValueError as ve:
        print(f"Errore: {ve}")