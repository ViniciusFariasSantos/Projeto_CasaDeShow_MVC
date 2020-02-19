package com.br.gft.gestaoShow.model;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;






@Entity(name="CADASTRO_EVENTO")
public class Evento {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message = "Error : O Evento é obrigatório")
	private String nomeEvento;
	
	@NotNull(message = "Error : A capacidade obrigatório")
	private Number capacidade;
	
	@NotNull(message ="Error: Data  é obrigatório")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NotNull(message = "Error : O valor do Ingresso é obrigatório")
	private Number valorIngresso;


	@ManyToOne
	@JoinColumn(name="nomeCasaShow")
	private Show nomeCasaShow;
	
	
	
	
	//Gatters and Satters 	

	


	
	
	
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Number getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Number capacidade) {
		this.capacidade = capacidade;
	}
	public Date getData() {
		return data;
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
	public Show getNomeCasaShow() {
		return nomeCasaShow;
	}
	public void setNomeCasaShow(Show nomeCasaShow) {
		this.nomeCasaShow = nomeCasaShow;
	}
	
	//hashcode Equals
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
