package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class ExameHibernate extends AbstractCrudHibernate<Exame, Long> implements ExameRepository {

	@Override
	public List<Exame> getExames() throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Exame> lst = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Exame.class)
					.setMaxResults(MAX_RESULTS_LST).list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}
}
