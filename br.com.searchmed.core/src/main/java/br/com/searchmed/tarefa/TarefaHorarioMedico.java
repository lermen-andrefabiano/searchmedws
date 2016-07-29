package br.com.searchmed.tarefa;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.searchmed.MedicoHorarioService;

@Named
public class TarefaHorarioMedico implements Job {
	
	@Inject
	private MedicoHorarioService medicoHorarioService;		

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy – hh:mm:ss");
		System.out.println("Rodou tarefa cadastro horario médico: " + dateFormat.format(new Date()));
		
		medicoHorarioService.tarefaHorarioMedico();
	}
}
