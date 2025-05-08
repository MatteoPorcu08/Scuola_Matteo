import random

class Personaggio:
    def __init__(self):
        self.forza = random.randint(1, 20)
        self.destrezza = random.randint(1, 20)
        self.costituzione = random.randint(1, 20)
        self.nome = self._CreaNome()

    def _CreaNome(self):
        vocali = ["a", "e", "i", "o", "u"]
        consonanti = ["b", "c", "d", "f", "g", "h", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v"]
        s1 = random.choice(consonanti) + random.choice(vocali)
        s2 = random.choice(consonanti) + random.choice(vocali)
        s3 = random.choice(consonanti) + random.choice(vocali)
        nome = s1 + s2 + s3
        return nome

    def __str__(self):
        return f"Nome: {self.nome}, Forza: {self.forza}, Destrezza: {self.destrezza}, Costituzione: {self.costituzione}"


# Esempio di utilizzo
p = Personaggio()
print(p)
print(vs)
nemico= Personaggio()
print(nemico)
