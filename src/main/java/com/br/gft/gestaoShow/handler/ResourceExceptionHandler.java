package com.br.gft.gestaoShow.handler;



import javax.persistence.EntityNotFoundException;
import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.gft.gestaoShow.model.DetalhesErro;
import com.br.gft.gestaoShow.services.exceptions.CasaShowExistenteException;
import com.br.gft.gestaoShow.services.exceptions.CasaShowNaoEncontradoException;
import com.br.gft.gestaoShow.services.exceptions.EventoExistenteException;
import com.br.gft.gestaoShow.services.exceptions.EventoNaoEncontradoException;
import com.br.gft.gestaoShow.services.exceptions.UsuarioExistenteException;
import com.br.gft.gestaoShow.services.exceptions.UsuarioNaoEncontradoException;
import com.br.gft.gestaoShow.services.exceptions.VendaExistenteException;
import com.br.gft.gestaoShow.services.exceptions.VendaNaoEncontradoException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	//-------------------------------------Details Error Evento ------------------------------------------------------------------------
	
	@ExceptionHandler(EventoNaoEncontradoException.class)
	public ResponseEntity <DetalhesErro> handlerEventoNaoEncontradoException(EventoNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("O Evento não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
		
	}
	@ExceptionHandler(EventoExistenteException.class)
	public ResponseEntity <DetalhesErro> handlerEventoExistenteException(EventoExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(409l);
		erro.setTitulo("Evento já existente.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
		
	}
	
	
	

	//-------------------------------------Details Error Casa de Show------------------------------------------------------------------------
		
	@ExceptionHandler(CasaShowExistenteException.class)
	public ResponseEntity <DetalhesErro> handlerCasaShowExistenteException(CasaShowExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(409l);
		erro.setTitulo("Casa de show já existente.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
		
	}
	
	
	@ExceptionHandler(CasaShowNaoEncontradoException.class)
	public ResponseEntity <DetalhesErro> handlerCasaShowNaoEncontradoException(CasaShowNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("A casa de show não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
		
	}
	

	
	//-------------------------------------Details Error Usuario------------------------------------------------------------------------
	
	@ExceptionHandler(UsuarioExistenteException.class)
	public ResponseEntity <DetalhesErro> handlerUsuarioExistenteException(UsuarioExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(409l);
		erro.setTitulo("O usuario já existente.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
		
	}
	
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity <DetalhesErro> handlerUsuarioNaoEncontradoException(UsuarioNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("O usuario não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
		
	}
	
	//-------------------------------------Details Error Venda------------------------------------------------------------------------
	
	@ExceptionHandler(VendaNaoEncontradoException.class)
	public ResponseEntity <DetalhesErro> handlerVendaNaoEncontradoException(VendaNaoEncontradoException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(404l);
		erro.setTitulo("Os dados desta venda, não pode ser encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
		
	}
	@ExceptionHandler(VendaExistenteException.class)
	public ResponseEntity <DetalhesErro> handlerVendaExistenteException(VendaExistenteException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(409l);
		erro.setTitulo("A Venda já existente.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
		
		
	}
	
	
	//-------------------------------------Details Error Geral------------------------------------------------------------------------
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity <DetalhesErro> handlerInvalidFormatException(InvalidFormatException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(400l);
		erro.setTitulo("Favor colocar a data no formato certo utilizando as barras ex: dia/mês/ano.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/500");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity <DetalhesErro> handlerEntityNotFoundException(EntityNotFoundException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(400l);
		erro.setTitulo("Favor passar um atributo para o ID ou um ID que exista.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
		
	}
	//
	
	@ExceptionHandler(RollbackException.class)
	public ResponseEntity <DetalhesErro> handlerRollbackException(RollbackException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(400l);
		erro.setTitulo("Favor colocar o atributo certo(Numero ou String).");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
		
	}
	@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity <DetalhesErro> handlerJsonMappingException(JsonMappingException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		
		erro.setStatus(400l);
		erro.setTitulo("Favor colocar o atributo certo.");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
		
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



