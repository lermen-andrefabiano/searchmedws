package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "laboratorioExame")
public class LaboratorioExameDTO {

	private Long id;

	private ExameDTO exame;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExameDTO getExame() {
		return exame;
	}

	public void setExame(ExameDTO exame) {
		this.exame = exame;
	}

}
