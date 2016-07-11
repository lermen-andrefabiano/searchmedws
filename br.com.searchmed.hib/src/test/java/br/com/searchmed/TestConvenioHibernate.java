package br.com.searchmed;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoConvenio;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestConvenioHibernate extends AbstractSpringTest {

    @Inject
    private MedicoConvenioRepository medicoConvenioRep;
    
    @Inject
	private MedicoRepository medicoRep;
   
    @Ignore
    @Test
    public void salvar() {
       	Medico m3 = this.medicoRep.obterPorId(3L);
    	Medico m = this.medicoRep.obterPorId(4L);
    	Medico m2 = this.medicoRep.obterPorId(5L);
    	
        assertNotNull(this.medicoConvenioRep.salvar(new MedicoConvenio("Camed", m3)));
        //assertNotNull(this.medicoConvenioRep.salvar(new MedicoConvenio("Fassincra", m)));
        //assertNotNull(this.medicoConvenioRep.salvar(new MedicoConvenio("Geap", m)));
        //assertNotNull(this.medicoConvenioRep.salvar(new MedicoConvenio("Unimed", m)));
        //assertNotNull(this.medicoConvenioRep.salvar(new MedicoConvenio("Uniodonto", m)));
        
        //assertNotNull(this.medicoConvenioRep.salvar(new MedicoConvenio("Unimed", m2)));   
        //assertNotNull(this.medicoConvenioRep.salvar(new MedicoConvenio("Uniodonto", m2)));
       
        
       
    }

}
