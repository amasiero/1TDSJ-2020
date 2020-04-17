public class Conta { // Tipo por/de referência
	private String titular;
	private int agencia;
	private int numero;
	private double saldo;
	
	public Conta(String titular, int agencia, int numero) {
		this.titular = titular;
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTitular() {
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

	public void deposita(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public boolean saca(double valor) {
		if(this.validaSaldo(valor)) {
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
	
	private boolean validaSaldo(double valor) {
		return this.saldo >= valor;
	}
}