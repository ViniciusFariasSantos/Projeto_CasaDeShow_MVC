package com.br.gft.gestaoShow.resources;


import java.net.URI;
import java.util.List;
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

import com.br.gft.gestaoShow.model.Evento;
import com.br.gft.gestaoShow.services.EventoService;



@RestController
@RequestMapping("/eventos")
public class EventoResources {
	
	
	
	@Autowired
	private EventoService livrosService;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public  ResponseEntity <List<Evento>> listar() {
		
			
		return  ResponseEntity.status(HttpStatus.OK).body(livrosService.listar());
	}
	
	
	
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void>  salvar(@Valid @RequestBody Evento evento) {
		
		
		evento = livrosService.salvar(evento);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(evento.getCodigoEvento()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long codigoEvento) {
		
		
		Optional<Evento> evento   = livrosService.buscar(codigoEvento);
		
		return ResponseEntity.status(HttpStatus.OK).body(evento);
		
		
	}
	
	
	
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar (@PathVariable("id") Long codigoEvento) {
		
		
			
		this.livrosService.deletar(codigoEvento);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar (@RequestBody Evento evento, @PathVariable("id") Long codigoEvento) {
		evento.setCodigoEvento(codigoEvento);
		
		
		livrosService.atualizar(evento);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
}
