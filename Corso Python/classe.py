class Persona():

	nome = 'Izanagi'
	cognome = 'Picaro'
	genere = 'M'

	def __init__(self,nome,cognome,genere):
		self.nome=nome
		self.cognome=cognome
		self.genere=genere



	def PerEesteso(self):
		if self.genere == 'M':
			titolo = 'Sig.'
		elif self.genere== 'F':
			titolo = 'Sig.ra'
		else:
			titolo='Gent.'
		return f"{titolo} {self.nome} {self.cognome}"

andrea = Persona('andrea','sotgia','M')

print (andrea.PerEesteso())	