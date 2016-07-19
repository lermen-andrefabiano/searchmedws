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
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia da Mão")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia de Cabeça e Pescoço")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia do Aparelho Digestório")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Geral")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Pediátrica")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Plástica")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Torácica")));        
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Cirurgia Vascular")));        
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Clínica Médica")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Coloproctologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Dermatologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Endocrinologia e Metabologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Endoscopia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Gastroenterologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Genética médica")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Geriatria")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Ginecologia e Obstetrícia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Hematologia e Hemoterapia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Homeopatia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Infectologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Mastologia")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina de Família e Comunidade")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina do Trabalho")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina do Tráfego")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina Esportiva")));
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Medicina Física e Reabilitação")));
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
        assertNotNull(this.especialidadeRep.salvar(new Especialidade("Radiologia e Diagnóstico por Imagem")));
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
