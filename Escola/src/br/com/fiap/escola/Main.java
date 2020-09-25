package br.com.fiap.escola;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.escola.dao.AlunoDAO;
import br.com.fiap.escola.domain.Aluno;
import br.com.fiap.escola.exception.CadastroAlunoException;

public class Main {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int opcao = 0;
			do {
				menu();
				System.out.print("> ");
				opcao = scan.nextInt();

				switch (opcao) {
				case 1 -> cadastraAluno(scan);
				case 2 -> consultaPorRM(scan);
				case 3 -> consultaALunos();
				case 4 -> atualizaNotas(scan);
				case 5 -> excluiAluno(scan);
				}

				System.out.println("\n\n");
			} while (opcao != 0);

			System.out.println("#--- Programa finalizado com sucesso ---#");
		}

	}

	private static void excluiAluno(Scanner scan) {
		System.out.println("#--- EXCLUI CADASTRO DO ALUNO ---#");
		try {
			System.out.print("Digite o número do RM: > ");
			Integer rm = scan.nextInt();

			AlunoDAO dao = new AlunoDAO();
			dao.exclui(rm);

			System.out.println("#--- ALUNO REMOVIDO COM SUCESSO.");
		} catch (CadastroAlunoException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void atualizaNotas(Scanner scan) {
		System.out.println("#--- ATUALIZA CADASTRO DO ALUNO ---#");
		try {
			Aluno aluno = buscaAlunoPorRM(scan);

			System.out.print("Digite a nota 1: > ");
			Double nota1 = scan.nextDouble();

			System.out.print("Digite a nota 2: > ");
			Double nota2 = scan.nextDouble();

			aluno.setNota1(nota1);
			aluno.setNota2(nota2);

			AlunoDAO dao = new AlunoDAO();
			dao.atualiza(aluno);

			System.out.println("#--- Cadastro atualizado com sucesso.");
		} catch (CadastroAlunoException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void consultaALunos() {
		System.out.println("#--- CONSULTA ALUNOS ---#");
		try {
			AlunoDAO dao = new AlunoDAO();
			List<Aluno> alunos = dao.consultaTodos();
			for (int i = 0; i < alunos.size(); i++) {
				System.out.println(alunos.get(i));
			}
		} catch (CadastroAlunoException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void consultaPorRM(Scanner scan) {
		System.out.println("#--- CONSULTA ALUNO POR RM ---#");
		try {
			Aluno aluno = buscaAlunoPorRM(scan);
			System.out.println(aluno);
		} catch (CadastroAlunoException e) {
			System.err.println(e.getMessage());
		}
	}

	private static void cadastraAluno(Scanner scan) {
		System.out.println("#--- NOVO ALUNO ---#");

		System.out.print("Digite o número do RM: > ");
		Integer rm = scan.nextInt(); // não pega o caracter de nova linha '\n' (mas ele fica na memória)
		scan.nextLine(); // Para evitar erro de digitacao abaixo

		System.out.print("Digite o nome: > ");
		String nome = scan.nextLine(); // O nextline entende que o \n foi digitado

		Aluno aluno = new Aluno(rm, nome);
		AlunoDAO dao = new AlunoDAO();

		try {
			aluno = dao.salva(aluno);
		} catch (CadastroAlunoException e) {
			System.err.println(e.getMessage());
		}

		if (aluno.getId() != null) {
			System.out.println("#--- Cadastro realizado com sucesso.");
		}
		System.out.println(aluno);
	}

	private static Aluno buscaAlunoPorRM(Scanner scan) throws CadastroAlunoException {
		System.out.print("Digite o número do RM: > ");
		Integer rm = scan.nextInt();

		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = dao.consultaPorRm(rm);
		return aluno;
	}

	private static void menu() {
		System.out.println("|-----------------------------|");
		System.out.println("|           ESCOLA            |");
		System.out.println("|                             |");
		System.out.println("| Digite a opção desejada:    |");
		System.out.println("| 1 - Cadastrar aluno         |");
		System.out.println("| 2 - Consultar por RM        |");
		System.out.println("| 3 - Consultar alunos        |");
		System.out.println("| 4 - Atualizar notas         |");
		System.out.println("| 5 - Remover aluno           |");
		System.out.println("| 0 - Sair do sistema         |");
		System.out.println("|-----------------------------|");
	}

}
