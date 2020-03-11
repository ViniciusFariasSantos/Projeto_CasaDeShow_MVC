package com.br.gft.gestaoShow.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gft.gestaoShow.model.Venda;
import com.br.gft.gestaoShow.repository.ReposiHistorico;
import com.br.gft.gestaoShow.services.exceptions.CasaShowExistenteException;
import com.br.gft.gestaoShow.services.exceptions.CasaShowNaoEncontradoException;


@Service
public class VendaService {
	
	@Autowired
	private ReposiHistorico reposiHistorico; 
	
	public Iterable<Venda> listar (){
		return  reposiHistorico.findAll(); 
	}
	
	public Venda salvar (Venda historico) {
		
		if(historico.getId() != null) {
			
		
			
			Venda a = reposiHistorico.findById(historico.getId()).orElse(null);
			
			if (a != null) {
				
				throw new CasaShowExistenteException("O Venda já existe.");
			}
			
		}
		
		return reposiHistorico.save(historico);
	}
	
	public Optional<Venda> buscar(Long id) {
		
		Optional<Venda> historico = reposiHistorico.findById(id);
		
		if(historico.isEmpty()  ) {
			throw new CasaShowNaoEncontradoException("A Venda não existe");
		}
		return historico; 
	}
	
	
}
