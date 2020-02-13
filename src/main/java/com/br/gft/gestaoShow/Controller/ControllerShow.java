package com.br.gft.gestaoShow.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ControllerShow {

	@RequestMapping("/cadastroCasaDeShow")
	public String cadastrarShow() {

		return "CadastroCasaDeShow";
	}

	@RequestMapping("/cadastroEvento")
	public String cadastrarEvento() {

		return "CadastroEvento";
	}

	@RequestMapping
	public String inicio() {

		return "PaginaInicial";
	}

	
	

	

}
