import java.util.Scanner; // java/util/Scanner.class

import javax.swing.JOptionPane;

public class TesteCliente {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe o seu numero de telefone: ");
		int numero = scan.nextInt();
		
		System.out.print("Informe o seu ddd: ");
		int ddd = scan.nextInt();
		
		System.out.print("Informe o seu codigo de operadora: ");
		int operadora = scan.nextInt();
		
		System.out.print("Informe o seu ramal: ");
		int ramal = scan.nextInt();
		
		scan.close();
		
		Telefone telefone = new Telefone(numero, ramal, operadora, ddd);
		
		String nome = JOptionPane.showInputDialog("Informe seu nome");
		String email = JOptionPane.showInputDialog("Informe seu email");
		String endereco = JOptionPane.showInputDialog("Informe seu endereco");
		
		Cliente cliente = new Cliente(nome, email, telefone, endereco);
		
		System.out.println("O nome do cliente eh " + cliente.getNome());
		JOptionPane.showMessageDialog(null, "O nome do cliente eh " + cliente.getNome());
		
	}
	
}
