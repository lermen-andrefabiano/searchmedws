package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.enuns.TipoHorario;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class MedicoHorarioHibernate extends AbstractCrudHibernate<MedicoHorario, Long> implements MedicoHorarioRepository {

	@Override
	public List<MedicoHorario> listarHorariosAbertos() {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(MedicoHorario.class);
			c.add(Restrictions.eq("status", TipoHorario.A));
			@SuppressWarnings("unchecked")
			List<MedicoHorario> lst = c.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}

}
