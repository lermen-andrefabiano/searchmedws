package br.com.searchmed;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.ConsultaAgenda;
import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.core.enuns.TipoAgenda;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestConsultaAgendaHibernate extends AbstractSpringTest {

	@Inject
	private ConsultaAgendaRepository agendaRep;

	@Ignore
	@Test
	public void obterPorId() {
		assertNotNull(this.agendaRep.obterPorId(1L));
	}

	@Ignore
	@Test
	public void salvar() {
		ConsultaAgenda a = new ConsultaAgenda(new Date(), TipoAgenda.A, new Consulta(3L));

		this.agendaRep.persist(a);
	}

	@Ignore
	@Test
	public void excluir() {
		ConsultaAgenda m = this.agendaRep.obterPorId(3L);

		if (isResult(m, "excluir")) {
			this.agendaRep.excluir(m);
		}

	}
}
