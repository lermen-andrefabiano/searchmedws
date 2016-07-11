package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.Exame;

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
public interface ExameService {

	Exame obterPorId(Long id);

	Exame salvar(String descricao);

	List<Exame> getExames(String str);

}
