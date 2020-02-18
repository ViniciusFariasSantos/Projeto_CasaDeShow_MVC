package com.br.gft.gestaoShow.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.gft.gestaoShow.model.Show;
import com.br.gft.gestaoShow.model.StatuShow;
import com.br.gft.gestaoShow.repository.ReposiShow;


@Controller

public class ControllerEvento {
	@Autowired
	public ReposiShow repositorio;
	
	@RequestMapping("/home/cadastroEvento")
	public String cadastrarEvento() {

		return "CadastroEvento";
		
	}
	
	@RequestMapping("/home/pesquisaEvento")
	public String pesquisarEvento() {
		
		return"PesquisaEvento";
	}
	
	

	
	@ModelAttribute("statusEvento")
	public List<Show> casas(){
		
		return repositorio.findAll();
	}

	
	
			
}
