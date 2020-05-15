
public class Metodos {

	public static void metodo2() {
		System.out.println("Iniciando o m�todo 2");
		
		try {
			int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			for(int i = 0; i <= 10; i++) System.out.println(numeros[i]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finalizando o m�todo 2");
	}
	
	public static void metodo1() {
		System.out.println("Iniciando o m�todo 1");
		metodo2();
		System.out.println("Finalizando o m�todo 1");
	}
	
	public static void main(String[] args) {
		System.out.println("Iniciando o m�todo MAIN");
		metodo1();
		System.out.println("Finalizando o m�todo MAIN");
	}
}
