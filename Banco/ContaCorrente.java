class ContaCorrente {
	int agencia;
	int numero;
	double saldo;
	Pessoa cliente;

	double saca(double valor) {
		double saldoAtualizado = saldo - valor;
		saldo = saldoAtualizado;

		// saldo = saldo - valor;
		// saldo -= valor;

		return saldo;
	}

	double deposita(double valor) {
		double saldoAtualizado = saldo + valor;
		saldo = saldoAtualizado;
		return saldo;
	}
}