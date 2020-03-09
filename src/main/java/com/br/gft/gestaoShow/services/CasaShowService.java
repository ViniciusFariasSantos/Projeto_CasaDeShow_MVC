package com.br.gft.gestaoShow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gft.gestaoShow.model.Show;
import com.br.gft.gestaoShow.repository.ReposiShow;
import com.br.gft.gestaoShow.services.exceptions.AutorExistenteException;
import com.br.gft.gestaoShow.services.exceptions.AutorNaoEncontradoException;


@Service
public class CasaShowService {
	
	@Autowired
	private ReposiShow autoresRepository; 
	
	public List<Show>listar (){
		return autoresRepository.findAll(); 
	}
	
	public Show salvar (Show show) {
		
		if(show.getCodigoShow() != null) {
			
			Show a = autoresRepository.findById(show.getCodigoShow()).orElse(null);
			
			if (a != null) {
				
				throw new AutorExistenteException("O casa de show já existe");
			}
			
		}
		
		return autoresRepository.save(show);
	}
	
	public Optional<Show> buscar(Long id) {
		
		Optional<Show> autor = autoresRepository.findById(id);
		
		if(autor.isEmpty()  ) {
			throw new AutorNaoEncontradoException("A Casa de show não existente");
		}
		return autor; 
	}
	
	
}
