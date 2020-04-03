
public class Retangulo {

	private Ponto p1;
	private Ponto p2;
	
	public Retangulo(Ponto p1, Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Ponto getP1() {
		return p1;
	}

	public void setP1(Ponto p1) {
		this.p1 = p1;
	}

	public Ponto getP2() {
		return p2;
	}

	public void setP2(Ponto p2) {
		this.p2 = p2;
	}
	
	public boolean estahDentro(Ponto ponto) {
		return 	ponto.getX() >= this.p1.getX() &&  
				ponto.getX() <= this.p2.getX() &&
				ponto.getY() >= this.p1.getY() &&
				ponto.getY() <= this.p2.getY();
	}
	
	public double distanciaExtremidadeMaisProximo(Ponto ponto) {
		
		double diferencaX = ponto.getX() - this.p1.getX();
		double diferencaY = ponto.getY() - this.p1.getY();
		
		double xAbsoluto = Math.abs(diferencaX);
		double yAbsoluto = Math.abs(diferencaY);
		
		double quadradoX = Math.pow(xAbsoluto, 2);
		double quadradoY = Math.pow(yAbsoluto, 2);
		
		double soma = quadradoX + quadradoY;
		
		double distanciaPontoP1 = Math.sqrt(soma);
		
		diferencaX = ponto.getX() - this.p2.getX();
		diferencaY = ponto.getY() - this.p2.getY();
		
		xAbsoluto = Math.abs(diferencaX);
		yAbsoluto = Math.abs(diferencaY);
		
		quadradoX = Math.pow(xAbsoluto, 2);
		quadradoY = Math.pow(yAbsoluto, 2);
		
		soma = quadradoX + quadradoY;
		
		double distanciaPontoP2 = Math.sqrt(soma);
		
		double resultado = distanciaPontoP1 < distanciaPontoP2 ? distanciaPontoP1 : distanciaPontoP2;
		
		return resultado;
	}
}














