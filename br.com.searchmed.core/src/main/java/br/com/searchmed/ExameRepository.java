package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.Exame;

interface ExameRepository {

	Exame obterPorId(Long id);

	Exame salvar(Exame obj);

	void persist(Exame obj);

	void excluir(Exame obj);

	List<Exame> getExames() throws Exception;

}
