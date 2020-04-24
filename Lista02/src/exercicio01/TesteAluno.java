package exercicio01;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class TesteAluno {
	public static void main(String[] args) {
		
		int matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe sua matricula"));
		String nome = JOptionPane.showInputDialog("Informe seu nome");
		
		Aluno aluno = new Aluno(matricula, nome);
		
		double nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da prova 1"));
		aluno.setProva1(nota);
		
		nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota da prova 2"));
		aluno.setProva2(nota);
		
		nota = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do trabalho"));
		aluno.setTrabalho(nota);
		
		double media = aluno.calculaMedia();
		double avaliacaoFinal = aluno.calculaAvaliacaoFinal();
		
		DecimalFormat formataNota = new DecimalFormat("#0.0");
		String precisaAvaliacao = avaliacaoFinal == 0 ? "N�o h� a necessidade de avalia��o final." :
			"Ele precisa tirar " + formataNota.format(avaliacaoFinal) + " para ser aprovado.";
		
		String resultado = "O aluno " + aluno.getNome() + " obteve a m�dia de " + 
				formataNota.format(media) + ".\n" + precisaAvaliacao;
		
		JOptionPane.showMessageDialog(null, resultado);
		
	}
}
