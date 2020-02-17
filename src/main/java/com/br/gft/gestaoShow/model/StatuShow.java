package com.br.gft.gestaoShow.model;

public enum StatuShow {

	ROCK("Rock"),
	AXE("Axé"),
	FUNK("Funk"),
	SERTANEJO("Sertanejo"),
	FORRO("Forró"), 
	INTERNACIONAL("Internacional");
	
	private String descricao;
	
	private StatuShow(String descricao) {

		this.descricao = descricao;
			// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}

	
	
	
	

	

}
