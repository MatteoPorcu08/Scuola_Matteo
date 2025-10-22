function calcolaIMC() {
  // Leggi valori dall'HTML
    const peso = document.getElementById("weightInput").value;
    const altezza = document.getElementById("heightInput").value;

  // Converti in numeri
    const pesoG = parseFloat(peso);
    const altezzaCm = parseFloat(altezza);

  // Conversioni: grammi -> kg, centimetri -> metri
  const pesoKg = pesoG / 1000;      // 1000 g = 1 kg
  const altezzaM = altezzaCm / 100; // 100 cm = 1 m

  // Calcolo IMC = peso(kg) / (altezza(m)^2)
  const imc = pesoKg / (altezzaM * altezzaM);

  // Mostra il risultato
    alert("IMC=" + imc);
}
