package br.com.searchmed.core.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "searchmed")
public class Exame implements Serializable {

    /**
     * This field is used to .....
     */
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq", allocationSize = 1, sequenceName = "searchmed.seq_exame")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq")
    private Long id;

    @Column(nullable = false, length = 300)
    private String descricao;
    
    @Column(length = 300)
    private String loinc;
    
    @Column(length = 300)
    private String loincName;

    public Exame() {
    }

    public Exame(Long id) {
        this.id = id;
    }

    public Exame(String descricao) {
        this.descricao = descricao;
    }    

    public Exame(String descricao, String loinc, String loincName) {		
		this.descricao = descricao;
		this.loinc = loinc;
		this.loincName = loincName;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getLoinc() {
		return loinc;
	}
    
    public void setLoinc(String loinc) {
		this.loinc = loinc;
	}
    
    public String getLoincName() {
		return loincName;
	}
    
    public void setLoincName(String loincName) {
		this.loincName = loincName;
	}

}
