package com.br.gft.gestaoShow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotEmpty;

@Entity(name = "CADASTRO_CASA_DE_SHOW")
public class Show {
	// Declaração das variaveis 
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public Long codigo;
	
//	@NotEmpty(message = "Error: O nome da casa de show é obrigatório")
	public String nomeCasaShow;
	
	//@NotEmpty(message = "Error: O endereço é obrigatório")
	public String local;
	
	
	//getters e Setters 
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeCasaShow() {
		return nomeCasaShow;
	}
	public void setNomeCasaShow(String nomeCasaShow) {
		this.nomeCasaShow = nomeCasaShow;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	//hasCode e equals do Código para assim gerar um id automático. 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
}
