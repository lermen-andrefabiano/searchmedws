package br.com.searchmed.core.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.searchmed.core.enuns.TipoStatus;

@Entity
@Table(schema = "searchmed")
public class Consulta implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_consulta")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date data;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 1)
	private TipoStatus status;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "especialidade_id", referencedColumnName = "id", nullable = false)
	private Especialidade especialidade;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
	private Usuario usuario;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = false)
	private Medico medico;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "horario_id", referencedColumnName = "id", nullable = false)
	private MedicoHorario horario;

	@OneToOne(fetch = FetchType.LAZY)
	private ConsultaClassificacao classificacao;

	@OneToMany(mappedBy = "consulta", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<ConsultaExame> exames;

	public Consulta() {
	}

	public Consulta(Long id) {
		this.id = id;
	}

	public Consulta(Date data, TipoStatus status, Usuario usuario, Medico medico, Especialidade especialidade, MedicoHorario h) {
		this.data = data;
		this.status = status;
		this.usuario = usuario;
		this.medico = medico;
		this.especialidade = especialidade;
		this.horario = h;
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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public MedicoHorario getHorario() {
		return horario;
	}
	
	public void setHorario(MedicoHorario horario) {
		this.horario = horario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public ConsultaClassificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(ConsultaClassificacao classificacao) {
		this.classificacao = classificacao;
	}

	public List<ConsultaExame> getExames() {
		return exames;
	}

	public void setExames(List<ConsultaExame> exames) {
		this.exames = exames;
	}
}
