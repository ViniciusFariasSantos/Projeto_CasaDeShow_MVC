package com.br.gft.gestaoShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.gft.gestaoShow.model.Evento;

public interface ReposiEvento  extends JpaRepository<Evento, Long>{
	Iterable<Evento> findByNomeEventoContaining(String nomeEvento);
	
}
