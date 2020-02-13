package com.br.gft.gestaoShow.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name="CADASTRO_EVENTO")
public class Evento {
	@Id
	public Long codigo;
	
	public String evento;
	
	public String capacidade;
	
	public Date data;
	
	public Number valorIngresso;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public Date getData() {
		return data;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Number getValorIngresso() {
		return valorIngresso;
	}
	public void setValorIngresso(Number valorIngresso) {
		this.valorIngresso = valorIngresso;
	}

	
	
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
		Evento other = (Evento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
