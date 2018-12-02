package br.senai.sc.financiamento.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/app")
public class TesteWS {
	
	@GET
	@Path("/hello")
	public Response getHelloWorld(){
		return Response.status(200).entity("Hello world!!!").build();
	}

}
