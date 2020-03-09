//package com.br.gft.gestaoShow.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//
//import com.br.gft.gestaoShow.model.Usuario;
//import com.br.gft.gestaoShow.repository.ReposiUsuario;
//
//
//
//@Repository
//public class ImplementsUserDetailService implements UserDetailsService{
//	
//	@Autowired
//	private ReposiUsuario ur;
//	
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//		Usuario usuario = ur.findByLogin(login);
//		
//		if(usuario == null ) {
//			
//			throw new UsernameNotFoundException ("Usuário não encontrado!");
//			
//		}
//		
//		return usuario;
//	}
//
//}
