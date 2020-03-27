import java.util.Random;

public class JogoDados {

	private int dado1;
	private int dado2;
	private Jogador jogador1;
	private Jogador jogador2;
	private boolean acabouJogo;
	
	public JogoDados(Jogador jogador1, Jogador jogador2) {
		this.dado1 = 0;
		this.dado2 = 0;
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.acabouJogo = false;		
	}

	public int getDado1() {
		return dado1;
	}

	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}

	public int getDado2() {
		return dado2;
	}

	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public boolean isAcabouJogo() {
		return acabouJogo;
	}

	public void setAcabouJogo(boolean acabouJogo) {
		this.acabouJogo = acabouJogo;
	}
	
	public int lancaDados() {
		return new Random().nextInt(6) + 1;
	}
	
	public void jogar() {
		this.dado1 = this.lancaDados();
		this.dado2 = this.lancaDados();
	}
	
	public String verPlacar() {
		return "Jogador 1: " + this.jogador1.getPontos() + " pontos\nJogador 2: " +
				this.jogador2.getPontos() + " pontos.";
	}
	
	public String vencedor() {
		// TODO depois que a Fernanda mostrar o if.
		// Chamar o método marcar pontos
		return "Jogador X foi vencedor.";
	}
	
	public boolean reiniciar() {
		// TODO depois que a Fernanda mostrar o if.
		// Verificar se o jogo foi finalizado
		return false;
	}
}
