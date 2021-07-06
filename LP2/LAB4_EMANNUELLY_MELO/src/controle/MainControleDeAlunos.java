package controle;

import java.util.Scanner;

/**
 * Interface com menu que representa um controle de alunos da disciplina de Programa��o II.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 */
public class MainControleDeAlunos {

	public static void main(String[] args) {
		RepositorioAlunos repositorio = new RepositorioAlunos();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, repositorio, scanner);
		}

	}
	
	/**
	 * Exibe o menu e captura a escolha do/a usu�rio/a.
	 * 
	 * @param scanner Para captura da op��o do usu�rio.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
						"(C)adastrar Aluno\n" + 
						"(E)xibir Aluno\n" + 
						"(N)ovo Grupo\n" +
						"(A)locar Aluno no Grupo e Imprimir Grupos\n" +
						"(R)egistrar Aluno que Respondeu\n" +
						"(I)mprimir Alunos que Responderam\n" +
						"(O)ra, vamos fechar o programa!\n" + 
						"\n" + 
						"Op��o> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a op��o escolhida por quem est� usando o sistema. Se a entrada for um campo vazio ou nulo, � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param opcao   Op��o digitada.
	 * @param repositorio  O reposit�rio que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, RepositorioAlunos repositorio, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(repositorio, scanner);
			break;
		case "E":
			consultaAluno(repositorio, scanner);
			break;
		case "N":
			cadastraGrupo(repositorio, scanner);
			break;
		case "A":
			alocarAlunoOuImprimir(scanner, repositorio);
			break;
		case "R":
			registraAlunoQueRespondeu(scanner, repositorio);
			break;
		case "I":
			imprimeAlunoQueRespondeu(repositorio);
			break;
		case "O":
			fechar();
			break;
		case "":
			throw new IllegalArgumentException("Entrada inv�lida");
		default:
			throw new NullPointerException("Entrada nula");
		}
	}
	
	/**
	 * Cadastra um aluno no controle de alunos da disciplina. Caso o aluno j� esteja presente no controle, � alertado que a matr�cula j� est� cadastrada. Caso contr�rio, � indicado que o cadastro foi realizado.
	 * 
	 * @param repositorio reposit�rio que d� acesso aos dados dos alunos.
	 * @param scanner captura matr�cula, nome e o curso do estudante.
	 */
	private static void cadastraAluno(RepositorioAlunos repositorio, Scanner scanner ) {
		System.out.print("\nMatr�cula: ");
		String matricula = scanner.nextLine();
		System.out.print("\nNome: ");
		String nome = scanner.nextLine();
		System.out.print("\nCurso: ");
		String curso = scanner.nextLine();
		if(repositorio.existeAluno(matricula)) {
			System.out.println("");
			System.out.println("MATR�CULA J� CADASTRADA!");
			System.out.println("");
		} else {
			System.out.println("");
			repositorio.cadastraAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!");
			System.out.println("");
		}
	}
	
	/**
	 * Exibe matr�cula, nome e curso do aluno, a partir da matr�cula referenciada. Se for apresentada uma matr�cula n�o cadastrada � avisado que o aluno n�o est� cadastrado.
	 * 
	 * @param repositorio reposit�rio que d� acesso aos dados dos alunos.
	 * @param scanner captura matr�cula do estudante.
	 */
	private static void consultaAluno(RepositorioAlunos repositorio, Scanner scanner) {
		System.out.print("\nMatr�cula: ");
		String matricula = scanner.nextLine();
		if(repositorio.existeAluno(matricula)) {
			System.out.println(repositorio.aluno(matricula));
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("Aluno n�o cadastrado.");
			System.out.println("");
		}
	}
	
	/**
	 * Faz o cadastro de um grupo, a partir de um nome escolhido pelo usu�rio. Letras mai�sculas e min�sculas s�o indistintas. Se o nome escolhido j� estiver cadastrado, o sistema avisa que o grupo j� est� cadastrado.
	 * 
	 * @param repositorio reposit�rio que d� acesso aos dados dos alunos.
	 * @param scanner captura nome do grupo.
	 */
	private static void cadastraGrupo(RepositorioAlunos repositorio, Scanner scanner) {
		System.out.print("\nGrupo: ");
		String nomeGrupo = scanner.nextLine().toUpperCase();
		if(repositorio.existeGrupo(nomeGrupo)) {
			System.out.println("GRUPO J� CADASTRADO!");
			System.out.println("");
		} else {
			repositorio.cadastraGrupo(nomeGrupo);
			System.out.println("CADASTRO REALIZADO!");
			System.out.println("");
		}
	}
	
	/**
	 * Disponibiliza a op��o de alocar um aluno em um grupo ou de imprimir um grupo j� cadastrado com seus integrantes. Indica se a matr�cula fornecida est� cadastrada e se o grupo dado est� cadastrado.
	 * 
	 * @param scanner captura a escolha de alocar ou de imprimir feita pelo usu�rio. Caso seja desejado alocar um aluno, captura nome do grupo e matr�cula do aluno. Caso contr�rio, � pedido o nome do grupo a ser impresso.
	 * @param repositorio reposit�rio que d� acesso aos dados dos alunos.
	 */
	private static void alocarAlunoOuImprimir(Scanner scanner, RepositorioAlunos repositorio) {
		System.out.print("\n(A)locar Aluno ou (I)mprimir Grupo? ");
		String acao = scanner.nextLine().toUpperCase();
		if(acao.equals("A")) {
			System.out.print("\nMatr�cula: ");
			String matricula = scanner.nextLine();
			System.out.print("\nGrupo: ");
			String nomeGrupo = scanner.nextLine().toUpperCase();
			if(repositorio.existeAlocado(nomeGrupo, matricula)) {
				System.out.println("ALUNO ALOCADO!");
			} else if(!repositorio.existeAluno(matricula)) {
				System.out.println("ALUNO N�O CADASTRADO!");
			} else if(!repositorio.existeGrupo(nomeGrupo)) {
				System.out.println("GRUPO N�O CADASTRADO!");
			} else {
				repositorio.cadastraAlunoEmGrupo(nomeGrupo, matricula);
				System.out.println("ALUNO ALOCADO!");
			}
		} else if(acao.equals("I")) {
			System.out.print("\nGrupo: ");
			String nomeGrupo = scanner.nextLine().toUpperCase();
			if(repositorio.existeGrupo(nomeGrupo)) {
				System.out.println("Alunos do grupo: " + nomeGrupo);
				for(String matricula : repositorio.imprimeGrupo(nomeGrupo)) {
					System.out.print("\n* " + matricula + " - " + repositorio.getNomeAluno(matricula) + " - " + repositorio.getNomeCurso(matricula) + "\n");
				}
			} else {
				System.out.println("GRUPO N�O CADASTRADO!");
			}
		}
		System.out.println("");
	}
	
	/**
	 * Registra alunos que respondem perguntas. Indica se a matr�cula fornecida n�o est� cadastrada.
	 * @param scanner captura a matr�cula do estudante que respondeu.
	 * @param repositorio reposit�rio que fornece dados dos alunos.
	 */
	private static void registraAlunoQueRespondeu(Scanner scanner, RepositorioAlunos repositorio) {
		System.out.print("\nMatr�cula: ");
		String matricula = scanner.nextLine();
		System.out.println("");
		if(repositorio.existeAluno(matricula)) {
			repositorio.registraAlunosQueRespondem(matricula);
			System.out.println("ALUNO REGISTRADO!");
		} else {
			System.out.println("ALUNO N�O CADASTRADO!");
		}
		System.out.println("");
	}
	
	/**
	 * Imprime, em ordem, a matr�cula, o nome e o curso dos alunos que responderam.
	 * 
	 * @param repositorio reposit�rio com dados de alunos.
	 */
	private static void imprimeAlunoQueRespondeu(RepositorioAlunos repositorio) {
		System.out.println("Alunos:");
		int cont = 1;
		for(String matricula : repositorio.imprimeAlunosQueRespondem()) {
			System.out.println(cont + ". " + matricula + " - " + repositorio.getNomeAluno(matricula) + " - " + repositorio.getNomeCurso(matricula));
			cont ++;
		}
		System.out.println("");
	}
	
	/**
	 * Fecha o sistema.
	 */
	private static void fechar() {
		System.exit(0);
	}
}
