package br.com.searchmed.core.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "searchmed")
public class ConsultaClassificacao implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_consulta_classificacao")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@Column(nullable = false)
	private Long nota;

	@Column(nullable = false, length = 2000)
	private String recomendacao;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	private Consulta consulta;

	public ConsultaClassificacao() {
	}

	public ConsultaClassificacao(Long nota, String recomendacao, Consulta consulta) {
		super();
		this.nota = nota;
		this.recomendacao = recomendacao;
		this.consulta = consulta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNota() {
		return nota;
	}

	public void setNota(Long nota) {
		this.nota = nota;
	}

	public String getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
