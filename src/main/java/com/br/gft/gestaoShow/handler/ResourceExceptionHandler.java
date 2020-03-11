package com.br.gft.gestaoShow.handler;



import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.gft.gestaoShow.model.DetalhesErro;
import com.br.gft.gestaoShow.services.exceptions.CasaShowExistenteException;
import com.br.gft.gestaoShow.services.exceptions.CasaShowNaoEncontradoException;
import com.br.gft.gestaoShow.services.exceptions.EventoNaoEncontradoException;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EventoNaoEncontradoException.class)
	public ResponseEntity <DetalhesErro> handlerLivroNaoEncontradoException(EventoNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("O Evento não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
		
	}
	
	
	@ExceptionHandler(CasaShowExistenteException.class)
	public ResponseEntity <DetalhesErro> handlerAutorExistenteException(CasaShowExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(409l);
		erro.setTitulo("Casa de show já existente.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
		
	}
	
	
	@ExceptionHandler(CasaShowNaoEncontradoException.class)
	public ResponseEntity <DetalhesErro> handlerAutorNaoEncontradoException(CasaShowNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("A casa de show não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity <DetalhesErro> handlerDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(400l);
		erro.setTitulo("Requisição inválida");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
		
	}
	
}



