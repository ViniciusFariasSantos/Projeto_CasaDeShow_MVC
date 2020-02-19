package com.br.gft.gestaoShow.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.gft.gestaoShow.model.Evento;
import com.br.gft.gestaoShow.model.Show;
import com.br.gft.gestaoShow.model.StatuShow;
import com.br.gft.gestaoShow.repository.ReposiEvento;
import com.br.gft.gestaoShow.repository.ReposiShow;



@Controller
@RequestMapping("/cadastroEve" )      
public class ControllerEvento<StatusShow> {
	
	public static final String CADASTRO_VIEW = "CadastroEvento";
	
	@Autowired
	public ReposiShow repositorio;
	 
	@Autowired
	public ReposiEvento reposiEvento;
	
	@RequestMapping("/cadastroEvento")
	public ModelAndView cadastrarEvento() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Evento());
		
		return mv;
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(Evento evento, Errors errors, RedirectAttributes attributes ) {
		if(errors.hasErrors()) {
			
			return CADASTRO_VIEW;
		}
		
		this.reposiEvento.save(evento);
					
		attributes.addFlashAttribute("mensagem","Todos os dados foram Salvos");
		return"redirect:/cadastroEve/cadastroEvento";
		
	}
	
	
	
	//Pagina de Pesquisa do Evento, listando todos os eventos 
	@RequestMapping("/pesquisa")
	public String pesquisarEvento() {
		
		return"PesquisaEvento";
	}

	
	
	
	//buscando do banco de Daods e adicionando no Select da Pagina Html 
	@ModelAttribute("statusEvento")
	public List<Show> casas(){
		
		return repositorio.findAll();
	}


	//Adicionando no Select da Pagina Html 
	@ModelAttribute("StatusEstilo")
	public List<StatuShow> todosStatusTitulo() {
		// Esta lista é para meu Pedente e recebido, validando eles dois
		return Arrays.asList(StatuShow.values());

	}
	
			
}
