package br.com.searchmed;

import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.util.SearchMedException;

/**
 * 
 * Home Help.
 *
 * @author: andre.lermen
 * @since: 23/06/2015
 *
 *         Change History
 *
 * @author: andre.lermen
 * @date: 23/06/2015
 * @reason: Initial code.
 *
 */
public interface UsuarioService {

	String HOME_HELP_LOGIN_INVALIDO = "br.com.home.help.login.invalido";

	String HOME_HELP_SENHA_INVALIDA = "br.com.home.help.senha.invalida";

	Usuario login(String email, String senha) throws SearchMedException;

	Usuario criar(Usuario login) throws SearchMedException;

	void addEspecialidade(Long valorCobrado, Long especialidadeId, Long usuarioId);

	Usuario obterPorId(Long id);

	void trocarSenha(Long usuarioId, String senha);

	Usuario salvar(Usuario obj);

	boolean esqueceuSenha(String email);	

}
