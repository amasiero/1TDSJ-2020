import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteScanner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.print("Digite um numero: ");
			int numero = scan.nextInt();
			System.out.println(numero);
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Sou executado quando sucesso ou fracasso.");
			scan.close();
		}
	}
}
