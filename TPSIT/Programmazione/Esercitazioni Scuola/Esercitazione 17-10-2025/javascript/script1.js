let nome = document.querySelector("#nameInput").value;
let eta = document.querySelector("#ageInput").value;

if (eta < 18) {
  alert("Ciao " + nome + ", sei troppo giovane per registrarti");
}
if (eta >= 18) {
  alert("Ciao " + nome + ", registrazione completata");
}
