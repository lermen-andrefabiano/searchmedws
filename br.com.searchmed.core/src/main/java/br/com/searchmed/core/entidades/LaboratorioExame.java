package br.com.searchmed.core.entidades;

import java.io.Serializable;

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
public class LaboratorioExame implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_medico_horario")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "exame_id", referencedColumnName = "id", nullable = false)
	private Exame exame;

	@ManyToOne(optional = false)
	@JoinColumn(name = "laboratorio_id", referencedColumnName = "id", nullable = false)
	private Laboratorio laboratorio;

	public LaboratorioExame() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

}
