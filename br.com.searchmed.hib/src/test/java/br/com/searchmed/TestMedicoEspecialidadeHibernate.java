package br.com.searchmed;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestMedicoEspecialidadeHibernate extends AbstractSpringTest {

	@Inject
	private MedicoEspecialidadeRepository medicoEspecialidadeRep;

	@Ignore
	@Test
	public void getMedicoEspecialidades() throws Exception {
		List<Medico> lst = medicoEspecialidadeRep.getMedicoEspecialidades("Unimed", 31L);

		for (Medico m : lst) {
			System.out.println(m.getUsuario().getNome());
		}

	}

}
