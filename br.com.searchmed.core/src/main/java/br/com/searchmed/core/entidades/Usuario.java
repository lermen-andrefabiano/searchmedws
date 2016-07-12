package br.com.searchmed.core.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.searchmed.core.enuns.TipoUsuario;

@Entity
@Table(schema = "searchmed")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_usuario")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@Column(nullable = false, length = 200)
	private String nome;

	@Column(nullable = false, length = 200, unique = true)
	private String email;

	@Column(nullable = false, length = 300)
	private String endereco;

	@Column(nullable = false, length = 30)
	private String senha;
	
	private Double latitude;
	
	private Double longitude;

	@Column(nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Medico medico;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<MedicoFavorito> favoritos;

	public Usuario() {
	}

	public Usuario(Long id) {
		this.id = id;
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
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<MedicoFavorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<MedicoFavorito> favoritos) {
		this.favoritos = favoritos;
	}

}
