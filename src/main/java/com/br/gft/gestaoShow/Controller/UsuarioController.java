//package com.br.gft.gestaoShow.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.Errors;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.br.gft.gestaoShow.model.Usuario;
//import com.br.gft.gestaoShow.repository.ReposiUsuario;
//
//@Controller
//
//@RequestMapping("/cadastroCli")
//public class UsuarioController {
//	
//	@Autowired
//	public ReposiUsuario reposiUsuario;
//	
//	
//	@RequestMapping("/cadastroCliente")
//	public ModelAndView cadastroCliente() {
//		ModelAndView mv = new ModelAndView("CadastroCliente");
//		mv.addObject(new Usuario());
//		
//		return mv;
//		
//	}
//	
//	
//	
//	@RequestMapping(method=RequestMethod.POST)
//	public String salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes ) {
//		if(errors.hasErrors()) {
//			
//			return "CadastroCliente";
//		}
//		
//		this.reposiUsuario.save(usuario);
//					
//		attributes.addFlashAttribute("mensagem","Todos os dados foram Salvos");
//		return"redirect:/castroCliente";
//		
//	}
//	
//	
//
//}
