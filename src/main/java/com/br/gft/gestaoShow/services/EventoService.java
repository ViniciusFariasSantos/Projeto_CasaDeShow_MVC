package com.br.gft.gestaoShow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.gft.gestaoShow.model.Evento;

import com.br.gft.gestaoShow.repository.ReposiEvento;
import com.br.gft.gestaoShow.services.exceptions.LivroNaoEncontradoException;

@Service
public class EventoService {
	
	@Autowired
	private ReposiEvento livrosRepository;
	

   
	
	
	
	//metodo listar 
	public List<Evento> listar(){
		return livrosRepository.findAll();
	}
	
	
	
	
	
	public Optional<Evento> buscar(Long codigoEvento ) {
		
		Optional<Evento> livro  = livrosRepository.findById(codigoEvento);
				if(livro.isEmpty() ){
				
			throw new  LivroNaoEncontradoException("O Evento não pode ser encontrado.");
		}
			return livro;
	}
	
	
	
	
	public Evento salvar (Evento evento) {
		evento.setCodigoEvento(null);
		return livrosRepository.save(evento);
		
	}
	
	
	
	
	public void deletar(Long codigoEvento) {
		
		try {
			this.livrosRepository.deleteById(codigoEvento);
		}catch (EmptyResultDataAccessException e) {
			
			throw new  LivroNaoEncontradoException("O Evento não pode ser encontrado .");
		}
		
	}
	
	
	
	
	public void atualizar (Evento evento) {
		verificarExistencia(evento);
		livrosRepository.save(evento);
		
		
	}
	
	
	private void verificarExistencia(Evento evento) {
		
		buscar (evento.getCodigoEvento());
		
	}
	
	
	
	
	
	
	
	
}
