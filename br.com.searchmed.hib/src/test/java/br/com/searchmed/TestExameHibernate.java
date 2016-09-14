package br.com.searchmed;

import javax.inject.Inject;

import org.junit.Test;

import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestExameHibernate extends AbstractSpringTest {

	@Inject
	private ExameRepository exameRep;

	@Test
	public void salvar() {
		assertNotNull(this.exameRep.salvar(new Exame("Abdominoscopia")));
		assertNotNull(this.exameRep.salvar(new Exame("Aortografia")));
		assertNotNull(this.exameRep.salvar(new Exame("Hemadsorção")));
		assertNotNull(this.exameRep.salvar(new Exame("Imunofenotipagem")));
		assertNotNull(this.exameRep.salvar(new Exame("Teste de gravidez")));
		assertNotNull(this.exameRep.salvar(new Exame("Sigmoidoscopia")));
		assertNotNull(this.exameRep.salvar(new Exame("Reação de Agostini")));
	}
	
	@Test
	public void salvarLoinc() {
		assertNotNull(this.exameRep.salvar(new Exame("Imunofenotipagem", "55230-7","Immunophenotyping study")));
	}

}
