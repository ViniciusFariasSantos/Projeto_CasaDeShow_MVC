package com.br.gft.gestaoShow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.gft.gestaoShow.model.Evento;
import com.br.gft.gestaoShow.repository.ReposiEvento;
import com.br.gft.gestaoShow.repository.ReposiShow;

@Controller
@RequestMapping("/home")    
public class ControllerPaginas {
	@Autowired
	public ReposiShow repositorio;
	
	@Autowired 
	public ReposiEvento reposiEvento;
	
	

	
	@RequestMapping
	public ModelAndView inicio2(@RequestParam(defaultValue="") String nomeEvento, Evento evento) {
		Iterable<Evento> novoPesquisa = this.reposiEvento.findByNomeEventoContaining( nomeEvento);
	
		ModelAndView mv = new ModelAndView("PaginaInicial");
		mv.addObject("eventoPesquisa", novoPesquisa);
		mv.addObject(new Evento());
		
		return mv;
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "Login";
		
	}
}
