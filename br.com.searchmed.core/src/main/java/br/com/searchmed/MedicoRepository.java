package br.com.searchmed;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.Usuario;

interface MedicoRepository {

	Medico obterPorId(Long id);

	void persist(Medico obj);

	Medico salvar(Medico obj);

	void excluir(Medico obj);

	Usuario obterUsuarioMedico(Long medicoId) throws Exception;

}
