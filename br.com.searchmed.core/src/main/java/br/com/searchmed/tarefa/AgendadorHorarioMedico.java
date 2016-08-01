package br.com.searchmed.tarefa;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import br.com.searchmed.MedicoHorarioService;

public class AgendadorHorarioMedico {

	@Inject
	private MedicoHorarioService medicoHorarioService;

	public void inicia() throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy – hh:mm:ss");
		System.out.println("Rodou tarefa cadastro horario médico: "	+ dateFormat.format(new Date()));

		medicoHorarioService.tarefaHorarioMedico();

	}

}
