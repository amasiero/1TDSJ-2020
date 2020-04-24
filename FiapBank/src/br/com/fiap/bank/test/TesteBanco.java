package br.com.fiap.bank.test;
import br.com.fiap.bank.domain.Cliente;
import br.com.fiap.bank.domain.Conta;

public class TesteBanco {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Andrey", 1, "1TDSJ");
		
		Conta conta = new Conta(1,1,cliente);
		
		conta.setTitular(cliente);
		
		System.out.println(conta.getTitular().getNome().toUpperCase());
		System.out.println(conta.getSaldo());
		
		conta.getTitular().setNome("Pedro Miguel");
		System.out.println(conta.getTitular().getNome());
	}
}
