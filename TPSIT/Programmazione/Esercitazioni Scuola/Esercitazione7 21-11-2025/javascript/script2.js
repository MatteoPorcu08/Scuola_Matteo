function calcolaSomma() {
	let num1 = document.getElementById("num1").value*1;
	let num2 = document.getElementById("num2").value*1;
	let somma = num1 + num2;
	document.getElementById("risultato").innerHTML = "La somma dei numeri inseriti è :"+somma;
}