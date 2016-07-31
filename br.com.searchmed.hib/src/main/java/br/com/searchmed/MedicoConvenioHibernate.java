package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.MedicoConvenio;
import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.enuns.TipoHorario;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class MedicoConvenioHibernate extends AbstractCrudHibernate<MedicoConvenio, Long> implements MedicoConvenioRepository {

	@Override
	public List<MedicoHorario> getMedicoHorario(Long medicoId) {
		@SuppressWarnings("unchecked")
		List<MedicoHorario> lst = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(MedicoHorario.class)
				.add(Restrictions.eq("medico.id", medicoId))
				.add(Restrictions.eq("status", TipoHorario.A))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		return lst;
	}
	
	@Override
	public List<MedicoConvenio> getMedicoConvenio(Long medicoId) {
		@SuppressWarnings("unchecked")
		List<MedicoConvenio> lst = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(MedicoConvenio.class)
				.add(Restrictions.eq("medico.id", medicoId))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
		return lst;
	}
	
	@Override
	public MedicoConvenio obterPorMedico(Long medicoId, String convenio) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(MedicoConvenio.class);
			c.add(Restrictions.eq("medico.id", medicoId));
			c.add(Restrictions.eq("convenio", convenio));
			c.setMaxResults(1);
			MedicoConvenio m = (MedicoConvenio) c.uniqueResult();
			return m;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

}
