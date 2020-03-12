package com.br.gft.gestaoShow.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.gft.gestaoShow.model.Venda;
import com.br.gft.gestaoShow.repository.ReposiHistorico;
import com.br.gft.gestaoShow.services.exceptions.VendaExistenteException;
import com.br.gft.gestaoShow.services.exceptions.VendaNaoEncontradoException;


@Service
public class VendaService {
	
	@Autowired
	private ReposiHistorico reposiHistorico; 
	
	
	
	//-------------- Listar todas as vendas ------------------------
	public Iterable<Venda> listar (){
		return  reposiHistorico.findAll(); 
	}
	
	
	//-------------- Salvar as vendas ----------------------------
	public Venda salvar (Venda historico) {
		
		if(historico.getId() != null) {
			
		
			
			Venda a = reposiHistorico.findById(historico.getId()).orElse(null);
			
			if (a != null) {
				
				throw new VendaExistenteException("A Venda já existe.");
			}
			
		}
		
		return reposiHistorico.save(historico);
	}
	
	//--------------buscar as vendas pelo id --------------------------------
	public Optional<Venda> buscar(Long id) {
		
		Optional<Venda> historico = reposiHistorico.findById(id);
		
		if(historico.isEmpty()  ) {
			throw new VendaNaoEncontradoException("A Venda não existe");
		}
		return historico; 
	}
	
	
}
