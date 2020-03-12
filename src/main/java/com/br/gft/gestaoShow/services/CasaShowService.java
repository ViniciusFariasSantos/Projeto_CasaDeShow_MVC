package com.br.gft.gestaoShow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.br.gft.gestaoShow.model.Show;
import com.br.gft.gestaoShow.repository.ReposiShow;
import com.br.gft.gestaoShow.services.exceptions.CasaShowExistenteException;
import com.br.gft.gestaoShow.services.exceptions.CasaShowNaoEncontradoException;

@Service
public class CasaShowService {

	@Autowired
	private ReposiShow showRepository;

	
	//Metodo Listar
	
	public List<Show> listar() {
		return showRepository.findAll();
	}

	
	
	//Metodo salvar.
	
	public Show salvar(Show show) {

		if (show.getCodigoShow() != null) {

			Show a = showRepository.findById(show.getCodigoShow()).orElse(null);

			if (a != null) {

				throw new CasaShowExistenteException("O casa de show já existe");
			}

		}

		return showRepository.save(show);
	}

	
	//Metodo buscar
	public Optional<Show> buscar(Long id) {

		Optional<Show> autor = showRepository.findById(id);

		if (autor.isEmpty()) {
			throw new CasaShowNaoEncontradoException("A Casa de show não existente");
		}
		return autor;
	}
	
	
	
	
	
	//------------- Metodo Buscar casa pelo nome-------------------------
	public List<Show> buscarNome(String nomeCasaShow) {

		List<Show> casa = showRepository.findByNomeCasaShowContaining(nomeCasaShow);

		if (casa.isEmpty()) {
			throw new CasaShowNaoEncontradoException("A Casa de show não existente");
		}
		return casa;
	}
	
	
	
	
	

	// Método deletar, irá mapiar onde está o id, e irá deletar sua linha
	// respectivamente.
	public void deletar(Long codigoShow) {

		try {
			this.showRepository.deleteById(codigoShow);
		} catch (EmptyResultDataAccessException e) {

			throw new CasaShowNaoEncontradoException("O Evento não pode ser encontrado .");
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

	
	
	// ----------------Nome da casa de Show Crescente e decrescente -----------------------------------
	public List<Show> listarNomeCasaShowCres() {
		return showRepository.findAll(Sort.by(Sort.Direction.ASC, "nomeCasaShow"));

	}
	
	
	
	

	public List<Show> listarNomeCasaShowDecres() {
		return showRepository.findAll(Sort.by(Sort.Direction.DESC, "nomeCasaShow"));

	}

}
