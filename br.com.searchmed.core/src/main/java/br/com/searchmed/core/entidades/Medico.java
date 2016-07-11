package br.com.searchmed.core.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(schema = "searchmed")
public class Medico implements Serializable {

	/**
	 * This field is used to .....
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_medico")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
	private Long id;

	@Column(nullable = false, length = 200)
	private String crm;	

	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
	private Usuario usuario;

	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<MedicoEspecialidade> especialidades;

	@OneToMany(mappedBy = "medico", fetch = FetchType.EAGER)		
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<MedicoConvenio> convenios;
	
	@OneToMany(mappedBy = "medico", fetch = FetchType.EAGER)		
	@Fetch(FetchMode.SUBSELECT)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private List<MedicoHorario> horarios;

	public Medico() {
	}

	public Medico(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<MedicoEspecialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<MedicoEspecialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<MedicoConvenio> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<MedicoConvenio> convenios) {
		this.convenios = convenios;
	}
	
	public List<MedicoHorario> getHorarios() {
		return horarios;
	}
	
	public void setHorarios(List<MedicoHorario> horarios) {
		this.horarios = horarios;
	}

}
