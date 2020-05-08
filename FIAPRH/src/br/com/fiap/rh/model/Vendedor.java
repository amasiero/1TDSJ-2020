package br.com.fiap.rh.model;

public class Vendedor extends Funcionario {
	
	private double totalVendas;
	
	public Vendedor(String nome, int cpf, double salario) {
		super(nome, cpf, salario);
		System.out.println("Construtor de Vendedor");
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}
	
	public double calculaSalario() {
		return this.salario + (this.totalVendas * .15);
	}
}
