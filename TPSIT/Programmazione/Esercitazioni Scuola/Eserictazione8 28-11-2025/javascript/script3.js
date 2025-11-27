function cambiaColore() {
    let colore = document.getElementById("colorInput").value;
    let immagine = document.getElementById("immagineColore");
    let percorsoImmagine = `../img/${colore}.jpg`;
    immagine.src = percorsoImmagine;
}