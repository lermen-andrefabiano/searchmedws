package br.com.searchmed.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.Mapper;

import br.com.searchmed.ConsultaService;
import br.com.searchmed.ExameService;
import br.com.searchmed.core.entidades.ConsultaExame;
import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.core.entidades.Laboratorio;
import dto.ConsultaExameDTO;
import dto.ExameDTO;
import dto.LaboratorioDTO;

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
	@Path("getLaboratorio")
	public List<LaboratorioDTO> listarLaboratorios(@QueryParam("exameId") Long exameId) {
		List<Laboratorio> lst = exameService.listarLaboratorios(exameId);
		List<LaboratorioDTO> retorno = super.mapList(lst, LaboratorioDTO.class);
		return retorno;
	}
	
	@GET
	@Path("getExamesUsuario")
	public List<ConsultaExameDTO> getExamesUsuario(@QueryParam("usuarioId") Long usuarioId) {
		List<ConsultaExame> lst = exameService.getExamesUsuario(usuarioId);
		List<ConsultaExameDTO> retorno = super.mapList(lst, ConsultaExameDTO.class);
		return retorno;
	}
	
	@GET
	@Path("getExamesConsulta")
	public List<ConsultaExameDTO> getExamesConsulta(@QueryParam("consultaId") Long consultaId) {
		List<ConsultaExame> lst = exameService.getExamesConsulta(consultaId);
		List<ConsultaExameDTO> retorno = super.mapList(lst, ConsultaExameDTO.class);
		return retorno;
	}

	@GET
	@Path("getExames")
	public List<ExameDTO> getExames() {
		List<Exame> lst = exameService.getExames();
		List<ExameDTO> retorno = super.mapList(lst, ExameDTO.class);
		return retorno;
	}
	
	@GET
	@Path("excluir")
	public Response excluir(@QueryParam("consultaId") Long consultaId, @QueryParam("exameId") Long exameId) {
		this.consultaService.excluirExame(consultaId, exameId);
		return Response.ok(true).build();
	}	
	
	@GET
	@Path("incluir")
	public Response incluir(@QueryParam("consultaId") Long consultaId, @QueryParam("exameId") Long exameId) {		
		this.consultaService.incluirExame(consultaId, exameId);
		return Response.ok(true).build();
	}
	
	@GET
	@Path("agenda")
	public Response agenda(@QueryParam("agenda") Long agenda, @QueryParam("laboratorioId") Long laboratorioId, @QueryParam("consultarExameId") Long consultarExameId) {		
		this.exameService.agenda(agenda, laboratorioId, consultarExameId);
		return Response.ok(true).build();
	}

}