package br.com.searchmed;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

import br.com.searchmed.core.entidades.Especialidade;
import br.com.searchmed.test.spring.AbstractSpringTest;

public class TestEspecialidadeHibernate extends AbstractSpringTest {

    @Inject
    private EspecialidadeRepository especialidadeRep;

    @Ignore
    @Test
    public void obterPorId() {
        assertNotNull(this.especialidadeRep.obterPorId(1L));
    }
    
    //@Ignore
    @Test
    public void salvar() {
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Acupuntura")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Alergia e Imunologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Anestesiologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Angiologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cancerologia (oncologia)")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cardiologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Cardiovascular")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia da M�o")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia de Cabe�a e Pesco�o")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia do Aparelho Digest�rio")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Geral")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Pedi�trica")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Pl�stica")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Tor�cica")));        
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Vascular")));        
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cl�nica M�dica")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Coloproctologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Dermatologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Endocrinologia e Metabologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Endoscopia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Gastroenterologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Gen�tica m�dica")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Geriatria")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Ginecologia e Obstetr�cia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Hematologia e Hemoterapia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Homeopatia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Infectologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Mastologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina de Fam�lia e Comunidade")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina do Trabalho")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina do Tr�fego")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina Esportiva")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina F�sica e Reabilita��o")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina Intensiva")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina Legal")));       
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina Nuclear")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina Preventiva e Social")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Nefrologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Neurocirurgia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Neurologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Nutrologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Oftalmologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Ortopedia e Traumatologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Otorrinolaringologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Patologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Pediatria")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Neonatologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Pneumologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Psiquiatria")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Radiologia e Diagn�stico por Imagem")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Radioterapia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Reumatologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Urologia")));       
    }

    @Ignore
    @Test
    public void excluir() {
        Especialidade m = this.especialidadeRep.obterPorId(3L);

        if (isResult(m, "excluir")) {
            this.especialidadeRep.excluir(m);
        }

    }
}
