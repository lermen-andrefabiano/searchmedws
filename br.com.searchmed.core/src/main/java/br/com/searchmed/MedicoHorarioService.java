package br.com.searchmed;

import java.util.Date;

import br.com.searchmed.core.enuns.TipoDia;

public interface MedicoHorarioService {

	void excluir(Long id);

	void incluir(String horarioId, TipoDia dia, Long medicoId, Date d1, Date d2, Boolean ordemChegada, Boolean repetirHorario);

	void tarefaHorarioMedico();

}
