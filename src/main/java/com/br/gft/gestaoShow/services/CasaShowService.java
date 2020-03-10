package com.br.gft.gestaoShow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.br.gft.gestaoShow.model.Show;
import com.br.gft.gestaoShow.repository.ReposiShow;
import com.br.gft.gestaoShow.services.exceptions.AutorExistenteException;
import com.br.gft.gestaoShow.services.exceptions.AutorNaoEncontradoException;
import com.br.gft.gestaoShow.services.exceptions.LivroNaoEncontradoException;

@Service
public class CasaShowService {

	@Autowired
	private ReposiShow showRepository;

	
	
	
	
	
	
	
	
	
	public List<Show> listar() {
		return showRepository.findAll();
	}

	
	
	
	
	
	
	
	
	
	
	public Show salvar(Show show) {

		if (show.getCodigoShow() != null) {

			Show a = showRepository.findById(show.getCodigoShow()).orElse(null);

			if (a != null) {

				throw new AutorExistenteException("O casa de show já existe");
			}

		}

		return showRepository.save(show);
	}

	
	
	
	
	
	public Optional<Show> buscar(Long id) {

		Optional<Show> autor = showRepository.findById(id);

		if (autor.isEmpty()) {
			throw new AutorNaoEncontradoException("A Casa de show não existente");
		}
		return autor;
	}
	
	
	
	
	
	
	
	//------------- Metodo Buscar casa pelo nome-------------------------
	public Show buscarNome(String nomeCasaShow) {

		Show casa = showRepository.findByNomeCasaShow(nomeCasaShow);

		if (casa == null) {
			throw new AutorNaoEncontradoException("A Casa de show não existente");
		}
		return casa;
	}
	
	
	
	
	

	// Método deletar, irá mapiar onde está o id, e irá deletar sua linha
	// respectivamente.
	public void deletar(Long codigoEvento) {

		try {
			this.showRepository.deleteById(codigoEvento);
		} catch (EmptyResultDataAccessException e) {

			throw new LivroNaoEncontradoException("O Evento não pode ser encontrado .");
		}

	}  
	
	

	// Método autlizar, ele deriva do metodo salvar, caso existir um evento ele
	// retornará um conjunto de dados.
	public void atualizar(Show show) {
		verificarExistencia(show);
		showRepository.save(show);

	}

	
	
	// Este método deriva do metodo buscar e irá localizar um evento e verifícar se
	// ele existe ou não.
	private void verificarExistencia(Show show) {

		buscar(show.getCodigoShow());

	}

	
	
	// ----------------Nome do Evento Crescente e decrescente
	// -----------------------------------
	public List<Show> listarNomeCasaShowCres() {
		return showRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeCasaShow"));

	}
	
	
	
	

	public List<Show> listarNomeCasaShowDecres() {
		return showRepository.findAll(Sort.by(Sort.Direction.DESC, "nomeCasaShow"));

	}

}
