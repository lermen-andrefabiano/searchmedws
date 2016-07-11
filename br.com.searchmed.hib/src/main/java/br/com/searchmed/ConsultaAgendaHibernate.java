package br.com.searchmed;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.ConsultaAgenda;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class ConsultaAgendaHibernate extends AbstractCrudHibernate<ConsultaAgenda, Long> implements
		ConsultaAgendaRepository {

	@Override
	public ConsultaAgenda obterPorConsulta(Long consultaId) throws Exception {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createCriteria(ConsultaAgenda.class);
			c.add(Restrictions.eq("consulta.id", consultaId));
			ConsultaAgenda a = (ConsultaAgenda) c.uniqueResult();
			return a;
		} catch (Exception e) {
			throw e;
		}
	}

}
