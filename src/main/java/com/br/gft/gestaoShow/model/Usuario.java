package com.br.gft.gestaoShow.model;





import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;






@Entity
public class Usuario {
	
	@Id
	private String login;
	
	
	
	private String nomeCompleto;
	
	
	
	private String senha;
	
	

	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	List<Historico> historico;
	
	
	//Getters and Setters 
	






	public List<Historico> getHistorico() {
		return historico;
	}



	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}



	public String getLogin() {
		return login;
	}

	

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	
}
