package br.com.searchmed;

import br.com.searchmed.core.entidades.ConsultaClassificacao;

interface ConsultaClassificaocaoRepository {

    ConsultaClassificacao obterPorId(Long id);

    void persist(ConsultaClassificacao obj);

    ConsultaClassificacao salvar(ConsultaClassificacao obj);

    void excluir(ConsultaClassificacao obj);

}
