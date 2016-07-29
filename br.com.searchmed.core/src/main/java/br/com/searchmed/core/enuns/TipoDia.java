package br.com.searchmed.core.enuns;

public enum TipoDia {
	
	SEGUNDA(2),
	
	TERCA(3),
	
	QUARTA(4),
	
	QUINTA(5),
	
	SEXTA(6);
	
	int dia;
	 
	private TipoDia(int dia){
		this.dia = dia;
	}
 
	public int getDia(){
		return dia;
	}

}
