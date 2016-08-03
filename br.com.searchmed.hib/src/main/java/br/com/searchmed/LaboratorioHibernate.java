package br.com.searchmed;

import javax.inject.Named;

import br.com.searchmed.core.entidades.Laboratorio;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class LaboratorioHibernate extends AbstractCrudHibernate<Laboratorio, Long> implements LaboratorioRepository {

}
