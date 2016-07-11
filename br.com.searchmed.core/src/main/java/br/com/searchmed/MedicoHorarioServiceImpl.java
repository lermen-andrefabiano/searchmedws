package br.com.searchmed;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.enuns.TipoDia;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class MedicoHorarioServiceImpl implements MedicoHorarioService {

	@Inject
	private MedicoHorarioRepository medicoHorarioRep;

	@Inject
	private MedicoRepository medicoRep;

	@Override
	public void excluir(Long id) {
		MedicoHorario u = this.medicoHorarioRep.obterPorId(id);
		this.medicoHorarioRep.excluir(u);
	}

	@Override
	public void incluir(String horarioId, TipoDia dia, Long medicoId, Date d1, Date d2, 
			Boolean ordemChegada, Boolean repetirHorario) {
		Medico m = this.medicoRep.obterPorId(medicoId);
		
		if(horarioId==null || horarioId.isEmpty()){
			if (m != null) {
				MedicoHorario h = new MedicoHorario(dia, d1, d2, ordemChegada, m, repetirHorario);
				this.medicoHorarioRep.persist(h);
			}
		}else{		
			MedicoHorario medicoHorario = this.medicoHorarioRep.obterPorId(Long.valueOf(horarioId));
			if(medicoHorario!=null){
				medicoHorario.setInicio(d1);
				medicoHorario.setFim(d2);
				medicoHorario.setOrderChegada(ordemChegada);
				medicoHorario.setRepetirHorario(repetirHorario);
				this.medicoHorarioRep.salvar(medicoHorario);
			}
		}		
	}

}