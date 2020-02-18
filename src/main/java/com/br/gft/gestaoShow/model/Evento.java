package com.br.gft.gestaoShow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;






@Entity(name="CADASTRO_EVENTO")
public class Evento {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Error : O Evento é obrigatório")
	private String evento;
	
	@NotEmpty(message = "Error : O Capacidade é obrigatório")
	private String capacidade;
	
	@NotNull(message ="Error: Data  é obrigatório")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NotNull
	private Number valorIngresso;

	@OneToMany(mappedBy="nomeCasaShow")
	List<Show> show = new ArrayList <Show>();

	
	
	//Gatters and Satters 	
	
	public List<Show> getShow() {
		return show;
	}
	public void setShow(List<Show> show) {
		this.show = show;
	}
	public StatuShow getStatus() {
		return status;
	}
	
	public void setStatus(StatuShow status) {
		this.status = status;
	}
	@Enumerated(EnumType.STRING)
	public StatuShow status;
	
	
	
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
