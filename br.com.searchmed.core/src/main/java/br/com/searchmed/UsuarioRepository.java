package br.com.searchmed;

import br.com.searchmed.core.entidades.Usuario;

interface UsuarioRepository {

	Usuario obterPorId(Long id);

	void persist(Usuario obj);

	Usuario salvar(Usuario obj);

	void excluir(Usuario obj);

	Usuario obterPorEmail(String email) throws Exception;

}
