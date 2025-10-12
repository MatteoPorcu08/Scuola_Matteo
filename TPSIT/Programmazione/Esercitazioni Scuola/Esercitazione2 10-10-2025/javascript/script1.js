let nome = prompt("Inserisci il tuo nome:");
let eta = prompt("Inserisci la tua età:");

if (eta < 18) {
  alert("Ciao " + nome + ", sei troppo giovane per registrarti");
}
if (eta >= 18) {
  alert("Ciao " + nome + ", registrazione completata");
}
