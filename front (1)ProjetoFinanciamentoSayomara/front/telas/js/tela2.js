function valid_form() {
	if($("#salario").val() === "" || $("#salario").val() === undefined){
		alert('Preencha o valor do salário!');
		$("#salario").focus();
	}
	if($("#valor").val() === "" || $("#valor").val() === undefined){
		alert('Preencha o valor do imóvel!');
		$("#valor").focus();
	}
	if($("#quantidade").val() === "" || $("#quantidade").val() === undefined){
		alert('Preencha a quantidade de parcelas!');
		$("#quantidade").focus();
	}
	if($("#juros").val() === "" || $("#juros").val() === undefined){
		alert('Preencha o percentual de juros!');
		$("#juros").focus();
	}
	if($("#percentual").val() === "" || $("#percentual").val() === undefined){
		alert('Preencha o percentual de entrada!');
		$("#percentual").focus();
	}
	var data = {
		"salario": $("#salario").val(),
		"percEntrada": $("#percentual").val(),
		"valorImovel": $("#valor").val(),
		"juros": $("#juros").val(),
		"qtdParcelas": $("#quantidade").val()
	}
	send(data);
}

function send(data) {
	$.ajax({
		url: "http://localhost:8080/financiamento/rest/parcela/calcular"
	})
}