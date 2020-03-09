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

import com.br.gft.gestaoShow.model.Show;
import com.br.gft.gestaoShow.services.CasaShowService;


@RestController
@RequestMapping("/show")
public class CasaShowResources {
	
	@Autowired
	private CasaShowService autoresService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Show>> listar(){
		
		List<Show> autores = autoresService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(autores);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid  @RequestBody Show show){
		
		show = autoresService.salvar(show);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(show.getCodigoShow()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Show>> buscar (@PathVariable("id") Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(autoresService.buscar(id));
		
	}
	
}
