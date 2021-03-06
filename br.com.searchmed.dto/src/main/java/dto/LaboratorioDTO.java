package dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "laboratorio")
public class LaboratorioDTO {

	private Long id;
	private String cnpj;
	private String nome;
	private List<LaboratorioExameDTO> exames;

	public LaboratorioDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LaboratorioExameDTO> getExames() {
		return exames;
	}

	public void setExames(List<LaboratorioExameDTO> exames) {
		this.exames = exames;
	}

}
