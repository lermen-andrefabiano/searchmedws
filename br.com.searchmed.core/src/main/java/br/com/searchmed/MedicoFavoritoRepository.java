package br.com.searchmed;

import br.com.searchmed.core.entidades.MedicoFavorito;

interface MedicoFavoritoRepository {

	MedicoFavorito obterPorId(Long id);

	void persist(MedicoFavorito obj);

	MedicoFavorito salvar(MedicoFavorito obj);

	void excluir(MedicoFavorito obj);
	
	MedicoFavorito obterFavoritoUsuario(Long medicoId, Long usuarioId) throws Exception;

}
