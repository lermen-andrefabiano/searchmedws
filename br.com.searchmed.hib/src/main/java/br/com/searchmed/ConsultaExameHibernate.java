package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.ConsultaExame;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class ConsultaExameHibernate extends AbstractCrudHibernate<ConsultaExame, Long> implements ConsultaExameRepository {

	@Override
	public List<ConsultaExame> obterPorConsulta(Long id)  throws Exception{
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ConsultaExame.class);				
			c.add(Restrictions.eq("consulta.id", id));
			@SuppressWarnings("unchecked")
			List<ConsultaExame> lst = c.list();
			return lst;
		} catch (Exception e) {
			return null;
		}		
	}

	@Override
	public ConsultaExame obterPorConsulta(Long consultaId, Long exameId) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ConsultaExame.class);				
			c.add(Restrictions.eq("consulta.id", consultaId));
			c.add(Restrictions.eq("exame.id", exameId));
			return (ConsultaExame) c.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<ConsultaExame> getExamesUsuario(Long usuarioId) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(ConsultaExame.class);	
			c.createAlias("exame", "exame");
			c.createAlias("consulta", "consulta");
			c.add(Restrictions.eq("consulta.usuario.id", usuarioId));
			c.add(Restrictions.isNull("realizou"));
			@SuppressWarnings("unchecked")
			List<ConsultaExame> lst = c.list();
			return lst;
		} catch (Exception e) {
			return null;
		}		
	}

}
