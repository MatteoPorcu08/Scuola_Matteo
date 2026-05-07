let prodotto = [];
let quantita = [];
let i=0;

function aggiungi(){
    let prod= document.getElementById("prodotto").value;
    let quant= document.getElementById("quantità").value*1;
    let risultatoControllo = ricercaElemento(prod);

    if(document.getElementById("prodotto").value !=""  && quant>0){
        if(risultatoControllo!= -1){
            alert("Prodotto già presente!");
            document.getElementById("prodotto").value = "";
            document.getElementById("quantità").value = "";
        }else{
            prodotto[i] = prod;
            quantita[i] = quant;

        i++;

        document.getElementById("prodotto").value = "";
        document.getElementById("quantità").value = "";
        alert("Prodotto " +prod+ " aggiunto correttamente!");
        }
        
    }else{
        alert("Compilare prodetto e quantità");
        document.getElementById("prodotto").value = "";
        document.getElementById("quantità").value = "";
    }
}

function mostra(){
    if(prodotto.length=="" && quantita.length==""){
        alert("Magazzino vuoto");
    }else{
        let elenco = "";
        for (let j = 0; j < prodotto.length; j++) {
            elenco+= "Prodotto - Quantità<br>"+prodotto[j] + " X" + quantita[j] + "<br>";
        }
        document.getElementById("output").innerHTML= elenco;
    }
}

function svuota(){
        document.getElementById("output").innerHTML;
        document.getElementById("output").innerHTML="";
        alert("Tutti gli elementi sono stati elmininati");
}

function ricercaElemento(valore) {
    for (let j = 0; j < prodotto.length; j++) {
        if (prodotto[j] == valore) {
            return j;
        }
    }
    return -1;
}

function preleva(){
    if(prodotto.length==0){
        alert("Serve aggiungere almeno un prodotto");
    }else{
        let nome=prompt("Inserisci il nome del prodotto che desideri prelevare");
        let quantita=prompt("Inserisci la quantita che desideri prelevare")*1;
        let risultato=cerca(prodotto,nome);
        if(nome===""||quantita==""){
            alert("Compilare prodotto e quantita");
    }
        else if(risultato!=-1 && quantita<=quantitaDisponibili[risultato]){
                let quantitaAggiornata=quantitaDisponibili[risultato]-quantita;
                quantitaDisponibili[risultato]=quantitaAggiornata;
                alert("Preievlo effettuato correttamente");
                document.getElementById("visual").innerHTML="Lista da aggiornare!";
            }
            
            else if(quantita>quantitaDisponibili[risultato]){
                alert("Quantita insufficiente");
            }
                else if(risultato==-1){
            alert("Prodotto inesistente");
            }
        }
}