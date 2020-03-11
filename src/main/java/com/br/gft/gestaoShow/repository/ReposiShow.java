package com.br.gft.gestaoShow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.gft.gestaoShow.model.*;


public interface ReposiShow  extends JpaRepository<Show, Long>{
	
	public List<Show> findByNomeCasaShowContaining(String nomeCasaShow);
	
	
	
	
}
