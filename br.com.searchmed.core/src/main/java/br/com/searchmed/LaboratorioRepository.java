package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.Laboratorio;

interface LaboratorioRepository {

	Laboratorio obterPorId(Long id);

	void persist(Laboratorio obj);

	Laboratorio salvar(Laboratorio obj);

	void excluir(Laboratorio obj);
	
	List<Laboratorio> listar();

}