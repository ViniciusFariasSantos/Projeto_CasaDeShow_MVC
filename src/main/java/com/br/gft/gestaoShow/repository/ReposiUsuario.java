package com.br.gft.gestaoShow.repository;

import org.springframework.data.repository.CrudRepository;

import com.br.gft.gestaoShow.model.Usuario;

public interface ReposiUsuario extends CrudRepository<Usuario, String >{
	
	Usuario findByLogin(String login);
	
}
