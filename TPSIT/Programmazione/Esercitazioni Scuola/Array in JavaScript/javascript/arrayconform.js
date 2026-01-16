var nome = new Array();
var i = 0;
//caricamento nomi
function invio() {
    nome[i] = f1.N.value;
    i++;
    f1.N.value = "";
}
//visualizzazione nomi
function stampa() {
    document.write("<table border='1'>");
    for (var j = 0; j < i; j++) {
        document.write("<tr><td>" + nome[j] + "</td></tr>");
    }
    document.write("</table>");
}