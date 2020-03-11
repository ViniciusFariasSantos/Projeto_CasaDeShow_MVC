package com.br.gft.gestaoShow.services.exceptions;

public class CasaShowExistenteException extends RuntimeException{
	
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public  CasaShowExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public  CasaShowExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	
}
