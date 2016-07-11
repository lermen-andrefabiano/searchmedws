package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.Especialidade;

interface EspecialidadeRepository {

	Especialidade obterPorId(Long id);

	Especialidade salvar(Especialidade obj);

	void persist(Especialidade obj);

	void excluir(Especialidade obj);

	List<Especialidade> getEspecialidades() throws Exception;

}
