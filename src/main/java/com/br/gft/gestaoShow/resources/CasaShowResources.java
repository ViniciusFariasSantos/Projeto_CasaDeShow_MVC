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

import com.br.gft.gestaoShow.model.Show;
import com.br.gft.gestaoShow.services.CasaShowService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Casa")
@RestController
@RequestMapping("/show")
public class CasaShowResources {
	
	@Autowired
	private CasaShowService casaShowService;
	
	@ApiOperation("Listar as casas de Show")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Show>> listar(){
		
		List<Show> autores = casaShowService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(autores);
		
	}
	
	@ApiOperation("Salvar as casas de Show")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid  @RequestBody Show show){
		
		show = casaShowService.salvar(show);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(show.getCodigoShow()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
	//---------------------Buascando por ID---------------------------------------------------------
	
	@ApiOperation("Buscar as casas de Show")
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Optional<Show>> buscar (@PathVariable("id") Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(casaShowService.buscar(id));
		
	}

	@ApiOperation("Deletar as casas de Show")
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar (@PathVariable("id") Long codigoShow) {
		
		
			
		this.casaShowService.deletar(codigoShow);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@ApiOperation("atualizar as casas de Show")
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar (@RequestBody Show show, @PathVariable("id") Long codigoShow) {
		show.setCodigoShow(codigoShow);
		
		
		casaShowService.atualizar(show);
		return ResponseEntity.noContent().build();
		
	}
	
	
	//----------------Nome do Evento Crescente e decrescente -----------------------------------
		@ApiOperation("Listar as casas de Show em ordem crescente")	
		@GetMapping("/nome/asc")
		public ResponseEntity<List<Show>> listarNomeEventoAsc(){
			
			return  ResponseEntity.status(HttpStatus.OK).body(casaShowService.listarNomeCasaShowCres());
		}
		
		@ApiOperation("Listar as casas de Show em ordem Decrescente")
		@GetMapping("/nome/desc")
		public ResponseEntity<List<Show>> listarNomeEventoDesc(){
			
			return  ResponseEntity.status(HttpStatus.OK).body(casaShowService.listarNomeCasaShowDecres());
		}
	
		//--------------------Buscando por nome-----------------------------------------------------
		@ApiOperation("buscar por nome as casas de Show ")
		@RequestMapping(value = "/nome/{nomeCasaShow}",method = RequestMethod.GET)
		public ResponseEntity<List<Show>> buscarNome (@PathVariable("nomeCasaShow") String nomeCasaShow){
			List<Show> casa = casaShowService.buscarNome(nomeCasaShow);
			return ResponseEntity.status(HttpStatus.OK).body(casa);
			
		}
}




















