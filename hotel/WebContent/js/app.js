function getCookie(name) {
	var value = "; " + document.cookie; // padroniza a divisão de caracteres
	var parts = value.split("; " + name + "="); // separada a parte do cookie procurado
	if (parts.length == 2) return parts.pop().split(";").shift(); // remove os cookies anteriores e por fim retorna apenas a parte do valor
}
		
var cookie = getCookie("usuario.logado");
if (!(cookie === undefined)) {
	document.querySelector("#cadastrar").style.display = "none";
	document.querySelector("#frm-login").style.display = "none";
	var logado = document.querySelector("#logado");
	logado.style.display = "block";
	logado.querySelector("span").textContent = cookie;
	document.querySelector("#frm-consultar").style.display = "block";
} else {
	document.querySelector("#cadastrar").style.display = "block";
	document.querySelector("#frm-login").style.display = "block";
	var logado = document.querySelector("#logado");
	logado.style.display = "none";
	logado.querySelector("span").textContent = "";
	document.querySelector("#frm-consultar").style.display = "none";
}