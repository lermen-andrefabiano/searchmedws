package br.com.searchmed.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import br.com.searchmed.MedicoConvenioService;
import br.com.searchmed.MedicoEspecialidadeService;
import br.com.searchmed.MedicoHorarioService;
import br.com.searchmed.core.entidades.MedicoConvenio;
import br.com.searchmed.core.entidades.MedicoEspecialidade;
import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.enuns.TipoDia;
import dto.InfoSalvarHorarioDTO;
import dto.MedicoConvenioDTO;
import dto.MedicoEspecialidadeDTO;
import dto.MedicoHorarioDTO;

@Named
@Path("medico")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicoResource extends AbstractResource {

	@Inject
	private MedicoConvenioService medicoConvenioService;
	
	@Inject
	private MedicoHorarioService medicoHorarioService;
	
	@Inject
	private MedicoEspecialidadeService usuarioEspecialidadeService;
	
	@Inject
	public MedicoResource(Mapper mapper) {
		super.mapper = mapper;
	}

	@GET
	@Path("getMedicoConvenio")
	public List<MedicoConvenioDTO> getMedicoConvenio(@QueryParam("medicoId") Long medicoId) {
		List<MedicoConvenio> lst = this.medicoConvenioService.getMedicoConvenio(medicoId);
		List<MedicoConvenioDTO> retorno = super.mapList(lst, MedicoConvenioDTO.class);
		return retorno;
	}

	@POST
	@Path("excluirC")
	public Response excluirC(@QueryParam("medicoId") Long medicoId, String convenio) {
		this.medicoConvenioService.excluir(medicoId, convenio);
		return Response.ok(true).build();
	}

	@POST
	@Path("incluirC")
	public Response incluirC(@QueryParam("medicoId") Long medicoId, String convenio) {
		medicoConvenioService.incluir(medicoId, convenio);
		return Response.ok(true).build();
	}	

	@GET
	@Path("getMedicoHorario")
	public List<MedicoHorarioDTO> getMedicoHorario(@QueryParam("medicoId") Long medicoId) {
		List<MedicoHorario> lst = this.medicoConvenioService.getMedicoHorario(medicoId);
		List<MedicoHorarioDTO> retorno = new ArrayList<MedicoHorarioDTO>();
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		
		for(MedicoHorario m : lst){
			MedicoHorarioDTO e = new MedicoHorarioDTO();
			e.setId(m.getId());
			e.setDia(m.getDia().name());
			e.setMedicoId(m.getMedico().getId());
			e.setOrderChegada(m.getOrderChegada());
			e.setRepetirHorario(m.getRepetirHorario());
			e.setInicio(format.format(m.getInicio()));
			e.setFim(format.format(m.getFim()));
			
			retorno.add(e);
		}
		return retorno;
	}
	
	@GET
	@Path("excluirH")
	public Response excluirH(@QueryParam("id") Long id) {
		this.medicoHorarioService.excluir(id);
		return Response.ok(true).build();
	}

	@POST
	@Path("incluirH")
	public Response incluirH(@QueryParam("medicoId") Long medicoId, List<InfoSalvarHorarioDTO> info) {
		Calendar inicio = Calendar.getInstance();
	    Calendar fim = Calendar.getInstance();
	   
		
		for(InfoSalvarHorarioDTO m : info){
		    String[] inicioSplit = m.getInicio().split(":");
		    String[] fimSplit = m.getFim().split(":");
		    
		    inicio.set(Calendar.HOUR_OF_DAY, Integer.valueOf(inicioSplit[0]));
		    inicio.set(Calendar.MINUTE, Integer.valueOf(inicioSplit[1]));
		    
		    fim.set(Calendar.HOUR_OF_DAY, Integer.valueOf(fimSplit[0]));
		    fim.set(Calendar.MINUTE, Integer.valueOf(fimSplit[1]));
		    		
			medicoHorarioService.incluir(
					m.getHorarioId(),
					TipoDia.valueOf(m.getDia()), 
					medicoId, 
					inicio.getTime(), 
					fim.getTime(), 
					m.getOrderChegada(), 
					m.getRepetirHorario());
		}	
		
		return Response.ok(true).build();
	}	
	
	@GET
	@Path("getEspecialidadesMedicas")
	public List<MedicoEspecialidadeDTO> getEspecialidadesMedicas(@QueryParam("medicoId") Long medicoId) {		
		List<MedicoEspecialidade> lst = usuarioEspecialidadeService.getEspecialidaMedico(medicoId);	
		List<MedicoEspecialidadeDTO> retorno = super.mapList(lst, MedicoEspecialidadeDTO.class);
		return retorno;
	}
	
	@GET
	@Path("excluirE")
	public Response excluirE(@QueryParam("usuarioId") Long usuarioId, @QueryParam("especialidadeId") Long especialidadeId) {		
		this.usuarioEspecialidadeService.excluir(usuarioId, especialidadeId);
		return Response.ok(true).build();
	}
	
	@GET
	@Path("incluirE")
	public Response incluirE(@QueryParam("usuarioId") Long usuarioId, @QueryParam("especialidadeId") Long especialidadeId) {		
		this.usuarioEspecialidadeService.incluir(usuarioId, especialidadeId);
		return Response.ok(true).build();
	}

}