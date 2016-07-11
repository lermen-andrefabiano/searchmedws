package br.com.searchmed;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class UsuarioHibernate extends AbstractCrudHibernate<Usuario, Long> implements UsuarioRepository {

	@Override
	public Usuario obterPorEmail(String email) throws Exception {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Usuario.class);
			c.add(Restrictions.eq("email", email));
			return (Usuario) c.uniqueResult();
		} catch (Exception e) {
			throw e;
		}

	}

}
