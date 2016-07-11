package br.com.searchmed.web;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.Mapper;

import br.com.searchmed.UsuarioService;
import br.com.searchmed.core.entidades.Usuario;
import br.com.searchmed.util.SearchMedException;
import dto.UsuarioDTO;

@Named
@Path("usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource extends AbstractResource {

	@Inject
	private UsuarioService usuarioService;

	@Inject
	public UsuarioResource(Mapper mapper) {
		super.mapper = mapper;
	}
	
	@GET//http://localhost:8080/searchmed/rest/usuario/1
	@Path("{id}")
	public UsuarioDTO obterPorId(@PathParam("id") Long id){
		Usuario u = usuarioService.obterPorId(id);		
		UsuarioDTO dto = map(u, UsuarioDTO.class);		
		return dto;
	}

	@POST
	@Path("login")
	public UsuarioDTO login(UsuarioDTO login) {
		Usuario u = null;
		UsuarioDTO retorno = new UsuarioDTO();
		
		try {
			u = usuarioService.login(login.getEmail(), login.getSenha());			
			if(u!=null){
				retorno = super.map(u, UsuarioDTO.class);
				retorno.setSenha(null);		
			}		
		} catch (SearchMedException e) {
		}		

		return retorno;
	}
	
	@POST
	@Path("criar")
	public UsuarioDTO criar(UsuarioDTO login) {
		UsuarioDTO retorno = null;
		
		try {
			Usuario u = usuarioService.criar(super.map(login, Usuario.class));		
			if(u!=null){
				retorno = super.map(u, UsuarioDTO.class);
				retorno.setSenha(null);		
			}					
		} catch (SearchMedException e) {
			e.printStackTrace();
		}		
		
		return retorno;		
	}
	
	@POST
	@Path("senha")
	public Response senha(@QueryParam("usuarioId") Long usuarioId, String senha) {		
		this.usuarioService.trocarSenha(usuarioId, senha);
		return Response.ok(true).build();
	}	

}