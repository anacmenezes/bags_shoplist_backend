package com.shoplist.bags.domain.enums;

public enum StatusItem {
	
	BOUGHT(1, "Bought"),
	DELETED(2, "Deleted");
	
	private int cod;
	private String descricao;
	
	private StatusItem(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
}
