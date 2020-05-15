import javax.swing.JOptionPane;

public class Principal {

	public static int recebeNumero(String mensagem) {
		try {
			int numero = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			return numero;
		} catch (NumberFormatException e) {
			System.err.println("Ocorreu um erro ao converter a entrada digitada.");
			System.err.println(e.getMessage());
			return recebeNumero(mensagem);
		}
	}
	
	public static void main(String[] args) {
		
		int numero = recebeNumero("Digite sua idade");
		
		if (numero > 18) {
			System.out.println("Parabéns vc tem acesso a esse conteudo");
		} else {
			System.err.println("You shall not pass!");
		}
	}
}
