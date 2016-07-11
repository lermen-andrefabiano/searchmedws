package br.com.searchmed;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoConvenio;
import br.com.searchmed.core.entidades.MedicoHorario;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class MedicoConvenioServiceImpl implements MedicoConvenioService {

	@Inject
	private MedicoConvenioRepository medicoConvenioRep;

	@Inject
	private MedicoRepository medicoRep;
	
	@Override
	public List<MedicoHorario> getMedicoHorario(Long medicoId) {
		return this.medicoConvenioRep.getMedicoHorario(medicoId);
	}

	@Override
	public List<MedicoConvenio> getMedicoConvenio(Long medicoId) {
		return this.medicoConvenioRep.getMedicoConvenio(medicoId);
	}

	@Override
	public void excluir(Long medicoId, String convenio) {
		Medico m = this.medicoRep.obterPorId(medicoId);
		
		if(m!=null){			
			MedicoConvenio medicoConvenio = this.medicoConvenioRep.obterPorMedico(medicoId, convenio);
			this.medicoConvenioRep.excluir(medicoConvenio);
		}			
	}

	@Override
	public void incluir(Long medicoId, String convenio) {
		Medico m = this.medicoRep.obterPorId(medicoId);
		if (m != null) {
			MedicoConvenio mC = new MedicoConvenio(convenio, m);

			this.medicoConvenioRep.persist(mC);
		}
	}


}