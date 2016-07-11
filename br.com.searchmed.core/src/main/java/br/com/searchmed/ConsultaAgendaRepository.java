package br.com.searchmed;

import br.com.searchmed.core.entidades.ConsultaAgenda;

interface ConsultaAgendaRepository {

    ConsultaAgenda obterPorId(Long id);

    void persist(ConsultaAgenda obj);

    ConsultaAgenda salvar(ConsultaAgenda obj);

    void excluir(ConsultaAgenda obj);
    
    ConsultaAgenda obterPorConsulta(Long consultaId) throws Exception;    

}