package br.com.searchmed;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class MedicoHibernate extends AbstractCrudHibernate<Medico, Long> implements MedicoRepository {

	@Override
	public Usuario obterUsuarioMedico(Long medicoId) throws Exception {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Usuario.class);
			c.add(Restrictions.eq("medico.id", medicoId));
			Usuario u = (Usuario) c.uniqueResult();
			return u;
		} catch (Exception e) {
			throw e;
		}
	}

}
