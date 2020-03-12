package com.br.gft.gestaoShow.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.br.gft.gestaoShow.model.Usuario;
import com.br.gft.gestaoShow.repository.ReposiUsuario;
import com.br.gft.gestaoShow.services.exceptions.UsuarioExistenteException;
import com.br.gft.gestaoShow.services.exceptions.UsuarioNaoEncontradoException;


@Service
public class UsuarioService {
	
	@Autowired
	private ReposiUsuario usuarioRepository; 
	
	
	//----------------- Listar o nome do usario----------------
	public Iterable<Usuario> listar (){
		return  usuarioRepository.findAll(); 
	}
	
	
	//-----------------Buscar o id do usuario ----------------
	public Usuario salvar (Usuario usuario) {
		
		if(usuario.getId() != null) {
			
			Usuario a = usuarioRepository.findById(usuario.getId()).orElse(null);
			
			if (a != null) {
				
				throw new UsuarioExistenteException("O Usuario já existe");
			}
			
		}
		
		return usuarioRepository.save(usuario);
	}
	
	
	//------------------- buscar o nome do usuario--------------------
	public Optional<Usuario> buscar(Long id) {
		
		Optional<Usuario> autor = usuarioRepository.findById(id);
		
		if(autor.isEmpty()  ) {
			throw new UsuarioNaoEncontradoException("O Usuario não existe");
		}
		return autor; 
	}
	
	
}
