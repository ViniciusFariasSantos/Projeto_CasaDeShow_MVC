package com.br.gft.gestaoShow.services.exceptions;

public class EventoNaoEncontradoException extends RuntimeException{
	
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public  EventoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public  EventoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	
}
