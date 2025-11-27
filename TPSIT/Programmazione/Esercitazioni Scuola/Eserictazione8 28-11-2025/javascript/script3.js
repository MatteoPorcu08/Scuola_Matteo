function cambiaColore() {
    let colore = document.getElementById("colorInput").value;
    let immagine = document.getElementById("immagineColore");
    let percorsoImmagine = `../img/${colore}.jpg`; // Cambia "verde" con il colore inserito
    immagine.src = percorsoImmagine;
}