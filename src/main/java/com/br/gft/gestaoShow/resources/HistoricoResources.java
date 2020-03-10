package com.br.gft.gestaoShow.resources;



import java.net.URI;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.gft.gestaoShow.model.Historico;
import com.br.gft.gestaoShow.services.HistoricoService;


@RestController
@RequestMapping("/historico")
public class HistoricoResources {
	
	@Autowired
	private HistoricoService historicoService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Historico>> listar(){
		
		Iterable<Historico> historico = historicoService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(historico);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid  @RequestBody Historico historico){
		
		historico = historicoService.salvar(historico);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(historico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Historico>> buscar (@PathVariable("id") Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(historicoService.buscar(id));
		
	}
	
}
