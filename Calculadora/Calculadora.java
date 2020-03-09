class Calculadora {
	int a;
	int b;

	void soma() {
		int resultado = a + b;
		System.out.println("A soma foi " + resultado);
	}

	int multiplicacao() {
		int resultado = a * b;
		return resultado;
	}

	void subtracao(int x, int y) {
		int resultado = x - y;
		System.out.println("A subtracao foi " + resultado);
	}

	int divisao(int numerador, int denominador) {
		int resultado = numerador / denominador;
		return resultado;
	}
}