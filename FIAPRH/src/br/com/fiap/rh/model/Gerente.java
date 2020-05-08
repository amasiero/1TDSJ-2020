package br.com.fiap.rh.model;

public class Gerente extends Funcionario {
	
	private Vendedor[] vendedores;
	private int totalVendedores;
	
	public Gerente(String nome, int cpf, double salario) {
		super(nome, cpf, salario);
		this.vendedores = new Vendedor[10];
		this.totalVendedores = -1;
	}
	
	public Gerente(String nome, int cpf, double salario, int qtdeVendedores) {
		this(nome, cpf, salario);
		this.vendedores = new Vendedor[qtdeVendedores];
	}

	public Vendedor[] getVendedores() {
		return vendedores;
	}
	
	public void adicionaVendedor(Vendedor vendedor) {
		if(this.estahCheia()) {
			System.err.println("Quantidade máxima de vendedores atingida.");
			return;
		}
		
		this.totalVendedores++;
		this.vendedores[this.totalVendedores] = vendedor;
	}
	
	private boolean estahCheia() {
		return this.totalVendedores >= this.vendedores.length;
	}
	
	public int totalVendedores() {
		return this.totalVendedores + 1;
	}
	
	public double calculaSalario() {
		double totalVendas = 0.0;
		for(int i = 0; i <= this.totalVendedores; i++) {
			totalVendas += this.vendedores[i].getTotalVendas();
		}
		
		return this.salario + (totalVendas * .05);
	}
}
