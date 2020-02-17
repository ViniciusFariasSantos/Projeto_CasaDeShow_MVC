package com.br.gft.gestaoShow.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@ModelAttribute("todosStatusShow")
	public List<StatuShow> todosStatusShow() {
		// Esta lista é para meu Pedente e recebido, validando eles dois
		return Arrays.asList(StatuShow.values());

	}
	
}
