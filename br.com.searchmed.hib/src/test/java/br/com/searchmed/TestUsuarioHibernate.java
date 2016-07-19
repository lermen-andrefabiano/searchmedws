package br.com.searchmed;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.Especialidade;
import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.core.enuns.TipoUsuario;
import br.com.searchmed.core.entidades.MedicoEspecialidade;
import br.com.searchmed.core.entidades.MedicoFavorito;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestUsuarioHibernate extends AbstractSpringTest {

	@Inject
	private UsuarioRepository usuarioRep;
	
	//@Ignore
	@Test
	public void obterPorId() {
		Usuario u = this.usuarioRep.obterPorId(2L);
		
		for(MedicoFavorito m : u.getFavoritos()){
			log.debug(m.getId()+"");
		}
		
		assertNotNull(u);
	}

	@Ignore
	@Test
	public void salvarMedicoUm() {
		Usuario p = new Usuario();
		p.setNome("Medico da silva");
		p.setEmail("medicoum@bol.com.br");
		p.setEndereco("av brasil");
		p.setSenha("1234");
		p.setTipo(TipoUsuario.M);

		Medico m = new Medico();
		m.setCrm("13245");
		List<MedicoEspecialidade> especialidades = new ArrayList<MedicoEspecialidade>();

		especialidades.add(new MedicoEspecialidade(15L, new Especialidade(1L), m));
		especialidades.add(new MedicoEspecialidade(10L, new Especialidade(2L), m));
		especialidades.add(new MedicoEspecialidade(10L, new Especialidade(3L), m));
		especialidades.add(new MedicoEspecialidade(10L, new Especialidade(4L), m));
		especialidades.add(new MedicoEspecialidade(10L, new Especialidade(5L), m));

		m.setEspecialidades(especialidades);
		m.setUsuario(p);

		p.setMedico(m);
		this.usuarioRep.persist(p);
	}

	@Ignore
	@Test
	public void salvarMedicoDois() {
		Usuario p = new Usuario();
		p.setNome("Medico Dois");
		p.setEmail("medicodois@bol.com.br");
		p.setEndereco("av brasil");
		p.setSenha("1234");
		p.setTipo(TipoUsuario.M);

		Medico m = new Medico();
		m.setCrm("13245");
		List<MedicoEspecialidade> especialidades = new ArrayList<MedicoEspecialidade>();

		especialidades.add(new MedicoEspecialidade(150L, new Especialidade(11L), m));
		especialidades.add(new MedicoEspecialidade(100L, new Especialidade(21L), m));
		especialidades.add(new MedicoEspecialidade(100L, new Especialidade(31L), m));
		especialidades.add(new MedicoEspecialidade(100L, new Especialidade(41L), m));
		especialidades.add(new MedicoEspecialidade(100L, new Especialidade(51L), m));

		m.setEspecialidades(especialidades);
		m.setUsuario(p);

		p.setMedico(m);
		this.usuarioRep.persist(p);
	}

	@Ignore
	@Test
	public void salvarMedicoTres() {
		Usuario p = new Usuario();
		p.setNome("Medico Tres");
		p.setEmail("medicotres@bol.com.br");
		p.setEndereco("av brasil");
		p.setSenha("1234");
		p.setTipo(TipoUsuario.M);

		Medico m = new Medico();
		m.setCrm("13245");
		List<MedicoEspecialidade> especialidades = new ArrayList<MedicoEspecialidade>();

		especialidades.add(new MedicoEspecialidade(1500L, new Especialidade(12L), m));
		especialidades.add(new MedicoEspecialidade(1000L, new Especialidade(13L), m));
		especialidades.add(new MedicoEspecialidade(1000L, new Especialidade(14L), m));
		especialidades.add(new MedicoEspecialidade(1000L, new Especialidade(15L), m));
		especialidades.add(new MedicoEspecialidade(1000L, new Especialidade(20L), m));

		m.setEspecialidades(especialidades);

		m.setUsuario(p);
		p.setMedico(m);
		this.usuarioRep.persist(p);
	}
	
	@Ignore
	@Test
	public void salvarUsuarioComum() {
		Usuario c = new Usuario();
		c.setNome("andre fabiano lermen");
		c.setEmail("lermen.andre@bol.com.br");
		c.setEndereco("av brasil, 100");
		c.setSenha("1234");
		c.setTipo(TipoUsuario.C);

		this.usuarioRep.persist(c);

	}	

	@Ignore
	@Test
	public void excluir() {
		Usuario u = this.usuarioRep.obterPorId(3L);

		if (isResult(u, "excluir")) {
			this.usuarioRep.excluir(u);
		}

	}

	@Ignore
	@Test
	public void obterPorEmail() {
		Usuario u = null;
		try {
			u = this.usuarioRep.obterPorEmail("home@home.com.br");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (isResult(u, "obterPorEmail")) {
			log.debug(u.getNome());
		}

	}
}
