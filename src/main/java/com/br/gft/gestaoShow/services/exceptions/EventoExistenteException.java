package com.br.gft.gestaoShow.services.exceptions;

public class EventoExistenteException extends RuntimeException{
	
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public  EventoExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public  EventoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	
}
