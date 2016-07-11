package br.com.searchmed;

import javax.inject.Named;

import br.com.searchmed.core.entidades.ConsultaClassificacao;
import br.com.searchmed.crud.AbstractCrudHibernate;

@Named
class ConsultaClassificacaoHibernate extends AbstractCrudHibernate<ConsultaClassificacao, Long> implements ConsultaClassificaocaoRepository {

}
