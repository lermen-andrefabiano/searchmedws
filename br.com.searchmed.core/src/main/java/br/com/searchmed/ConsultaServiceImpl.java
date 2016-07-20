package br.com.searchmed;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.core.entidades.ConsultaAgenda;
import br.com.searchmed.core.entidades.ConsultaClassificacao;
import br.com.searchmed.core.entidades.ConsultaExame;
import br.com.searchmed.core.entidades.Especialidade;
import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoFavorito;
import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.core.enuns.TipoAgenda;
import br.com.searchmed.core.enuns.TipoStatus;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class ConsultaServiceImpl implements ConsultaService {

	@Inject
	private ConsultaRepository consultaRep;

	@Inject
	private ConsultaAgendaRepository consultaAgendaRep;

	@Inject
	private ConsultaClassificaocaoRepository consultaClassificaocaoRep;

	@Inject
	private UsuarioRepository usuarioRep;

	@Inject
	private MedicoRepository medicoRep;

	@Inject
	private EspecialidadeRepository especialidadeRep;
	
	@Inject
	private ExameRepository exameRep;

	@Inject
	private ConsultaExameRepository consultaExameRep;
	
	@Inject
	private MedicoHorarioRepository medicoHorarioRep;
	
	@Inject
	private MedicoFavoritoRepository medicoFavoritoRep;
	
	@Override
	public void abrir(Long usuarioId, Long medicoId, Long especialidadeId, Long horarioId) {
		Usuario usuario = usuarioRep.obterPorId(usuarioId);
		Medico medico = medicoRep.obterPorId(medicoId);
		Especialidade especialidade = especialidadeRep.obterPorId(especialidadeId);
		MedicoHorario h = medicoHorarioRep.obterPorId(horarioId);

		Consulta c = new Consulta(new Date(), TipoStatus.A, usuario, medico, especialidade, h);

		this.consultaRep.persist(c);
	}

	@Override
	public void agendar(Long consultaId) {
		Consulta c = this.consultaRep.obterPorId(consultaId);
		c.setStatus(TipoStatus.E);

		this.consultaRep.salvar(c);
	}

	@Override
	public void rejeitar(Long consultaId) {
		Consulta c = this.consultaRep.obterPorId(consultaId);
		c.setStatus(TipoStatus.R);
		this.consultaRep.salvar(c);
	}

	@Override
	public void classificar(Long nota, String recomendacao, Long consultaId) {
		Consulta consulta = consultaRep.obterPorId(consultaId);

		ConsultaClassificacao classificacao = new ConsultaClassificacao(nota, recomendacao, consulta);

		classificacao = this.consultaClassificaocaoRep.salvar(classificacao);
		consulta.setStatus(TipoStatus.F);
		
		consulta.setClassificacao(classificacao);

		this.consultaRep.salvar(consulta);

		this.atualizarAgenda(consultaId);
	}

	private void atualizarAgenda(Long consultaId) {
		ConsultaAgenda a = null;
		try {
			a = this.consultaAgendaRep.obterPorConsulta(consultaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (a != null) {
			a.setStatus(TipoAgenda.F);
			this.consultaAgendaRep.salvar(a);
		}
	}

	@Override
	public List<Consulta> classificacoesPendentes(Long usuarioId) {
		try {
			List<Consulta> result = this.consultaRep.classificacoesPendentes(usuarioId);		
			getExamesConsulta(result);
			return result;
		} catch (Exception e) {			
		}
		return null;	
	}

	private void getExamesConsulta(List<Consulta> result) throws Exception{
		for(Consulta c : result){			
			c.setExames(this.consultaExameRep.obterPorConsulta(c.getId()));
		}	
	}
	
	@Override
	public List<Consulta> consultasAbertasPaciente(Long usuarioId) {
		try {
			List<Consulta> result = this.consultaRep.consultasAbertasPaciente(usuarioId);		
			getExamesConsulta(result);
			return result;
		} catch (Exception e) {			
		}
		return null;
	}
	
	@Override
	public List<Consulta> listarConsultasDoDia(Long medicoId) {
		try {
			List<Consulta> result = this.consultaRep.listarConsultasDoDia(medicoId);		
			getExamesConsulta(result);
			return result;
		} catch (Exception e) {			
		}
		return null;
	}
	
	@Override
	public List<Consulta> listarConsultasAbertas(Long medicoId) {
		try {
			List<Consulta> result = this.consultaRep.listarConsultasAbertas(medicoId);		
			getExamesConsulta(result);
			return result;
		} catch (Exception e) {			
		}
		return null;
	}

	@Override
	public List<Consulta> consultasAntigas(Long usuarioId) {
		try {
			List<Consulta> result = this.consultaRep.consultasAntigas(usuarioId);	
			getExamesConsulta(result);
			return result;
		} catch (Exception e) {			
		}
		return null;		
	}
	
	@Override
	public List<Consulta> consultasAntigasMedico(Long medicoId) {
		try {
			List<Consulta> result = this.consultaRep.consultasAntigasMedico(medicoId);	
			getExamesConsulta(result);
			return result;
		} catch (Exception e) {			
		}
		return null;		
	}

	@Override
	public void incluirExame(Long consultaId, Long exameId) {
		try {
			Consulta consulta = consultaRep.obterPorId(consultaId);		
			Exame exame = exameRep.obterPorId(exameId);
			
			ConsultaExame consultaExame = new ConsultaExame(new Date(), TipoStatus.A, consulta, exame);
			
			consultaExameRep.persist(consultaExame);
		} catch (Exception e) {			
		}		
	}

	@Override
	public void excluirExame(Long id) {
		try {
			ConsultaExame consultaExame = consultaExameRep.obterPorId(id);
			consultaExameRep.excluir(consultaExame);
		} catch (Exception e) {
		}		
	}
	
	@Override
	public boolean favorito(Long medicoId, Long usuarioId) {
		try {
			MedicoFavorito f = medicoFavoritoRep.obterFavoritoUsuario(medicoId, usuarioId);
			
			if(f==null){				
				Usuario usuario = new Usuario(usuarioId);
				Medico medico = new Medico(medicoId);		
				MedicoFavorito obj = new MedicoFavorito(usuario, medico);
				medicoFavoritoRep.salvar(obj);		
				return true;
			}else{
				medicoFavoritoRep.excluir(f);
				return false;
			}		
		} catch (Exception e) {
			return false;
		}		
	}
	
}