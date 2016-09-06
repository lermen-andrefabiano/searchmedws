package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.ConsultaExame;

/**
 * 
 * Home Help.
 *
 * @author: andre.lermen
 * @since: 23/06/2015
 *
 *         Change History
 *
 * @author: andre.lermen
 * @date: 23/06/2015
 * @reason: Initial code.
 *
 */
public interface ConsultaExameService {

	List<ConsultaExame> getExamesUsuario(Long usuarioId);
	
	ConsultaExame obterPorId(Long id);
	
	ConsultaExame salvar(ConsultaExame obj);

}
