package br.senai.sc.financiamento.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.senai.sc.financiamento.entity.Financiamento;
import br.senai.sc.financiamento.entity.Parcela;
import br.senai.sc.financiamento.service.ParcelaService;

@Path("/parcela")
public class ParcelaWS {
	
	private ParcelaService parcelaService;

	/*
	 * Aqui definimos o método WS para buscar os valores das parcelas,
	 * via POST, no path calcular, produzindo e consumindo com charset UTF-8
	 * e com JSON
	 */
	@POST
	@Path("/calcular")
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response calcularFinanciamento(Financiamento financiamento) {
		this.parcelaService = new ParcelaService();
		List<Parcela> parcelas = this.parcelaService.getParcelasByFinanciamento(financiamento); 
		/*
		 * Aqui define uma entidade para lista
		 */
		GenericEntity<List<Parcela>> list = new GenericEntity<List<Parcela>>(parcelas){};
		/*
		 * Aqui retorna uma resposta com a lista no formato JSON
		 */
		return Response
				.ok(list)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}
