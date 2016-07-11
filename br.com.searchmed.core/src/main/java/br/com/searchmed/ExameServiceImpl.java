package br.com.searchmed;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Exame;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class ExameServiceImpl implements ExameService {

	@Inject
	private ExameRepository exameRep;

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
	public List<Exame> getExames(String str) {
		List<Exame> lst = null;
		try {
			lst = this.exameRep.getExames(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;		
	}

}