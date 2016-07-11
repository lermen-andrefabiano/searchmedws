package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class ExameHibernate extends AbstractCrudHibernate<Exame, Long> implements ExameRepository {

	@Override
	public List<Exame> getExames(String str) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Exame> lst = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Exame.class)
					.add(Restrictions.ilike("descricao", "%" + str + "%")).setMaxResults(MAX_RESULTS_LST).list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}
}
