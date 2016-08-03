package br.com.searchmed.core.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(schema = "searchmed")
public class Laboratorio implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_laboratorio")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@Column(nullable = false, length = 200)
	private String cnpj;

	@Column(nullable = false, length = 200)
	private String nome;

	@OneToMany(mappedBy = "laboratorio", fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<LaboratorioExame> exames;

	public Laboratorio() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LaboratorioExame> getExames() {
		return exames;
	}

	public void setExames(List<LaboratorioExame> exames) {
		this.exames = exames;
	}

}
