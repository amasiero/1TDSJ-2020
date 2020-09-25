package br.com.fiap.salarios.model;

public class Horista extends Colaborador {

	private int horasTrabalhadas;
	private double valorHora;
	
	public Horista(String nome, String departamento, double valorHora) {
		super(nome, departamento);
		this.valorHora = valorHora;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public double getValorHora() {
		return valorHora;
	}
	
	@Override
	public double calculaSalario() {
		return horasTrabalhadas * valorHora * IMPOSTO;
	}
	
}
