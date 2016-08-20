package br.com.searchmed;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.searchmed.core.entidades.Especialidade;
import br.com.searchmed.core.entidades.Medico;
import br.com.searchmed.core.entidades.MedicoEspecialidade;
import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.core.enuns.TipoUsuario;
import br.com.searchmed.util.SearchMedException;

/**
 * 
 * @author andre.lermen
 * 
 */
@Named
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioRepository usuarioRep;

	@Inject
	private MedicoEspecialidadeRepository usuarioEspecialidadeRep;	
	
	@Override
	public Usuario obterPorId(Long id) {
		return usuarioRep.obterPorId(id);
	}	

	@Override
	public Usuario login(String email, String senha) throws SearchMedException {

		Usuario u = null;
		try {
			u = usuarioRep.obterPorEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (u == null) {
			throw new SearchMedException(HOME_HELP_LOGIN_INVALIDO);
		}

		this.validaSenha(u, senha);
		
		return u;

	}

	private void validaSenha(Usuario u, String senha) throws SearchMedException {
		if (!u.getSenha().trim().equals(senha.trim())) {
			throw new SearchMedException(HOME_HELP_SENHA_INVALIDA);
		}
	}

	@Override
	public Usuario criar(Usuario login) {
		Usuario u = null;
		
		if(login.getTipo().equals(TipoUsuario.M)){
			login.getMedico().setUsuario(login);
		}
		
		login.setSenha(login.getSenha().trim());		
				
		if(login!=null&&login.getId()!=null&&login.getId()>0){
			u = this.usuarioRep.obterPorId(login.getId());	
			login.setId(u.getId());
			u = this.usuarioRep.salvar(login);
		}else{
			this.usuarioRep.persist(login);
			u = this.usuarioRep.salvar(login);
		}		
		
		return u;
	}

	@Override
	public void addEspecialidade(Long valor, Long especialidadeId, Long medicoId) {
		this.usuarioEspecialidadeRep.persist(new MedicoEspecialidade( valor, new Especialidade(especialidadeId), new Medico(medicoId) ));
	}

	@Override
	public boolean trocarSenha(Long usuarioId, String senha, String novaSenha) {
		Usuario u = this.obterPorId(usuarioId);
		
		if(u!=null && u.getSenha().equals(senha)){
			u.setSenha(novaSenha);
			this.usuarioRep.salvar(u);		
			return true;
		}else{
			return false;
		}	
	}

	@Override
	public Usuario salvar(Usuario obj) {		
		return this.usuarioRep.salvar(obj);
	}	
	
	@Override
	public boolean esqueceuSenha(String email) {		
		if(isEmail(email)){			
		}				
		return Boolean.FALSE;
		
	}
	
	private boolean isEmail(String email) {
		Usuario u = null;
		try {
			u = this.usuarioRep.obterPorEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return u!=null;
	}	
}