package br.com.searchmed;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.core.entidades.Laboratorio;
import br.com.searchmed.core.entidades.LaboratorioExame;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestLaboratorioHibernate extends AbstractSpringTest {

	@Inject
	private LaboratorioRepository laboratorioRep;

	@Inject
	private ExameRepository exameRep;	
	
	@Test
	public void listarLab() {
		List<Laboratorio> lst = exameRep.listarLaboratorios(1L);

		for (Laboratorio l : lst) {
			log.debug(l.getId() +" " +l.getNome());
			for (LaboratorioExame e : l.getExames()) {
				log.debug(e.getExame().getDescricao());
			}
		}
	}
	
	@Test
	public void listarGeralLab() {
		List<Laboratorio> lst = laboratorioRep.listar();

		for (Laboratorio l : lst) {
			log.debug(l.getId() +" " +l.getNome());
			for (LaboratorioExame e : l.getExames()) {
				log.debug(e.getExame().getDescricao());
			}
		}
	}

	@Test
	public void listar() {
		List<Exame> exames = exameRep.listar();

		for (Exame e : exames) {
			log.debug(e.getDescricao());
		}
	}

	@Test
	public void persist() {
		List<Exame> exames = exameRep.listar(); // 7 exames
		
		Laboratorio l = new Laboratorio();
		l.setCnpj("9999999999999");
		l.setNome("Clínica Um");
		l.setExames(new ArrayList<LaboratorioExame>());
		
		LaboratorioExame le = new LaboratorioExame();
		le.setLaboratorio(l);
		le.setExame(exames.get(0));
		l.getExames().add(le);
		
		LaboratorioExame le1 = new LaboratorioExame();
		le1.setLaboratorio(l);
		le1.setExame(exames.get(1));
		l.getExames().add(le1);
		
		laboratorioRep.persist(l);		
		
		Laboratorio l1 = new Laboratorio();
		l1.setCnpj("9999999999999");
		l1.setNome("Clínica Um");
		l1.setExames(new ArrayList<LaboratorioExame>());
		
		LaboratorioExame le2 = new LaboratorioExame();
		le2.setLaboratorio(l1);
		le2.setExame(exames.get(2));
		l1.getExames().add(le2);
		
		LaboratorioExame le12 = new LaboratorioExame();
		le12.setLaboratorio(l1);
		le12.setExame(exames.get(3));
		l1.getExames().add(le12);
		
		laboratorioRep.persist(l1);
	}
	
	@Test
	public void persist2() {
		List<Exame> exames = exameRep.listar(); // 7 exames
		
		Laboratorio l = new Laboratorio();
		l.setCnpj("9999999999999");
		l.setNome("Clínica Dois");
		l.setExames(new ArrayList<LaboratorioExame>());
		
		LaboratorioExame le = new LaboratorioExame();
		le.setLaboratorio(l);
		le.setExame(exames.get(0));
		l.getExames().add(le);
		
		LaboratorioExame le1 = new LaboratorioExame();
		le1.setLaboratorio(l);
		le1.setExame(exames.get(1));
		l.getExames().add(le1);		
		
		LaboratorioExame le2 = new LaboratorioExame();
		le2.setLaboratorio(l);
		le2.setExame(exames.get(2));
		l.getExames().add(le2);
		
		LaboratorioExame le12 = new LaboratorioExame();
		le12.setLaboratorio(l);
		le12.setExame(exames.get(3));
		l.getExames().add(le12);
		
		laboratorioRep.persist(l);
	}
}
