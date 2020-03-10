package com.br.gft.gestaoShow.resources;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	private EventoService eventoService;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public  ResponseEntity <List<Evento>> listar() {
		
			
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listar());
	}
	
	
	
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<Void>  salvar(@Valid @RequestBody Evento evento) {
		
		
		evento = eventoService.salvar(evento);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(evento.getCodigoEvento()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long codigoEvento) {
		
		
		Optional<Evento> evento   = eventoService.buscar(codigoEvento);
		
		return ResponseEntity.status(HttpStatus.OK).body(evento);
		
		
	}
	
	
	
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar (@PathVariable("id") Long codigoEvento) {
		
		
			
		this.eventoService.deletar(codigoEvento);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar (@RequestBody Evento evento, @PathVariable("id") Long codigoEvento) {
		evento.setCodigoEvento(codigoEvento);
		
		
		eventoService.atualizar(evento);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	//----------------Nome do Evento Crescente e decrescente -----------------------------------
	@GetMapping("/nome/asc")
	public ResponseEntity<List<Evento>> listarNomeEventoAsc(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listarNomeEventoCres());
	}
	
	@GetMapping("/nome/desc")
	public ResponseEntity<List<Evento>> listarNomeEventoDesc(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listarNomeEventoDecres());
	}
	
	
	
	
	
	//----------------Capacidade Crescente e decrescente ----------------------------------------

	@GetMapping("/capacidade/asc")
	public ResponseEntity<List<Evento>> listarCapacidadeAsc(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listarCapacidadeCres());
	}
	
	@GetMapping("/capacidade/desc")
	public ResponseEntity<List<Evento>> listarCapacidadeDesc(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listarCapacidadeDecres());
	}
	
	
	
	//----------------Data Crescente e decrescente -----------------------------------------------	
	@GetMapping("/data/asc")
	public ResponseEntity<List<Evento>> listarDataAsc(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listarDataCres());
	}
	
	@GetMapping("/data/desc")
	public ResponseEntity<List<Evento>> listarDataDesc(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listarNomeEventoDecres());
	}
	
	
	
	
	
	
	//----------------Preço do Evento Crescente e decrescente ------------------------------------
	
	@GetMapping("/preco/asc")
	public ResponseEntity<List<Evento>> listarPrecoAsc(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listarPrecoCres());
	}
	
	@GetMapping("/preco/desc")
	public ResponseEntity<List<Evento>> listarPrecoDesc(){
		
		return  ResponseEntity.status(HttpStatus.OK).body(eventoService.listarPrecoDecres());
	}
	

}
















