package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.ConsultaExame;
import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.core.entidades.Laboratorio;

interface ExameRepository {

	Exame obterPorId(Long id);

	Exame salvar(Exame obj);

	void persist(Exame obj);

	void excluir(Exame obj);
	
	List<Exame> listar();

	List<Exame> getExames() throws Exception;

	List<ConsultaExame> getExamesConsulta(Long usuarioId);

	List<Laboratorio> listarLaboratorios(Long exameId);

}
