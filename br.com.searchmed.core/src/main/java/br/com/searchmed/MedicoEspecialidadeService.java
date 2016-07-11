package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoEspecialidade;

public interface MedicoEspecialidadeService {

	List<Medico> getMedicoEspecialidades(String convenio, Long especialidadeId);

	List<MedicoEspecialidade> getEspecialidaMedico(Long medicoId);

	void excluir(Long usuarioId, Long especialidadeId);

	void incluir(Long usuarioId, Long especialidadeId);

}
