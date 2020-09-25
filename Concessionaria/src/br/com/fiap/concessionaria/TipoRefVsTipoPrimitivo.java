package br.com.fiap.concessionaria;

public class TipoRefVsTipoPrimitivo {
	
	public static void main(String[] args) {
		System.out.println(new XRef().x.hashCode());
		System.out.println(new XPrimitivo().x);
		
	}

}

class XRef {
	Double x = 12.0;
}

class XPrimitivo {
	double x;
}
