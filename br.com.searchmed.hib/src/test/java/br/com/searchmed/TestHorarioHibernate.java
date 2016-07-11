package br.com.searchmed;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.enuns.TipoDia;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestHorarioHibernate extends AbstractSpringTest {

	@Inject
	private MedicoHorarioRepository medicoHorarioRep;

	@Inject
	private MedicoRepository medicoRep;

	@Ignore
	@Test
	public void salvar() {
		Medico m = this.medicoRep.obterPorId(4L);
		Medico m2 = this.medicoRep.obterPorId(3L);

		//assertNotNull(this.medicoHorarioRep.salvar(new MedicoHorario(new Date(), new Date(), true, m)));
		//assertNotNull(this.medicoHorarioRep.salvar(new MedicoHorario(new Date(), new Date(), true, m2)));
		assertNotNull(this.medicoHorarioRep.salvar(new MedicoHorario(TipoDia.SEGUNDA, new Date(), new Date(), true, m2, false)));
		assertNotNull(this.medicoHorarioRep.salvar(new MedicoHorario(TipoDia.TERCA, new Date(), new Date(), false, m2, false)));
		assertNotNull(this.medicoHorarioRep.salvar(new MedicoHorario(TipoDia.QUINTA, new Date(), new Date(), false, m2, false)));
		assertNotNull(this.medicoHorarioRep.salvar(new MedicoHorario(TipoDia.SEXTA, new Date(), new Date(), false, m2, false)));

	}
	
	@Ignore
	@Test
	public void obterPorId() {
		MedicoHorario m = medicoHorarioRep.obterPorId(1L);
		
		log.debug(m.getOrderChegada()+"");
		
	}

}
