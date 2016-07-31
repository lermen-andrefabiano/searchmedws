package br.com.searchmed;

import br.com.searchmed.core.entidades.MedicoHorario;
import java.util.List;

interface MedicoHorarioRepository {

	MedicoHorario obterPorId(Long id);

	void persist(MedicoHorario obj);

	MedicoHorario salvar(MedicoHorario obj);

	void excluir(MedicoHorario obj);
	
	List<MedicoHorario> listarHorariosAbertos();

}
