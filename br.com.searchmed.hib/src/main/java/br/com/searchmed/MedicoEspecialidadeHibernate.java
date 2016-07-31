package br.com.searchmed;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoEspecialidade;
import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.core.enuns.TipoHorario;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class MedicoEspecialidadeHibernate extends AbstractCrudHibernate<MedicoEspecialidade, Long>
		implements MedicoEspecialidadeRepository {

	@Override
	public List<Medico> getMedicoEspecialidades(String convenio, Long especialidadeId) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Medico> lst = getHibernateTemplate().getSessionFactory().getCurrentSession()
					.createCriteria(Medico.class)
					.createAlias("especialidades", "e")
					.createAlias("convenios", "c")	
					.add(Restrictions.eq("e.especialidade.id", especialidadeId))
					.add(Restrictions.ilike("c.convenio", "%" + convenio + "%"))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<MedicoEspecialidade> getEspecialidaMedico(Long medicoId) {
		@SuppressWarnings("unchecked")
		List<MedicoEspecialidade> lst = getHibernateTemplate().getSessionFactory().getCurrentSession()
				.createCriteria(MedicoEspecialidade.class).createAlias("especialidade", "e")
				.add(Restrictions.eq("medico.id", medicoId)).setMaxResults(MAX_RESULTS_LST).list();
		return lst;
	}

	@Override
	public MedicoEspecialidade obterPorMedico(Long medicoId, Long especialidadeId) {
		try {
			Criteria c = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(MedicoEspecialidade.class);
			c.add(Restrictions.eq("medico.id", medicoId));
			c.add(Restrictions.eq("especialidade.id", especialidadeId));
			c.setMaxResults(1);
			MedicoEspecialidade m = (MedicoEspecialidade) c.uniqueResult();
			return m;		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

	@Override
	public List<MedicoHorario> getHorarioMedico(Long id) {
		try {
			@SuppressWarnings("unchecked")
			List<MedicoHorario> lst = getHibernateTemplate().getSessionFactory().getCurrentSession()
					.createCriteria(MedicoHorario.class)
					.add(Restrictions.eq("medico.id", id))
					.add(Restrictions.eq("status", TipoHorario.A))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.list();
			return lst;
		} catch (Exception e) {
			throw e;
		}
	}

}
