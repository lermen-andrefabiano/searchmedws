package br.com.searchmed;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.core.entidades.Especialidade;
import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.core.enuns.TipoStatus;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestConsultaHibernate extends AbstractSpringTest {

	@Inject
	private ConsultaRepository consultaRep;

	//@Ignore
	@Test
	public void obterPorId() {		
		Consulta c = this.consultaRep.obterPorId(1L);	
		
		//Medico medico = new Medico();
		//medico.setId(9L);
		//c.setMedico(medico );
		//c.setExames(new ArrayList<ConsultaExame>());
		
		//Exame exame = new Exame();
		//exame.setId(1L);
		
		//ConsultaExame ce = new ConsultaExame(new Date(), TipoStatus.A, c, exame);
				
		//c.getExames().add(ce);
		
		c.setStatus(TipoStatus.F);
		
		consultaRep.salvar(c);
		
		assertNotNull(c);
	}

	@Ignore
	@Test
	public void salvar() {
		Consulta c = new Consulta(new Date(), TipoStatus.A, new Usuario(3L), new Medico(1L), new Especialidade(1L), new MedicoHorario(1L));

		this.consultaRep.persist(c);
	}

	@Ignore
	@Test
	public void excluir() {
		Consulta m = this.consultaRep.obterPorId(3L);

		if (isResult(m, "excluir")) {
			this.consultaRep.excluir(m);
		}
	}

	@Ignore
	@Test
	public void listarConsultasAbertas() {
		List<Consulta> lst = this.consultaRep.listarConsultasAbertas(1L);

		for (Consulta c : lst) {
			log.debug(c.getUsuario().getNome());
		}

	}

	@Ignore
	@Test
	public void classificacoesPendentes() {
		List<Consulta> lst = this.consultaRep.classificacoesPendentes(3L);

		for (Consulta c : lst) {
			log.debug(c.getUsuario().getNome());
		}

	}

}
