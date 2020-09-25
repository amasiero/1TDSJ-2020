package br.com.fiap.salarios.model;

public class Mensalista extends Colaborador implements HoraExtra {

	private double salario;
	
	public Mensalista(String nome, String departamento, double salario) {
		super(nome, departamento);
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}
	
	@Override
	public double calculaSalario() {
		return salario * IMPOSTO;
	}


	@Override
	public double calcula(int qtdeHoras) {
		return 150 * qtdeHoras;
	}
}
