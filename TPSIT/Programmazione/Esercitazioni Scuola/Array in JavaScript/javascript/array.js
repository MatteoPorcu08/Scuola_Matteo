let carrello = [];
function aggiungi() {
    let alimento = document.getElementById("alimento").value;
    
    carrello.innerHTML += `<li>${alimento}</li>`;
}