package br.com.searchmed;

import javax.inject.Named;

import br.com.searchmed.core.entidades.MedicoHorario;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class MedicoHorarioHibernate extends AbstractCrudHibernate<MedicoHorario, Long> implements MedicoHorarioRepository {

}
