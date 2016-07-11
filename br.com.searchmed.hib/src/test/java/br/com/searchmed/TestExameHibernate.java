package br.com.searchmed;

import javax.inject.Inject;

import org.junit.Test;

import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestExameHibernate extends AbstractSpringTest {

    @Inject
    private ExameRepository exameRep;    
     
    //@Ignore
    @Test
    public void salvar() {
    	
    	Exame e = new Exame("Exame Teste");
    	
    	this.exameRep.persist(e);
    }

}
