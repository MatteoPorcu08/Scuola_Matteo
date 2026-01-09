function AggiungiEsameSvolgere() {
    let nome = prompt("Inserisci il nome dell'esame da svolgere");

    if (nome != null && nome != "") {
        document.getElementById("tabellaSvolgere").innerHTML += "<tr><td>" + nome + "</td></tr>";
        document.getElementById("numeroesamisvolgere").innerHTML = document.getElementById("numeroesamisvolgere").innerHTML * 1 + 1;
        document.getElementById("esameaggiuntosvolgere").innerHTML = "Esame aggiunto correttamente!";
    }
}

function AggiungiEsameSvolto() {
    let nome = prompt("Inserisci il nome dell'esame svolto");

    if (nome != null && nome != "") {
        document.getElementById("tabellaSvolti").innerHTML += "<tr><td>" + nome + "</td></tr>";
        document.getElementById("numeroesamisvolti").innerHTML = document.getElementById("numeroesamisvolti").innerHTML * 1 + 1;
        document.getElementById("esameaggiuntosvolto").innerHTML = "Bravo hai terminato con sucesso: " + nome + "!";
    }
}

function VerificaCarriera() {
    let svolti = document.getElementById("numeroesamisvolti").innerHTML * 1;
    let daSvolgere = document.getElementById("numeroesamisvolgere").innerHTML * 1;
    let somma = document.getElementById("sommapagare").innerHTML * 1;

    if (svolti >= daSvolgere && somma == 0) {
        alert("Bravo, hai terminato con successo");
    }
    else if (svolti >= daSvolgere && somma > 0) {
        alert("Hai terminato gli esami ma devi pagare " + somma + " EUR");
    }
    else {
        alert("Hai ancora esami da svolgere!");
    }
}

function Paga() {
    let paga = prompt("Quanto vuoi pagare?") * 1;
    let totale = document.getElementById("sommapagare").innerHTML * 1;

    while (paga <= 0 || paga > totale) {
        alert("Errore! Importo non valido");
        paga = prompt("Quanto vuoi pagare?") * 1;
    }

    document.getElementById("sommapagare").innerHTML = totale - paga;
}