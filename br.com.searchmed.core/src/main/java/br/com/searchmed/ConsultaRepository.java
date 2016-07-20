package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.Consulta;

interface ConsultaRepository {

	Consulta obterPorId(Long id);

	void persist(Consulta obj);

	Consulta salvar(Consulta obj);

	void excluir(Consulta obj);

	List<Consulta> classificacoesPendentes(Long usuarioId);

	List<Consulta> listarConsultasAbertas(Long medicoId);

	List<Consulta> consultasAntigas(Long usuarioId);

	List<Consulta> consultasAbertasPaciente(Long usuarioId);

	List<Consulta> consultasAntigasMedico(Long medicoId);

	List<Consulta> listarConsultasDoDia(Long medicoId);

}
