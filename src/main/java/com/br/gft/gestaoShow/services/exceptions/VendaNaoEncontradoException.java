package com.br.gft.gestaoShow.services.exceptions;

public class VendaNaoEncontradoException extends RuntimeException{
	
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public  VendaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public  VendaNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
	
}
