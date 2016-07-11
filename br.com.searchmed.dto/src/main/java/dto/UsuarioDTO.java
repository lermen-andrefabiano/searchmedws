package dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuario")
public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private String senha;
	private String tipo;
	private MedicoDTO medico;
	private List<MedicoFavoritoDTO> favoritos;

	public UsuarioDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public MedicoDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}

	public List<MedicoFavoritoDTO> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<MedicoFavoritoDTO> favoritos) {
		this.favoritos = favoritos;
	}

}
