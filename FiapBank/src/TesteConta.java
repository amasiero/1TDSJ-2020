
public class TesteConta {
	
	public static void main(String[] args) {
		Conta primeiraConta = new Conta("Andrey", 1, 3393);
		primeiraConta.deposita(650);
		
		System.out.println(primeiraConta.getTitular() + "\n" +
				primeiraConta.getAgencia() + "\n" +
				primeiraConta.getNumero() + "\n" +
				primeiraConta.getSaldo());
		
		Conta segundaConta = new Conta("Gustavo", 3, 85569);
		segundaConta.deposita(300);
		System.out.println(segundaConta.getTitular() + "\n" +
				segundaConta.getAgencia() + "\n" +
				segundaConta.getNumero() + "\n" +
				segundaConta.getSaldo());
		boolean sacou = segundaConta.saca(1000);
		if(sacou) {
			System.out.println("Saque efetuado com sucesso.");
		}else {
			System.err.println("Saldo insuficiente.");
		}
		System.out.println(segundaConta.getSaldo());
		
		if(primeiraConta.transfere(250, segundaConta)) {
			System.out.println("Transferência efetuada com sucesso.");
		} else {
			System.err.println("Saldo insulficiente");
		}
		System.out.println(primeiraConta.getSaldo());
		System.out.println(segundaConta.getSaldo());

	}
}
