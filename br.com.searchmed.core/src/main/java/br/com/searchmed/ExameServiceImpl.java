package br.com.searchmed;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.core.entidades.ConsultaExame;
import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.core.entidades.Laboratorio;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class ExameServiceImpl implements ExameService {

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

}