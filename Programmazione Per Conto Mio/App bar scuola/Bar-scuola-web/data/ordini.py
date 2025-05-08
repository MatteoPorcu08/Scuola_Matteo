ordini = []

def aggiungi_ordine(prodotto, quantita):
    if prodotto in ordini:
        ordini[prodotto] += quantita
    else:
        ordini[prodotto] = quantita
    
def mostra_ordini():
    return ordini

def svuota_ordini():
    global ordini
    ordini = {}