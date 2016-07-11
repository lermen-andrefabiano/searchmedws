package br.com.searchmed.core.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.searchmed.core.enuns.TipoStatus;

@Entity
@Table(schema = "searchmed")
public class ConsultaExame implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_exame_consulta")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 1)
	private TipoStatus status;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "exame_id", referencedColumnName = "id", nullable = false)
	private Exame exame;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "consulta_id", referencedColumnName = "id", nullable = false)
	private Consulta consulta;

	public ConsultaExame() {
	}

	public ConsultaExame(Long id) {
		this.id = id;
	}

	public ConsultaExame(Date data, TipoStatus status, Consulta consulta, Exame exame) {
		this.data = data;
		this.status = status;
		this.consulta = consulta;
		this.exame = exame;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
