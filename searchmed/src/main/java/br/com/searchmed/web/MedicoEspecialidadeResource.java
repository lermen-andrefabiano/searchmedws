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

import org.dozer.Mapper;

import br.com.searchmed.EspecialidadeService;
import br.com.searchmed.MedicoEspecialidadeService;
import br.com.searchmed.core.entidades.Especialidade;
import br.com.searchmed.core.entidades.Medico;
import dto.EspecialidadeDTO;
import dto.MedicoDTO;

@Named
@Path("especialidade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicoEspecialidadeResource extends AbstractResource {

	@Inject
	private MedicoEspecialidadeService usuarioEspecialidadeService;
	
	@Inject
	private EspecialidadeService especialidadeService;

	@Inject
	public MedicoEspecialidadeResource(Mapper mapper) {
		super.mapper = mapper;
	}
	
	@GET	
	@Path("getMedicoEspecialidade")
	public List<MedicoDTO> getMedicoEspecialidade(@QueryParam("convenio") String convenio, @QueryParam("especialidadeId") Long especialidadeId) {		
		List<Medico> lst = usuarioEspecialidadeService.getMedicoEspecialidades(convenio, especialidadeId);		

		List<MedicoDTO> retorno = super.mapList(lst, MedicoDTO.class);

		return retorno;
	}
		
	@GET	
	@Path("getEspecialidades")
	public List<EspecialidadeDTO> getEspecialidades() {		
		List<Especialidade> lst = null;
		try {
			lst = especialidadeService.getEspecialidades();
			List<EspecialidadeDTO> retorno = super.mapList(lst, EspecialidadeDTO.class);
			return retorno;
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return null;		
	}	

}