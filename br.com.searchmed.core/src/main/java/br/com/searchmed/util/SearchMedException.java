package br.com.searchmed.util;

public class SearchMedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchMedException(String chave) {
		super(chave);
	}

	public SearchMedException(Throwable cause) {
		super(cause);
	}

	public SearchMedException(String chave, Throwable cause) {
		super(chave, cause);
	}

}
