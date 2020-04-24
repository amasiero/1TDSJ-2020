package br.com.fiap.bank.test;

import br.com.fiap.bank.domain.Conta;


public class TesteTotalContas {
	
	public static void main(String[] args) {
		Conta conta = new Conta(1,1);
		System.out.println(Conta.getTotalContas());
		Conta conta2 = new Conta(1,1);
		System.out.println(Conta.getTotalContas());
		Conta conta3 = new Conta(1,1);
		System.out.println(Conta.getTotalContas());
	}
	
}
