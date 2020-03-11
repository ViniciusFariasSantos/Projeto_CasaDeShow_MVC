package com.br.gft.gestaoShow.model;





import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;






@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String login;
	
	
	
	private String nomeCompleto;
	
	
	@JsonIgnore
	private String senha;
	
	

	
	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	List<Venda> venda;
	
	
	
	
	//Getters and Setters 
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public List<Venda> getVenda() {
		return venda;
	}



	public void setVenda(List<Venda> venda) {
		this.venda = venda;
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
