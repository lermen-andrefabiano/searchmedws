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

    public Exame() {
    }

    public Exame(Long id) {
        this.id = id;
    }

    public Exame(String descricao) {
        this.descricao = descricao;
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

}
