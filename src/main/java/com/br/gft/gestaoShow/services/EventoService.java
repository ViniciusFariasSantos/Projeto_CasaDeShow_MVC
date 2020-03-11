package com.br.gft.gestaoShow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.br.gft.gestaoShow.model.Evento;
import com.br.gft.gestaoShow.repository.ReposiEvento;
import com.br.gft.gestaoShow.services.exceptions.EventoNaoEncontradoException;

@Service
public class EventoService {
	


	@Autowired
	private ReposiEvento eventoRepository;

	// O método listar vai listar todos os dados salvos.
	public List<Evento> listar() {
		return eventoRepository.findAll();
	}

	// Método buscar, irá encontrar os eventos pelo seu ID.
	public Optional<Evento> buscar(Long codigoEvento) {

		Optional<Evento> livro = eventoRepository.findById(codigoEvento);
		if (livro.isEmpty()) {

			throw new EventoNaoEncontradoException("O Evento não pode ser encontrado.");
		}
		return livro;
	}

	// Método Salvar, irá salvar todos Atributos do evento.
	public Evento salvar(Evento evento) {
		evento.setCodigoEvento(null);
		return eventoRepository.save(evento);

	}

	// Método deletar, irá mapiar onde está o id, e irá deletar sua linha
	// respectivamente.
	public void deletar(Long codigoEvento) {

		try {
			this.eventoRepository.deleteById(codigoEvento);
		} catch (EmptyResultDataAccessException e) {

			throw new EventoNaoEncontradoException("O Evento não pode ser encontrado .");
		}

	}

	// Método autlizar, ele deriva do metodo salvar, caso existir um evento ele
	// retornará um conjunto de dados.
	public void atualizar(Evento evento) {
		verificarExistencia(evento);
		eventoRepository.save(evento);

	}

	// Este método deriva do metodo buscar e irá localizar um evento e verifícar se
	// ele existe ou não.
	private void verificarExistencia(Evento evento) {

		buscar(evento.getCodigoEvento());

	}
	
	
	
	

	//----------------Capacidade Crescente e decrescente --------------------------------------
	public List<Evento> listarCapacidadeCres(){
		return eventoRepository.findAll(Sort.by(Sort.Direction.ASC, "capacidade"));
			
	}
	
	public List<Evento> listarCapacidadeDecres(){
		return eventoRepository.findAll(Sort.by(Sort.Direction.DESC, "capacidade"));
			
	}
	
	
	
	
	//----------------Nome do Evento Crescente e decrescente -----------------------------------
	public List<Evento> listarNomeEventoCres(){
		return eventoRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeEvento"));
			
	}
	
	public List<Evento> listarNomeEventoDecres(){
		return eventoRepository.findAll(Sort.by(Sort.Direction.DESC, "nomeEvento"));
			
	}
	
	
	
	//----------------Data Crescente e decrescente -----------------------------------------------

	public List<Evento> listarDataCres(){
		return eventoRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
			
	}
	
	public List<Evento> listarDataDecres(){
		return eventoRepository.findAll(Sort.by(Sort.Direction.DESC, "data"));
			
	}
	
	
	
	
	//----------------Preço Crescente e decrescente -----------------------------------------------
	public List<Evento> listarPrecoCres(){
		return eventoRepository.findAll(Sort.by(Sort.Direction.ASC, "valorIngresso"));
			
	}
	
	public List<Evento> listarPrecoDecres(){
		return eventoRepository.findAll(Sort.by(Sort.Direction.DESC, "valorIngresso"));
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



















