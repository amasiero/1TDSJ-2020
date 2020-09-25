package br.com.fiap.salarios.model;

public abstract class Colaborador {
	
	private String nome;
	private String departamento;
	protected final double IMPOSTO; // Protected é acesso por classes do mesmo pacote e hierarquia
	
	public Colaborador(String nome, String departamento) {
		this.nome = nome;
		this.departamento = departamento;
		this.IMPOSTO = (1 - 0.275);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public abstract double calculaSalario();
}
