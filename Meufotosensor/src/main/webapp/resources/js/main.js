function somenteNumero(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
}

function somenteLetra(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla >= 48 && tecla <= 57))
		return false;
	else {
		return true;
	}
}

function semEspaco(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla == 32))
		return false;
	else {
		return true;
	}
}

function tiraEspaco() {
	var nomeAtendente = document.getElementById('formCadastro:idNomeAtendente').value;
	document.getElementById('formCadastro:idNomeAtendente').value = nomeAtendente.trim();
}