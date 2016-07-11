package br.com.searchmed;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.ConsultaAgenda;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class ConsultaAgendaServiceImpl implements ConsultaAgendaService {

	@Inject
	private ConsultaAgendaRepository consultaAgendaRep;

	@Override
	public ConsultaAgenda obterPorConsulta(Long chamadoId) {
		try {
			return consultaAgendaRep.obterPorConsulta(chamadoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}