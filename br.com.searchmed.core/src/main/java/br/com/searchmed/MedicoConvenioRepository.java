package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.MedicoConvenio;
import br.com.searchmed.core.entidades.MedicoHorario;

interface MedicoConvenioRepository {

    MedicoConvenio obterPorId(Long id);

    void persist(MedicoConvenio obj);

    MedicoConvenio salvar(MedicoConvenio obj);

    void excluir(MedicoConvenio obj);

	MedicoConvenio obterPorMedico(Long medicoId, String convenio);

	List<MedicoConvenio> getMedicoConvenio(Long medicoId);

	List<MedicoHorario> getMedicoHorario(Long medicoId);
	
}
