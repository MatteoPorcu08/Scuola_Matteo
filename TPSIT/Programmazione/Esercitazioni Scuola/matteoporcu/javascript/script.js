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
    let prelevaProdotto = prompt("Inserisci il nome del prodotto da prelevare");
    let prelevaQuantita = prompt("Inserisci la quantita da prelevare");
    let risultatoControllo = ricercaElemento(prelevaProdotto);

    if(prelevaProdotto=="" && prelevaQuantita==""){
        alert("Compilare prodotto e quantita");
    }else if(risultatoControllo != -1){
        if(quant>= prelevaQuantita){
            quantita=quant-prelevaQuantita;
            alert("Prelievo effetuato corretamente");
            mostra();
        }else if(prelevaQuantita>quant){
            alert("La quantità richiesta e maggiore di quella disponibile");
        }else{
            alert("Quantità insufficiente");
        }
    }
}