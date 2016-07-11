package br.com.searchmed;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Especialidade;
import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoEspecialidade;
import br.com.searchmed.core.entidades.Usuario;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class MedicoEspecialidadeServiceImpl implements
		MedicoEspecialidadeService {

	@Inject
	private MedicoEspecialidadeRepository medicoEspecialidadeRep;
	
	@Inject
	private MedicoRepository medicoRep;	
	
	@Inject
	private UsuarioRepository usuarioRep;		
	
	@Inject
	private EspecialidadeService especialidadeService;

	@Override
	public List<Medico> getMedicoEspecialidades(String convenio, Long especialidadeId) {
		try {
			return this.medicoEspecialidadeRep.getMedicoEspecialidades(convenio, especialidadeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MedicoEspecialidade> getEspecialidaMedico(Long medicoId) {
		return this.medicoEspecialidadeRep.getEspecialidaMedico(medicoId);
	}

	@Override
	public void excluir(Long usuarioId, Long especialidadeId) {
		Usuario u = this.usuarioRep.obterPorId(usuarioId);
		
		if(u!=null&&u.getMedico()!=null){			
			MedicoEspecialidade medicoEspecialidade = this.medicoEspecialidadeRep.obterPorMedico(u.getMedico().getId(), especialidadeId);
			this.medicoEspecialidadeRep.excluir(medicoEspecialidade);
		}	
		
	}	

	@Override
	public void incluir(Long usuarioId, Long especialidadeId) {
		Usuario u = this.usuarioRep.obterPorId(usuarioId);
		if(u!=null&&u.getMedico()!=null){
			if(u.getMedico().getEspecialidades()!=null){				
				u.getMedico().setEspecialidades(new ArrayList<MedicoEspecialidade>());
			}
			
			Especialidade e = this.especialidadeService.obterPorId(especialidadeId); 
			
			u.getMedico().getEspecialidades().add(new MedicoEspecialidade(0L, e, u.getMedico()));
			
			this.usuarioRep.salvar(u);
		}
	}	

}