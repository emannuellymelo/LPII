package controle;

import java.util.Scanner;

/**
 * Interface com menu que representa um controle de alunos da disciplina de Programação II.
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
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
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
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema. Se a entrada for um campo vazio ou nulo, é lançada uma exceção que encerra o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param repositorio  O repositório que estamos manipulando.
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
			throw new IllegalArgumentException("Entrada inválida");
		default:
			throw new NullPointerException("Entrada nula");
		}
	}
	
	/**
	 * Cadastra um aluno no controle de alunos da disciplina. Caso o aluno já esteja presente no controle, é alertado que a matrícula já está cadastrada. Caso contrário, é indicado que o cadastro foi realizado.
	 * 
	 * @param repositorio repositório que dá acesso aos dados dos alunos.
	 * @param scanner captura matrícula, nome e o curso do estudante.
	 */
	private static void cadastraAluno(RepositorioAlunos repositorio, Scanner scanner ) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine();
		System.out.print("\nNome: ");
		String nome = scanner.nextLine();
		System.out.print("\nCurso: ");
		String curso = scanner.nextLine();
		if(repositorio.existeAluno(matricula)) {
			System.out.println("");
			System.out.println("MATRÍCULA JÁ CADASTRADA!");
			System.out.println("");
		} else {
			System.out.println("");
			repositorio.cadastraAluno(matricula, nome, curso);
			System.out.println("CADASTRO REALIZADO!");
			System.out.println("");
		}
	}
	
	/**
	 * Exibe matrícula, nome e curso do aluno, a partir da matrícula referenciada. Se for apresentada uma matrícula não cadastrada é avisado que o aluno não está cadastrado.
	 * 
	 * @param repositorio repositório que dá acesso aos dados dos alunos.
	 * @param scanner captura matrícula do estudante.
	 */
	private static void consultaAluno(RepositorioAlunos repositorio, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine();
		if(repositorio.existeAluno(matricula)) {
			System.out.println(repositorio.aluno(matricula));
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("Aluno não cadastrado.");
			System.out.println("");
		}
	}
	
	/**
	 * Faz o cadastro de um grupo, a partir de um nome escolhido pelo usuário. Letras maiúsculas e minúsculas são indistintas. Se o nome escolhido já estiver cadastrado, o sistema avisa que o grupo já está cadastrado.
	 * 
	 * @param repositorio repositório que dá acesso aos dados dos alunos.
	 * @param scanner captura nome do grupo.
	 */
	private static void cadastraGrupo(RepositorioAlunos repositorio, Scanner scanner) {
		System.out.print("\nGrupo: ");
		String nomeGrupo = scanner.nextLine().toUpperCase();
		if(repositorio.existeGrupo(nomeGrupo)) {
			System.out.println("GRUPO JÁ CADASTRADO!");
			System.out.println("");
		} else {
			repositorio.cadastraGrupo(nomeGrupo);
			System.out.println("CADASTRO REALIZADO!");
			System.out.println("");
		}
	}
	
	/**
	 * Disponibiliza a opção de alocar um aluno em um grupo ou de imprimir um grupo já cadastrado com seus integrantes. Indica se a matrícula fornecida está cadastrada e se o grupo dado está cadastrado.
	 * 
	 * @param scanner captura a escolha de alocar ou de imprimir feita pelo usuário. Caso seja desejado alocar um aluno, captura nome do grupo e matrícula do aluno. Caso contrário, é pedido o nome do grupo a ser impresso.
	 * @param repositorio repositório que dá acesso aos dados dos alunos.
	 */
	private static void alocarAlunoOuImprimir(Scanner scanner, RepositorioAlunos repositorio) {
		System.out.print("\n(A)locar Aluno ou (I)mprimir Grupo? ");
		String acao = scanner.nextLine().toUpperCase();
		if(acao.equals("A")) {
			System.out.print("\nMatrícula: ");
			String matricula = scanner.nextLine();
			System.out.print("\nGrupo: ");
			String nomeGrupo = scanner.nextLine().toUpperCase();
			if(repositorio.existeAlocado(nomeGrupo, matricula)) {
				System.out.println("ALUNO ALOCADO!");
			} else if(!repositorio.existeAluno(matricula)) {
				System.out.println("ALUNO NÃO CADASTRADO!");
			} else if(!repositorio.existeGrupo(nomeGrupo)) {
				System.out.println("GRUPO NÃO CADASTRADO!");
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
				System.out.println("GRUPO NÃO CADASTRADO!");
			}
		}
		System.out.println("");
	}
	
	/**
	 * Registra alunos que respondem perguntas. Indica se a matrícula fornecida não está cadastrada.
	 * @param scanner captura a matrícula do estudante que respondeu.
	 * @param repositorio repositório que fornece dados dos alunos.
	 */
	private static void registraAlunoQueRespondeu(Scanner scanner, RepositorioAlunos repositorio) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine();
		System.out.println("");
		if(repositorio.existeAluno(matricula)) {
			repositorio.registraAlunosQueRespondem(matricula);
			System.out.println("ALUNO REGISTRADO!");
		} else {
			System.out.println("ALUNO NÃO CADASTRADO!");
		}
		System.out.println("");
	}
	
	/**
	 * Imprime, em ordem, a matrícula, o nome e o curso dos alunos que responderam.
	 * 
	 * @param repositorio repositório com dados de alunos.
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
