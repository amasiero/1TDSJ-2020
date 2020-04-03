import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe a placa do veiculo: ");
		String placa = scan.nextLine();
		
		System.out.print("Informe a marca do veiculo: ");
		String marca = scan.nextLine();
		
		System.out.print("Informe o modelo do veiculo: ");
		String modelo = scan.nextLine();
		
		Veiculo veiculo = new Veiculo(placa, marca, modelo);
		Ticket ticket = new Ticket(veiculo);
		
		System.out.println(veiculo);
		System.err.println(ticket); // err -> Exibição de erro -> Fica vermelho no terminal
		
		System.out.printf("O veiculo %s %s, com placa %s deu entrada no estacionamento na data de %s.\n",
				ticket.getVeiculo().getMarca(), ticket.getVeiculo().getModelo(), ticket.getVeiculo().getPlaca(), ticket.entradaParaTexto());
		
		try { // Aguarda um minuto
			Thread.sleep(60000);
		} catch(Exception e) {
			
		}
		
		ticket.registraSaida();
		System.err.println(ticket);
		System.out.printf("O veiculo %s %s, com placa %s deu saida do estacionamento na data de %s.\nO valor pago foi de R$ %.2f.",
				ticket.getVeiculo().getMarca(), ticket.getVeiculo().getModelo(), ticket.getVeiculo().getPlaca(), ticket.saidaParaTexto(), ticket.getValor());
		
		
		scan.close();
	}

}
