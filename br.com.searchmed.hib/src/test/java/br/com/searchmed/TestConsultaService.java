package br.com.searchmed;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestConsultaService extends AbstractSpringTest {

	@Inject
	private ConsultaService consultaService;

	Long consultaId = 1L;

	Long usuarioId = 1L;

	Long medicoId = 2L;

	Long especialidaded = 5L;
	
	Long horarioId = 1L;
	
	@Ignore
	@Test
	public void abrir() {
		this.consultaService.abrir(usuarioId, medicoId, especialidaded, horarioId);
	}

	@Ignore
	@Test
	public void classificar() {
		this.consultaService.classificar(10L, "recomendo", consultaId);
	}

	@Ignore
	@Test
	public void listarPorUsuario() {
		List<Consulta> lst = this.consultaService.classificacoesPendentes(usuarioId);

		for (Consulta c : lst) {
			log.debug(c.getId() + " " + c.getUsuario().getNome());
		}

	}

	@Ignore
	@Test
	public void listarConsultasAbertas() {
		List<Consulta> lst = this.consultaService.listarConsultasAbertas(medicoId);

		for (Consulta c : lst) {
			log.debug(c.getId() + " " + c.getUsuario().getNome());
		}

	}

}
