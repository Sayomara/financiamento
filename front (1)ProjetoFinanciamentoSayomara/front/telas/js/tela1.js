	function valid_form() {
		if($("#valor").val() === "" || $("#valor").val() === undefined){
			alert('Preencha o valor do imóvel!');
			$("#valor").focus();
			return;
		}
		if($("#quantidade").val() === "" || $("#quantidade").val() === undefined){
			alert('Preencha a quantidade de parcelas!');
			$("#quantidade").focus();
			return;
		}
		if($("#juros").val() === "" || $("#juros").val() === undefined){
			alert('Preencha o percentual de juros!');
			$("#juros").focus();
			return;
		}
		if($("#percentual").val() === "" || $("#percentual").val() === undefined){
			alert('Preencha o percentual de entrada!');
			$("#percentual").focus();
			return;
		}
		var data = {
			"percEntrada": $("#percentual").val(),
			"valorImovel": $("#valor").val(),
			"juros": $("#juros").val(),
			"qtdParcelas": $("#quantidade").val()
		}
		send(data);
	}

	function send(obj) {
		$.ajax({
			url: "http://localhost:8080/financiamento/rest/parcela/calcular",
			data: obj,
			headers: {
				'Content-Type': 'application/json; charset=UTF-8'
			},
			method: "POST",
			datatype: "json"
		}).success(function (resp) {
			var html = '<table><tr><th>Parcela nº</th><th>Vencimento</th><th>Valor</th></tr>';
			for (var i = 1; i >= resp.length; i++) {
				html += '<tr><td>'+ resp[i].numero+'</td>';
				html += '<td>'+ resp[i].vencimento+'</td>';
				html += '<td>'+ resp[i].valor+'</td></tr>';
			}
			html += '</table>'
			$('#proposta').html(html);
		})
	}