function getCookie(name) {
	var value = "; " + document.cookie; // padroniza a divisão de caracteres
	var parts = value.split("; " + name + "="); // separada a parte do cookie procurado
	if (parts.length == 2) return parts.pop().split(";").shift(); // remove os cookies anteriores e por fim retorna apenas a parte do valor
}
		
var nome = getCookie("nome");
var p1 = parseFloat(getCookie("p1"));
var p2 = parseFloat(getCookie("p2"));

console.log(nome);
console.log(p1);
console.log(p2);

var media = (p1 + p2) / 2;

document.querySelector("#nome").querySelector("span").textContent = nome;
document.querySelector("#p1").querySelector("span").textContent = p1.toFixed(1)
document.querySelector("#p2").querySelector("span").textContent = p2.toFixed(1)
document.querySelector("#media").querySelector("span").textContent = media.toFixed(1)
