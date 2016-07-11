package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.Consulta;
import br.com.searchmed.core.enuns.TipoStatus;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class ConsultaHibernate extends AbstractCrudHibernate<Consulta, Long> implements
		ConsultaRepository {

	@Override
	public List<Consulta> classificacoesPendentes(Long usuarioId) {
		Criteria c = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Consulta.class);		
		c.createAlias("especialidade", "especialidade");
		c.createAlias("medico", "medico");
		c.createAlias("usuario", "usuario");
		c.createAlias("horario", "horario");
		c.add(Restrictions.eq("usuario.id", usuarioId));
		c.add(Restrictions.eq("status", TipoStatus.C));
		c.addOrder(Order.asc("data"));
		c.setMaxResults(MAX_RESULTS_LST);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Consulta> lst = c.list();
		return lst;
	}
	@Override
	public List<Consulta> listarConsultasAbertas(Long medicoId) {
		Criteria c = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Consulta.class);		
		c.createAlias("especialidade", "especialidade");
		c.createAlias("medico", "medico");
		c.createAlias("usuario", "usuario");
		c.createAlias("horario", "horario");
		c.add(Restrictions.eq("medico.id", medicoId));
		c.add(Restrictions.eq("status", TipoStatus.A));
		c.addOrder(Order.asc("data"));
		c.setMaxResults(MAX_RESULTS_LST);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Consulta> lst = c.list();
		return lst;
	}

	@Override
	public List<Consulta> consultasAntigas(Long usuarioId) {
		Criteria c = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(Consulta.class);		
		c.createAlias("especialidade", "especialidade");
		c.createAlias("medico", "medico");
		c.createAlias("usuario", "usuario");
		c.createAlias("horario", "horario");
		c.add(Restrictions.eq("usuario.id", usuarioId));
		c.add(Restrictions.eq("status", TipoStatus.F));
		c.addOrder(Order.asc("data"));
		c.setMaxResults(MAX_RESULTS_LST);
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Consulta> lst = c.list();
		return lst;
	}

}
