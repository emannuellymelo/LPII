package agenda;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
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
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" +
						"(T)elefones preferidos\n" +
						"(Z)aps\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "T":
			telefonesPreferidos(agenda);
			break;
		case "Z":
			telefonesWhatsapp(agenda);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for(int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i+1, contatos[i].getNomeCompleto()));
			}
		}
		System.out.println("");
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		ExibeContato contato = new ExibeContato(agenda, posicao);
		System.out.println(contato + "\n");
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que será exibida)
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Coleta informações para ser feito o cadastro de um contato na agenda. Indica se o contato cadastrado é igual a um já existente. Impede o cadastro em uma posição menor que 1 e maior que 100. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nPosição na agenda: ");
		int posicao = Integer.parseInt(scanner.nextLine());
		if(posicao >= 1 && posicao <= 100) {
			System.out.print("\nNome: ");
			String nome = scanner.nextLine();
			System.out.print("\nSobrenome: ");
			String sobrenome = scanner.nextLine();
			System.out.print("\nTelefone1: ");
			String telefone1 = scanner.nextLine();
			System.out.print("\nTelefone2: ");
			String telefone2 = scanner.nextLine();
			System.out.print("\nTelefone3: ");
			String telefone3 = scanner.nextLine();
			System.out.print("\nTelefone prioritário: ");
			int telefonePrioridade = Integer.parseInt(scanner.nextLine());
			System.out.print("\nContato whatsapp: ");
			int telefoneWhatsapp= Integer.parseInt(scanner.nextLine());
			agenda.cadastraContato(posicao, nome, sobrenome, telefone1, telefone2, telefone3, telefonePrioridade, telefoneWhatsapp);
			System.out.println("CADASTRO REALIZADO\n");
			Contato[] contatos = agenda.getContatos();
			for(int e = 0; e < contatos.length; e++ ) {
				if(contatos[e] != null) {
					if(contatos[e].equals(contatos[posicao-1]) && e != posicao-1) {
						System.out.println("Sou eu, " + contatos[posicao-1].getNome() + "!\n");
						break;
					}
				}
			}

		} else {
			System.out.println("POSIÇÃO INVÁLIDA\n");
		}
	}
	
	/**
	 * Imprime todos os telefones prioritários registrados na agenda.
	 * @param agenda Agenda de contatos.
	 */
	private static void telefonesPreferidos(Agenda agenda) {
		Contato[] contatos = agenda.getContatos();
		for(int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(agenda.getContato(i+1) + " - " + agenda.getContatoPrioritario(i+1));
			}
		}
		System.out.println("");
	}
	
	/**
	 * Imprime todos os telefones de whatsapp registrados na agenda.
	 * @param agenda Agenda de contatos.
	 */
	private static void telefonesWhatsapp(Agenda agenda) {
		Contato[] contatos = agenda.getContatos();
		for(int e = 0; e < contatos.length; e++) {
			if(contatos[e] != null) {
				System.out.println(agenda.getContato(e+1) + " - " + agenda.getContatoWhatsapp(e+1));
			}
		}
		System.out.println("");
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

}
