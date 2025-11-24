function cambiaColore() {
    const colore = document.getElementById("colorInput").value;
    const immagine = document.getElementById("immagineColore");
    const percorsoImmagine = `../img/${colore}.jpg`; // Cambia "verde" con il colore inserito
    immagine.src = percorsoImmagine;
}