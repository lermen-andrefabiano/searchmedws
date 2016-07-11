package br.com.searchmed;

import br.com.searchmed.core.entidades.ConsultaAgenda;

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
public interface ConsultaAgendaService {

	ConsultaAgenda obterPorConsulta(Long consultaId);

}
