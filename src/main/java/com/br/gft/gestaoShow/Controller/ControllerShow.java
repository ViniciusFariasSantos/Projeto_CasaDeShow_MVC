package com.br.gft.gestaoShow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.gft.gestaoShow.model.Show;
import com.br.gft.gestaoShow.repository.ReposiShow;



@Controller
@RequestMapping("/cadastro" )      
public class ControllerShow {
	private static final String CADASTRO_VIEW = "CadastroCasaDeShow";
	
	@Autowired
	public ReposiShow repositorio;
	
	@RequestMapping("/CasaDeShow" )
	public ModelAndView cadastrarShow(Show show) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Show());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Show show, Errors errors, RedirectAttributes attributes) {
	
		if (errors.hasErrors()) {

			return CADASTRO_VIEW;

		}
		
		repositorio.save(show);
		
		attributes.addFlashAttribute("mensagem", "Casa de Show Salvo com sucesso!");
		
		return "redirect:/cadastro/CasaDeShow";
	}


	

	
	@RequestMapping
	public ModelAndView Pesquisa() {
		
		Iterable<Show> novoPesquisa = repositorio.findAll();

		ModelAndView mv = new ModelAndView("PesquisaCasaDeShow");
		
		mv.addObject("showPesquisa", novoPesquisa);
		return mv;

	}
	
	
	@RequestMapping(value="{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Show show) {
		// Estou indo para meu Model Titulo e pegando meus dados e passando para o
		// usuario
		ModelAndView mv = new ModelAndView("redirect:/cadastro/CasaDeShow");
		mv.addObject(show);
		return mv;
	}

	@RequestMapping(path="/excluir/{codigo}")
	public String excluir(@PathVariable ("codigo")Show show) {
		
		
		// Estou indo para meu Model Titulo e excluido os dados
		
		
		this.repositorio.delete(show);
		return "redirect:/cadastro";
	}
	

}