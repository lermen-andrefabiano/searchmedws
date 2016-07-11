package br.com.searchmed;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.core.entidades.ConsultaClassificacao;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestConsultaClassificacaoHibernate extends AbstractSpringTest {

	@Inject
	private ConsultaClassificaocaoRepository classificaocaoRep;

	@Ignore
	@Test
	public void obterPorId() {
		assertNotNull(this.classificaocaoRep.obterPorId(1L));
	}

	@Ignore
	@Test
	public void salvar() {
		ConsultaClassificacao c = new ConsultaClassificacao(9L, "recomendo", new Consulta(3L));
		this.classificaocaoRep.persist(c);
	}

	@Ignore
	@Test
	public void excluir() {
		ConsultaClassificacao m = this.classificaocaoRep.obterPorId(3L);

		if (isResult(m, "excluir")) {
			this.classificaocaoRep.excluir(m);
		}

	}
}
