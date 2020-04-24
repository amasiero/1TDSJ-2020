package br.com.fiap.bank.domain;

public class Conta { // Tipo por/de referência
	private Cliente titular;
	private int agencia;
	private int numero;
	private double saldo;
	private static int totalContas;
	
	public Conta(int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;
		Conta.totalContas++;
	}
	
	public Conta(int agencia, int numero, Cliente titular) {
		this(agencia, numero);
		this.titular = titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public int getNumero() {
		return this.numero;
	}

	public double getSaldo() {
		return this.saldo;
	}
	
	public static int getTotalContas() {
		return Conta.totalContas;
	}

	public void deposita(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public boolean saca(double valor) {
		if(this.saldoDisponivel(valor)) {
			this.saldo = this.saldo - valor;
			return true;
		}
		return false;
	}
	
	public boolean transfere(double valor, Conta conta) {
		if(this.saca(valor)) {
			conta.deposita(valor);
			return true;
		}
		return false;
	}
	
	private boolean saldoDisponivel(double valor) {
		return this.saldo >= valor;
	}
}