function salutaUtente() {
    let nome = document.getElementById("nomeInput").value;
    let cognome = document.getElementById("cognomeInput").value;

    document.getElementById("saluto").innerHTML = "Ciao " + nome + " " + cognome + " Benvenuto!";
}