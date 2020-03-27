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
		veiculo.setMarca("Dodge");

		System.out.printf("O veiculo %s %s, com placa %s deu entrada no estacionamento.\n",
				veiculo.getMarca(), veiculo.getModelo(), veiculo.getPlaca());
		
		scan.close();
	}

}
