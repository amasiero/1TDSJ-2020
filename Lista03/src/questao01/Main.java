package questao01;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Voo v = new Voo(123, LocalDate.of(2020, 5, 8));
		Voo v2 = v.clone();
	}
}
