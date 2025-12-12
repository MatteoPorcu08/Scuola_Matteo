let totale=0;
function aggiungiCorso(){
    let corso= document.getElementById("nomecorso").value;
    let istruttore= document.getElementById("nomeistruttore").value;

    document.getElementById("listacorso").innerHTML += "<br>" + corso;
    document.getElementById("listaistruttore").innerHTML += "<br>" + istruttore;
        document.getElementById("nomecorso").value = "";
        document.getElementById("nomeistruttore").value = "";
}

function elimina(){
    if(document.getElementById("listacorso").innerHTML == "" && document.getElementById("listaistruttore").innerHTML == "" ){
        alert("Non ci sono corsi da eliminare!");
    } else{
        document.getElementById("listacorso").innerHTML = "";
        document.getElementById("listaistruttore").innerHTML = "";
        alert("Corsi eliminati!");
    }
}

function aggiungiCosti(){
    let corso;
    let prezzo;
    if(totale>700){
            alert("Attenzione il totale ha superato 700EUR");
        }else{
            corso=prompt("Inserisci il nome del corso:");
            do{
            prezzo= prompt("Inserisci il prezzo del corso:")*1;
        if(prezzo<=0){
            alert("Errore!Il prezzo deve essere maggiore di 0");
        }
    }while(prezzo<=0);
    
    document.getElementById("prezzo").innerHTML += "<br>" + corso + ":" + prezzo + " EUR";

    totale += prezzo;
    document.getElementById("totaleinclusiva").innerHTML =  + totale ;
        }
}