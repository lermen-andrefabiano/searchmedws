package br.com.searchmed.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.Mapper;

import br.com.searchmed.ConsultaService;
import br.com.searchmed.ExameService;
import br.com.searchmed.core.entidades.Exame;
import dto.ExameDTO;

@Named
@Path("exame")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExameResource extends AbstractResource {

	@Inject
	private ExameService exameService;
	
	@Inject
	private ConsultaService consultaService;

	@Inject
	public ExameResource(Mapper mapper) {
		super.mapper = mapper;
	}

	@GET
	@Path("getExames")
	public List<ExameDTO> getExames(@QueryParam("palavra") String palavra) {
		List<Exame> lst = exameService.getExames(palavra);

		List<ExameDTO> retorno = super.mapList(lst, ExameDTO.class);

		return retorno;
	}
	
	@GET
	@Path("excluir")
	public Response excluir(@QueryParam("id") Long id) {		
		this.consultaService.excluirExame(id);
		return Response.ok(true).build();
	}
	
	@POST
	@Path("incluir")
	public Response incluir(@QueryParam("consultaId") Long consultaId, @QueryParam("exameId") Long exameId) {		
		this.consultaService.incluirExame(consultaId, exameId);
		return Response.ok(true).build();
	}

}