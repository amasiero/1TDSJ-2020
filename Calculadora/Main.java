import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// Criando o objeto calculadora
		Calculadora calc = new Calculadora();
		Scanner entrada = new Scanner(System.in);

		System.out.print("Digite um numero: ");
		int numero1 = entrada.nextInt();
		System.out.print("Digite outro numero: ");
		int numero2 = entrada.nextInt();

		// atribuir os valores de a e b
		calc.a = numero1;
		calc.b = numero2;

		// invocacao do metodo soma
		calc.soma();

		// invocacao do metodo multiplicacao
		int resultadoMultiplicacao = calc.multiplicacao();
		System.out.println("A multiplicacao foi " + resultadoMultiplicacao);

		// invocao do metodo subtracao
		calc.subtracao(numero1, numero2);

		// invocacao do metodo divisao
		int resultadoDivisao = calc.divisao(numero1, numero2);
		System.out.println("A divisao foi " + resultadoDivisao);

	}
}