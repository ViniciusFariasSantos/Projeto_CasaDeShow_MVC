package com.br.gft.gestaoShow.services.exceptions;

public class CasaShowNaoEncontradoException extends RuntimeException{
	
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public  CasaShowNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public  CasaShowNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	
}
