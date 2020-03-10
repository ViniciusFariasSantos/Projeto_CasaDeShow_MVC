package com.br.gft.gestaoShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.gft.gestaoShow.model.*;


public interface ReposiShow  extends JpaRepository<Show, Long>{
	
	Iterable<Show> findByNomeCasaShowContaining(String nomeCasaShow);
	
	Show findByNomeCasaShow(String nomeCasaShow);
	
	
}
