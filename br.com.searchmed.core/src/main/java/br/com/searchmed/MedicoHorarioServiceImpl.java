package br.com.searchmed;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.enuns.TipoDia;
import br.com.searchmed.core.enuns.TipoHorario;

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

	@Override
	public void tarefaHorarioMedico() {
		System.out.println("tarefaHorarioMedico");
		
		Calendar hoje = Calendar.getInstance();
		Calendar inicio = Calendar.getInstance();
	    Calendar fim = Calendar.getInstance();	
	    int diaSemana = hoje.get(Calendar.DAY_OF_WEEK);	
	    
		List<MedicoHorario> horarios = this.medicoHorarioRep.listarHorariosAbertos();
		
		for(MedicoHorario h : horarios){
			TipoDia tipoDia = h.getDia();
			int somaDia = 0;
			
		    if(diaSemana < tipoDia.getDia()){
		    	somaDia = tipoDia.getDia() - diaSemana;
		    }else{
		    	somaDia = tipoDia.getDia()+1;
		    }
		    
			inicio.setTime(h.getInicio());
			fim.setTime(h.getFim());
			
			inicio.add(Calendar.DAY_OF_MONTH, somaDia);
			fim.add(Calendar.DAY_OF_MONTH, somaDia);
			
			//this.incluir(null, h.getDia(), h.getMedico().getId(), inicio.getTime(), fim.getTime(), h.getOrderChegada(), h.getRepetirHorario());
			
			h.setStatus(TipoHorario.F);
			
			//this.medicoHorarioRep.salvar(h);
		}	
		
	}
}