package br.com.fiap.pousada.domain;

public enum Categoria {
	
	VIP("VIP"), 
	APARTAMENTO("Apartamento");
	
	private String value;
	
	private Categoria(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
