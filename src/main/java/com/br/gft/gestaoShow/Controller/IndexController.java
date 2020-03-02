package com.br.gft.gestaoShow.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.br.gft.gestaoShow.model.Usuario;
import com.br.gft.gestaoShow.repository.ReposiUsuario;



@Controller
@RequestMapping
public class IndexController {

	@Autowired
	public ReposiUsuario reposiUsuario;
	
	
	
	@RequestMapping({"/", "/home "})
	public String index() {
		
		return "PaginaInicial";
		
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "Login";
		
	}
	
	
	@RequestMapping("/cadastroCliente")
	public ModelAndView cadastroCliente() {
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject(new Usuario());
		
		return mv;
		
	}
	
	
	
	@RequestMapping(value="/cadastroCliente",method=RequestMethod.POST)
	public String salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes ) {
		if(errors.hasErrors()) {
			
			return "CadastroCliente";
		}
		
		this.reposiUsuario.save(usuario);
					
		attributes.addFlashAttribute("mensagem","Todos os dados foram Salvos");
		return"redirect:/cadastroCliente";
		
	}
	
	@GetMapping("/login-error")
	public String loginErro(ModelMap model) {
		
		model.addAttribute("alerta", "error");
		model.addAttribute("titulo", "Credenciais inválidas");
		model.addAttribute("texto", "Login ou senha incorretos, tenta novamente");
		model.addAttribute("subtexto", "Acesso premetido apenas para cadastro já ativados.");
				
		return "Login";
		
	}
	
	
	
}
