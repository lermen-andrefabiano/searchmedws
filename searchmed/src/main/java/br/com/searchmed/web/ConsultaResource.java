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
import br.com.searchmed.core.entidades.Consulta;
import dto.ConsultaDTO;
import dto.InformacaoClassificarDTO;

@Named
@Path("consulta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConsultaResource extends AbstractResource {

	@Inject
	private ConsultaService consultaService;

	@Inject
	public ConsultaResource(Mapper mapper) {
		super.mapper = mapper;
	}

	@GET
	@Path("abrir")
	public Response abrir(@QueryParam("usuarioId") Long usuarioId, @QueryParam("medicoId") Long medicoId,
			@QueryParam("especialidadeId") Long especialidadeId, @QueryParam("horarioId") Long horarioId) {
		try{
			this.consultaService.abrir(usuarioId, medicoId, especialidadeId, horarioId);
			return Response.ok(true).build();
		}catch(Exception e){
			return Response.ok(false).build();
		}	
	}
	
	@GET
	@Path("consultasEmAndamento")
	public List<ConsultaDTO> consultasEmAndamento(@QueryParam("usuarioId") Long usuarioId) {
		List<Consulta> lst = this.consultaService.consultasEmAndamento(usuarioId);
		List<ConsultaDTO> retorno = super.mapList(lst, ConsultaDTO.class);
		return retorno;
	}
	
	@GET
	@Path("consultasAbertasPaciente")
	public List<ConsultaDTO> consultasAbertasPaciente(@QueryParam("usuarioId") Long usuarioId) {
		List<Consulta> lst = this.consultaService.consultasAbertasPaciente(usuarioId);
		List<ConsultaDTO> retorno = super.mapList(lst, ConsultaDTO.class);
		return retorno;
	}
	
	@GET
	@Path("listarConsultasDoDia")
	public List<ConsultaDTO> listarConsultasDoDia(@QueryParam("medicoId") Long medicoId) {
		List<Consulta> lst = this.consultaService.listarConsultasDoDia(medicoId);
		List<ConsultaDTO> retorno = super.mapList(lst, ConsultaDTO.class);
		return retorno;
	}

	@GET
	@Path("consultasAbertas")
	public List<ConsultaDTO> consultasAbertas(@QueryParam("medicoId") Long medicoId) {
		List<Consulta> lst = this.consultaService.listarConsultasAbertas(medicoId);
		List<ConsultaDTO> retorno = super.mapList(lst, ConsultaDTO.class);
		return retorno;
	}
	
	@GET
	@Path("consultasAntigas")
	public List<ConsultaDTO> consultasAntigas(@QueryParam("usuarioId") Long usuarioId) {
		List<Consulta> lst = this.consultaService.consultasAntigas(usuarioId);
		List<ConsultaDTO> retorno = super.mapList(lst, ConsultaDTO.class);
		return retorno;
	}
	
	@GET
	@Path("consultasAntigasMedico") // tela de notificacao
	public List<ConsultaDTO> consultasAntigasMedico(@QueryParam("medicoId") Long medicoId) {
		List<Consulta> lst = this.consultaService.consultasAntigasMedico(medicoId);
		List<ConsultaDTO> retorno = super.mapList(lst, ConsultaDTO.class);
		return retorno;
	}

	@GET
	@Path("classificacao") // tela de classificacao
	public List<ConsultaDTO> classificacoesPendentes(@QueryParam("usuarioId") Long usuarioId) {
		List<Consulta> lst = this.consultaService.classificacoesPendentes(usuarioId);
		List<ConsultaDTO> retorno = super.mapList(lst, ConsultaDTO.class);
		return retorno;
	}

	@GET
	@Path("agendar") // agendar
	public Response agendar(@QueryParam("consultaId") Long consultaId) {
		this.consultaService.agendar(consultaId);
		return Response.ok().build();
	}

	@POST
	@Path("rejeitar") // rejeitar
	public Response rejeitar(@QueryParam("consultaId") Long consultaId) {
		this.consultaService.rejeitar(consultaId);
		return Response.ok().build();
	}

	@POST
	@Path("classificar") // classificar
	public Response classificar(@QueryParam("consultaId") Long consultaId, InformacaoClassificarDTO info) {		
		try{
			this.consultaService.classificar(info.getNota(), info.getRecomendacao(), consultaId);
			return Response.ok(true).build();
		}catch(Exception e){
			return Response.ok(false).build();
		}	
	}	
	
	@GET
	@Path("favorito")
	public Response favorito(@QueryParam("usuarioId") Long usuarioId, @QueryParam("medicoId") Long medicoId){
		boolean b = consultaService.favorito(medicoId, usuarioId);		
		return Response.ok(b).build();
	}	

}