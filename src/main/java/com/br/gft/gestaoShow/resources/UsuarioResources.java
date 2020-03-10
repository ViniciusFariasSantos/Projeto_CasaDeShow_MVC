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

import com.br.gft.gestaoShow.model.Usuario;
import com.br.gft.gestaoShow.services.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioResources {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Usuario>> listar(){
		
		Iterable<Usuario> usario = usuarioService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(usario);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid  @RequestBody Usuario usuario){
		
		usuario = usuarioService.salvar(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getLogin()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Usuario>> buscar (@PathVariable("id") String id){
		
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscar(id));
		
	}
	
}
