package br.com.searchmed;

import javax.inject.Inject;

import org.junit.Test;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoFavorito;
import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestMedicoFavoritoHibernate extends AbstractSpringTest {

	@Inject
	private MedicoFavoritoRepository medicoFavoritoRep;

	//@Ignore
	@Test
	public void salvar() throws Exception {
		Usuario usuario = new Usuario(6L);
		Medico medico = new Medico(4L);
		MedicoFavorito obj = new MedicoFavorito(usuario, medico);
		medicoFavoritoRep.persist(obj);
	}

	//@Ignore
	@Test
	public void excluir() throws Exception {
		MedicoFavorito obj = medicoFavoritoRep.obterPorId(16L);
		medicoFavoritoRep.excluir(obj);
	}

}
