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