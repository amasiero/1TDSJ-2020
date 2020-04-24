package exercicio02;

public class TesteData {
	public static void main(String[] args) {
		
		Data data = new Data(-1, 2, 2020);
		System.out.println(data);
		
		data = new Data(2, 2, 2020);
		
		System.out.println(data);
		System.out.println(data.isBissexto());
		
		Data data2 = data.clone();
		System.out.println(data2);
		
		System.out.println(data == data2);
		System.out.println(data.compara(data2));
		
		Data data3 = new Data(2, 2, 2021);
		Data data4 = new Data(2, 1, 2020);
		Data data5 = new Data(3, 2, 2020);
		
		System.out.println(data.compara(data3));
		System.out.println(data.compara(data4));
		System.out.println(data.compara(data5));
		
		System.out.println(data.getMesExtenso());
	}
}
