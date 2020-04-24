package br.com.fiap.bank.test;
import br.com.fiap.bank.domain.Conta;

public class TesteReferencia {
	public static void main(String[] args) {
		Conta conta = new Conta(1, 2);
		conta.deposita(500);
		System.out.println(conta.getSaldo());
		
		Conta novaConta = conta;
		System.out.println(novaConta.getSaldo());
		novaConta.deposita(200);
		System.out.println(novaConta.getSaldo());
		System.out.println(conta.getSaldo()); // Qual o valor que será impresso?
		
		System.out.println(novaConta);
		System.out.println(conta); 
	}
}
