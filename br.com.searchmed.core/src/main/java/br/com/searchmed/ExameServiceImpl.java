package br.com.searchmed;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.core.entidades.ConsultaExame;
import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.core.entidades.Laboratorio;
import br.com.searchmed.core.entidades.LaboratorioExame;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class ExameServiceImpl implements ExameService {
	
	@Inject
	private LaboratorioRepository laboratorioRep;

	@Inject
	private ExameRepository exameRep;
	
	@Inject
	private ConsultaService consultaService;
	
	@Inject
	private ConsultaExameService consultaExameService;

	public Exame obterPorId(Long id) {
		return exameRep.obterPorId(id);
	}

	@Override
	public Exame salvar(String descricao) {
		try {
			return this.exameRep.salvar(new Exame(descricao));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Exame> getExames() {
		List<Exame> lst = null;
		try {
			lst = this.exameRep.getExames();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;		
	}

	@Override
	public List<ConsultaExame> getExamesUsuario(Long usuarioId) {
		List<ConsultaExame> lst = new ArrayList<ConsultaExame>();
		List<Consulta> consultasEmAndamento = consultaService.consultasEmAndamento(usuarioId);
		
		for(Consulta c : consultasEmAndamento){
			lst.addAll(this.consultaExameService.obterPorConsulta(c.getId()));
		}
		return lst;	
	}

	@Override
	public List<Laboratorio> listarLaboratorios(Long exameId) {
		return this.exameRep.listarLaboratorios(exameId);
	}

	@Override
	public List<ConsultaExame> getExamesConsulta(Long consultaId) {
		List<ConsultaExame> c = consultaService.obterPorConsulta(consultaId);
		return c;
	}

	@Override
	public void agenda(Long agenda, Long laboratorioId, Long consultarExameId) {
		Calendar hoje = Calendar.getInstance();
		hoje.setTimeInMillis(agenda);
		
		Laboratorio lab = this.laboratorioRep.obterPorId(laboratorioId);
		LaboratorioExame laboratorioExame = null;
		
		if(lab!=null){
			for(LaboratorioExame le : lab.getExames()){
				if(le.getId().equals(consultarExameId)){
					laboratorioExame = le;
					break;
				}
			}
			
			ConsultaExame consultarExame = this.consultaExameService.obterPorId(consultarExameId);
			consultarExame.setRealizou(hoje.getTime());
			consultarExame.setLaboratorioExame(laboratorioExame);
			
			this.consultaExameService.salvar(consultarExame);
		}		
	}
}