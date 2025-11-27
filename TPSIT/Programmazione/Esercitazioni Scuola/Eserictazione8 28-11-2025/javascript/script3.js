function cambiaColore() {
    let colore = document.getElementById("colorInput").value;
    let immagine = document.getElementById("immagineColore");
    immagine.src = `../img/${colore}.jpg`;
}