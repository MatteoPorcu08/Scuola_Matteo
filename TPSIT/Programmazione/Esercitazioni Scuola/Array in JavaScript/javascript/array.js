let carrello = [];
let i = 0;
function aggiungi() {
    let alimento = document.getElementById("alimento").value;
    carrello[i] = alimento;
    i++;
    carrello.innerHTML += `<li>${alimento}</li>`;
}