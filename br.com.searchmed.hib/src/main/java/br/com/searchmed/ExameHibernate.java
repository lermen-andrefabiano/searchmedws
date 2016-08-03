package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.ConsultaExame;
import br.com.searchmed.core.entidades.Exame;
import br.com.searchmed.core.entidades.Laboratorio;
import br.com.searchmed.core.enuns.TipoHorario;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class ExameHibernate extends AbstractCrudHibernate<Exame, Long> implements ExameRepository {

	@Override
	public List<Exame> getExames() throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Exame> lst = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Exame.class)
			.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<ConsultaExame> getExamesConsulta(Long consultaId) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ConsultaExame.class);
			c.add(Restrictions.eq("status", TipoHorario.A));
			c.add(Restrictions.eq("consulta.id", consultaId));
			@SuppressWarnings("unchecked")
			List<ConsultaExame> lst = c.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Laboratorio> listarLaboratorios(Long exameId) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Laboratorio.class);
			c.createAlias("exames", "e");
			c.add(Restrictions.eq("e.exame.id", exameId));
			c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			@SuppressWarnings("unchecked")
			List<Laboratorio> lst = c.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}
}
