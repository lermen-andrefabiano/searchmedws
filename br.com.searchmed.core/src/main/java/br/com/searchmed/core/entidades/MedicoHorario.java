package br.com.searchmed.core.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.searchmed.core.enuns.TipoDia;
import br.com.searchmed.core.enuns.TipoHorario;

@Entity
@Table(schema = "searchmed")
public class MedicoHorario implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_medico_horario")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoDia dia;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fim;

	private Boolean orderChegada;	

	private Boolean repetirHorario;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 1)
	private TipoHorario status;

	@ManyToOne(optional = false)
	@JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = false)
	private Medico medico;
	
	public MedicoHorario(Long id) {
		this.id = id;
	}

	public MedicoHorario() {
	}

	public MedicoHorario(TipoDia dia, Date inicio, Date fim, Boolean orderChegada, Medico medico, Boolean repetirHorario) {
		this.dia = dia;
		this.inicio = inicio;
		this.fim = fim;
		this.orderChegada = orderChegada;
		this.medico = medico;
		this.repetirHorario = repetirHorario;
	}
	
	public TipoDia getDia() {
		return dia;
	}
	
	public void setDia(TipoDia dia) {
		this.dia = dia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	public Boolean getRepetirHorario() {
		return repetirHorario;
	}
	
	public void setRepetirHorario(Boolean repetirHorario) {
		this.repetirHorario = repetirHorario;
	}

	public TipoHorario getStatus() {
		return status;
	}
	
	public void setStatus(TipoHorario status) {
		this.status = status;
	}
	
	public Boolean getOrderChegada() {
		return orderChegada;
	}

	public void setOrderChegada(Boolean orderChegada) {
		this.orderChegada = orderChegada;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
