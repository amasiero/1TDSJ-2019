window.onload = carregarDados();

function carregarDados() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET", "consultar", true);
	
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			var empresas = JSON.parse(xhr.responseText);
			empresas.forEach(function(empresa) {
				criarItemLista(empresa.nome);
			});
		}
	});
	
	xhr.addEventListener("loadstart", function() {
        var loading = document.querySelector(".loading");
        loading.classList.add("active");
    });
    
    xhr.addEventListener("loadend", function() {
        var loading = document.querySelector(".loading");
        loading.classList.remove("active");
    });
	
	xhr.send();
}

function criarItemLista(nome){
	var ul = document.querySelector("ul");
	var li = document.createElement("li");
	li.textContent = nome;
	ul.appendChild(li);
}

var filtro = document.querySelector("#filtro");
filtro.addEventListener("input", function() {
	var filtroDigitado = this.value;
	var empresas = document.querySelectorAll("li");

	if (filtroDigitado.length > 0) {
		empresas.forEach(function(empresa) {
			var nome = empresa.textContent;
			var re = new RegExp(filtroDigitado, "i"); 
			if (!re.test(nome)) {
				empresa.classList.add("invisivel");
			} else {
				empresa.classList.remove("invisivel");
			}
		});
	} else {
		empresas.forEach(function(empresa) {
			empresa.classList.remove("invisivel");
		});
	}

});