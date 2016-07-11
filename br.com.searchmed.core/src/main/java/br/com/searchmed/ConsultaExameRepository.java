package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.ConsultaExame;

interface ConsultaExameRepository {

	ConsultaExame obterPorId(Long id);

	void persist(ConsultaExame obj);

	ConsultaExame salvar(ConsultaExame obj);

	void excluir(ConsultaExame obj);

	List<ConsultaExame> obterPorConsulta(Long id) throws Exception;

}
