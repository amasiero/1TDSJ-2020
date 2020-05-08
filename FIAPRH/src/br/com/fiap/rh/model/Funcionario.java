package br.com.fiap.rh.model;

public class Funcionario {
	protected String nome;
	protected int cpf;
	protected double salario;

	public Funcionario(String nome, int cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		System.out.println("Construtor de Funcionario");
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return this.nome;
	}

	public int getCpf() {
		return this.cpf;
	}

	public double getSalario() {
		return this.salario;
	}

}
