package com.br.gft.gestaoShow.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.br.gft.gestaoShow.model.Usuario;
import com.br.gft.gestaoShow.repository.ReposiUsuario;
import com.br.gft.gestaoShow.services.exceptions.AutorExistenteException;
import com.br.gft.gestaoShow.services.exceptions.AutorNaoEncontradoException;


@Service
public class UsuarioService {
	
	@Autowired
	private ReposiUsuario usuarioRepository; 
	
	public Iterable<Usuario> listar (){
		return  usuarioRepository.findAll(); 
	}
	
	public Usuario salvar (Usuario usuario) {
		
		if(usuario.getLogin() != null) {
			
			Usuario a = usuarioRepository.findById(usuario.getLogin()).orElse(null);
			
			if (a != null) {
				
				throw new AutorExistenteException("O casa de show já existe");
			}
			
		}
		
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> buscar(String id) {
		
		Optional<Usuario> autor = usuarioRepository.findById(id);
		
		if(autor.isEmpty()  ) {
			throw new AutorNaoEncontradoException("A Casa de show não existente");
		}
		return autor; 
	}
	
	
}
