package br.com.searchmed;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Especialidade;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Inject
	private EspecialidadeRepository especialidadeRep;

	public Especialidade obterPorId(Long especialidadeId) {
		return especialidadeRep.obterPorId(especialidadeId);
	}

	@Override
	public Especialidade salvar(String descricao) {
		try {
			return this.especialidadeRep.salvar(new Especialidade(descricao));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Especialidade> getEspecialidades() throws Exception {
		try {
			return this.especialidadeRep.getEspecialidades();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}