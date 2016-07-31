package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoEspecialidade;
import br.com.searchmed.core.entidades.MedicoHorario;

interface MedicoEspecialidadeRepository {

    MedicoEspecialidade obterPorId(Long id);

    void persist(MedicoEspecialidade obj);

    MedicoEspecialidade salvar(MedicoEspecialidade obj);

    void excluir(MedicoEspecialidade obj);
    
    List<Medico> getMedicoEspecialidades(String convenio, Long especialidadeId) throws Exception;

	List<MedicoEspecialidade> getEspecialidaMedico(Long prestadorId);

	MedicoEspecialidade obterPorMedico(Long medicoId, Long especialidadeId);

	List<MedicoHorario> getHorarioMedico(Long id);
	

}
