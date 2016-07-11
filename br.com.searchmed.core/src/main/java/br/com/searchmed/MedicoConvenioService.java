package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.MedicoConvenio;
import br.com.searchmed.core.entidades.MedicoHorario;

public interface MedicoConvenioService {

	List<MedicoConvenio> getMedicoConvenio(Long medicoId);

	void excluir(Long medicoId, String convenio);

	void incluir(Long medicoId, String convenio);

	List<MedicoHorario> getMedicoHorario(Long medicoId);


}
