package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import br.com.searchmed.core.entidades.Especialidade;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class EspecialidadeHibernate extends AbstractCrudHibernate<Especialidade, Long>
		implements EspecialidadeRepository {

	@Override
	public List<Especialidade> getEspecialidades() throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Especialidade> lst = getHibernateTemplate()
					.getSessionFactory().getCurrentSession()
					.createCriteria(Especialidade.class)				
					.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}
}
