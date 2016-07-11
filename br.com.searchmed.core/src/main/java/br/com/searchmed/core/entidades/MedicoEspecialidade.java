package br.com.searchmed.core.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "searchmed")
public class MedicoEspecialidade implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_medico_especialidade")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@Column(nullable = true, precision = 12, scale = 2)
	private Long valor;

	@ManyToOne(optional = false)
	@JoinColumn(name = "especialidade_id", referencedColumnName = "id", nullable = false)
	private Especialidade especialidade;

	@ManyToOne(optional = false)
	@JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = false)
	private Medico medico;

	public MedicoEspecialidade() {
	}	

	public MedicoEspecialidade(Long valor, Especialidade especialidade, Medico medico) {
		super();
		this.valor = valor;
		this.especialidade = especialidade;
		this.medico = medico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValor() {
		return valor;
	}

	public void setValorCobrado(Long valor) {
		this.valor = valor;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
