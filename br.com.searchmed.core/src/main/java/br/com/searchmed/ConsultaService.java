package br.com.searchmed;

import java.util.List;

import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.core.entidades.ConsultaExame;

/**
 * 
 * Home Help.
 *
 * @author: andre.lermen
 * @since: 23/06/2015
 *
 *         Change History
 *
 * @author: andre.lermen
 * @date: 23/06/2015
 * @reason: Initial code.
 *
 */
public interface ConsultaService {

	void abrir(Long usuarioId, Long medicoId, Long especialidadeId, Long horarioId);

	void classificar(Long nota, String recomendacao, Long consultaId);

	List<Consulta> classificacoesPendentes(Long usuarioId);

	List<Consulta> listarConsultasAbertas(Long medicoId);

	void rejeitar(Long chamadoId);

	void agendar(Long consultaId);

	List<Consulta> consultasAntigas(Long usuarioId);

	void incluirExame(Long consultaId, Long exameId);

	void excluirExame(Long id, Long exameId);

	boolean favorito(Long medicoId, Long usuarioId);

	List<Consulta> consultasAbertasPaciente(Long usuarioId);

	List<Consulta> consultasAntigasMedico(Long medicoId);

	List<Consulta> listarConsultasDoDia(Long medicoId);

	List<Consulta> consultasEmAndamento(Long usuarioId);

	void fechar(Long consultaId);

	List<ConsultaExame> obterPorConsulta(Long consultaId);

}
