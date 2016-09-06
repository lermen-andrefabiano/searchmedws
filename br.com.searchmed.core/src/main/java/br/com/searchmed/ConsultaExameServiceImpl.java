package br.com.searchmed;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.ConsultaExame;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class ConsultaExameServiceImpl implements ConsultaExameService {

	@Inject
	private ConsultaExameRepository consultaExameRep;	

	@Override
	public List<ConsultaExame> getExamesUsuario(Long usuarioId) {
		try {
			return consultaExameRep.getExamesUsuario(usuarioId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ConsultaExame obterPorId(Long id) {
		return consultaExameRep.obterPorId(id);
	}

	@Override
	public ConsultaExame salvar(ConsultaExame obj) {
		return consultaExameRep.salvar(obj);
	}
	
}