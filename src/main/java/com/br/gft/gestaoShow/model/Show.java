package com.br.gft.gestaoShow.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;






		

@Entity(name = "CADASTRO_CASA_DE_SHOW")
public class Show {
	// Declaração das variaveis 
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long codigoShow;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="nomeCasaShow")
	@JsonIgnore
	List<Evento> evento ;

	
	@NotEmpty(message = "Error: O endereço é obrigatório")
	private String local;
		
	@NotEmpty(message = "Error: O Nome da casa de show é obrigatório")
	private String nomeCasaShow;
	
	
	
	//getters e Setters 
	
	
	
	

	public Long getCodigoShow() {
		return codigoShow;
	}
	public void setCodigoShow(Long codigoShow) {
		this.codigoShow = codigoShow;
	}
	public List<Evento> getEvento() {
		return evento;
	}
	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getNomeCasaShow() {
		return nomeCasaShow;
	}
	public void setNomeCasaShow(String nomeCasaShow) {
		this.nomeCasaShow = nomeCasaShow;
	}
	//hasCode e equals do Código para assim gerar um id automático. 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoShow == null) ? 0 : codigoShow.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		if (codigoShow == null) {
			if (other.codigoShow != null)
				return false;
		} else if (!codigoShow.equals(other.codigoShow))
			return false;
		return true;
	}

	
	
	
}
