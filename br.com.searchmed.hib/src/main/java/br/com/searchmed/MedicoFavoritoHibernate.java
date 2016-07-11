package br.com.searchmed;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.MedicoFavorito;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class MedicoFavoritoHibernate extends AbstractCrudHibernate<MedicoFavorito, Long> implements MedicoFavoritoRepository {

	@Override
	public MedicoFavorito obterFavoritoUsuario(Long medicoId, Long usuarioId) throws Exception{
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession()
					.createCriteria(MedicoFavorito.class);
			c.add(Restrictions.eq("medico.id", medicoId));
			c.add(Restrictions.eq("usuario.id", usuarioId));
			MedicoFavorito u = (MedicoFavorito) c.uniqueResult();
			return u;
		} catch (Exception e) {
			throw e;
		}
	}

}
