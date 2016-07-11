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

import br.com.searchmed.core.enuns.TipoAgenda;

@Entity
@Table(schema = "searchmed")
public class ExameAgenda implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_exame_agenda")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 1)
	private TipoAgenda status;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "consulta_exame_id", referencedColumnName = "id", nullable = false)
	private ConsultaExame consultaExame;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "laboratorio_id", referencedColumnName = "id", nullable = false)
	private Laboratorio laboratorio;

	public ExameAgenda() {
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

	public TipoAgenda getStatus() {
		return status;
	}

	public void setStatus(TipoAgenda status) {
		this.status = status;
	}

	public ConsultaExame getConsultaExame() {
		return consultaExame;
	}

	public void setConsultaExame(ConsultaExame consultaExame) {
		this.consultaExame = consultaExame;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

}
