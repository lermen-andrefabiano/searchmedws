package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exame")
public class ExameDTO {

	private Long id;
	private String descricao;
	
	public ExameDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExameDTO(String descricao) {
		this.descricao = descricao;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
