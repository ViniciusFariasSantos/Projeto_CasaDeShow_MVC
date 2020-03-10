package com.br.gft.gestaoShow.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gft.gestaoShow.model.Historico;
import com.br.gft.gestaoShow.repository.ReposiHistorico;
import com.br.gft.gestaoShow.services.exceptions.AutorExistenteException;
import com.br.gft.gestaoShow.services.exceptions.AutorNaoEncontradoException;


@Service
public class HistoricoService {
	
	@Autowired
	private ReposiHistorico reposiHistorico; 
	
	public Iterable<Historico> listar (){
		return  reposiHistorico.findAll(); 
	}
	
	public Historico salvar (Historico historico) {
		
		if(historico.getId() != null) {
			
			Historico a = reposiHistorico.findById(historico.getId()).orElse(null);
			
			if (a != null) {
				
				throw new AutorExistenteException("O Historico já existente de show já existe");
			}
			
		}
		
		return reposiHistorico.save(historico);
	}
	
	public Optional<Historico> buscar(Long id) {
		
		Optional<Historico> historico = reposiHistorico.findById(id);
		
		if(historico.isEmpty()  ) {
			throw new AutorNaoEncontradoException("A Casa de show não existente");
		}
		return historico; 
	}
	
	
}
