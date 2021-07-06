package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Reposit�rio que d� acesso aos dados dos alunos cadastrados na disciplina de Programa��o II.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 * 
 */
public class RepositorioAlunos {
	
	/**
	 * Mapa que associa a matr�cula de um aluno ao aluno.
	 */
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Conjunto que armazena os grupos cadastrados.
	 */
	private HashSet<Grupo> grupos;
	
	/**
	 * Lista com os alunos que respondem.
	 */
	private ArrayList<String> alunosQueRespondem;
	
	/**
	 * Cria um reposit�rio de alunos.
	 */
	public RepositorioAlunos() {
		this.alunos = new HashMap<>();
		this.grupos = new HashSet<>();
		this.alunosQueRespondem = new ArrayList();
	}

	/**
	 * Cadastra um aluno a partir da matr�cula, do nome e do curso. Caso seja passada uma informa��o nula ou vazia � lan�ada uma exce��o que encerra o sistema. Caso contr�rio, associa-se a matr�cula ao aluno no mapa.
	 * 
	 * @param matricula matr�cula do aluno.
	 * @param nome nome do estudante.
	 * @param curso curso do aluno.
	 */
	public void cadastraAluno(String matricula, String nome, String curso) {
		if(matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("") || nome.equals("") || curso.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		this.alunos.put(matricula, new Aluno(matricula, nome, curso));
	}
	
	/**
	 * Confere se existe um aluno cadastrado na disciplina a partir da sua matr�cula. Caso seja passada uma informa��o nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param matricula do aluno.
	 * @return true, se o estudante estiver cadastrado; false, se o estudante n�o estiver cadastrado.
	 */
	public boolean existeAluno(String matricula) {
		if(matricula == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		if(matricula != null && this.alunos.containsKey(matricula)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna o nome do aluno a partir da matr�cula. Caso seja passada uma matr�cula nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param matricula do aluno.
	 * @return nome do aluno.
	 */
	public String getNomeAluno(String matricula) {
		if(matricula == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		return this.alunos.get(matricula).getNomeAluno();
	}
	
	/**
	 * Retorna o curso do estudante, a partir da sua matr�cula. Caso seja passada uma matr�cula nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param matricula do aluno.
	 * @return nome do curso do aluno.
	 */
	public String getNomeCurso(String matricula) {
		if(matricula == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		return this.alunos.get(matricula).getCurso();
	}
	
	/**
	 * Verifica a exist�ncia de um grupo, a partir do seu nome. Caso seja passado um nome nulo ou vazio � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param nomeGrupo nome do Grupo a ser verificado.
	 * @return true, se o grupo est� cadastrado; false, se o grupo n�o existe.
	 */
	public boolean existeGrupo(String nomeGrupo) {
		if(nomeGrupo == null) {
			throw new NullPointerException("Entrada nula");
		} else if(nomeGrupo.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		for(Grupo grupo : grupos) {
			if(nomeGrupo != null && grupo.getNomeGrupo().equals(nomeGrupo)) {
				return true;
		}
		}
		return false;
	}
	
	/**
	 * Cadastra um grupo, a partir do nome a ele dado. Caso seja passado um nome nulo ou vazio � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param nomeGrupo nome do grupo a ser cadastrado.
	 */
	public void cadastraGrupo(String nomeGrupo) {
		if(nomeGrupo == null) {
			throw new NullPointerException("Entrada nula");
		} else if(nomeGrupo.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		this.grupos.add(new Grupo(nomeGrupo));
	}
	
	/**
	 * Verifica se um aluno est� alocado em um grupo, a partir do nome do grupo e da matr�cula do aluno. Caso seja passada uma informa��o nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param nomeGrupo nome do grupo que deve ter seus integrantes analisados.
	 * @param matricula matr�cula do aluno.
	 * @return true, se o estudante est� presente no grupo; false, se o estudante n�o faz parte do grupo.
	 */
	public boolean existeAlocado(String nomeGrupo, String matricula) {
		if(nomeGrupo == null || matricula == null) {
			throw new NullPointerException("Entrada nula");
		} else if(nomeGrupo.equals("") || matricula.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		for(Grupo grupo : grupos) {
			if(grupo.getNomeGrupo().equals(nomeGrupo) && grupo.existeAlocado(matricula)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Cadastra um aluno em um grupo a partir do nome do grupo e da matr�cula do aluno. Caso seja passada uma informa��o nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param nomeGrupo nome do grupo que o aluno deve ser alocado.
	 * @param matricula matr�cula do aluno.
	 */
	public void cadastraAlunoEmGrupo(String nomeGrupo, String matricula) {
		if(nomeGrupo == null || matricula == null) {
			throw new NullPointerException("Entrada nula");
		} else if(nomeGrupo.equals("") || matricula.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		for(Grupo grupo : grupos) {
			if(grupo.getNomeGrupo().equals(nomeGrupo)) {
				grupo.adicionaParticipante(matricula);
			}
		}
	}
	
	/**
	 * Imprime um grupo com seus participantes, a partir do nome do grupo fornecido. Caso seja passado um nome nulo ou vazio � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param nomeGrupo nome do grupo a ser impresso. Caso seja passada uma informa��o nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * @return lista com integrantes do grupo.
	 */
	public ArrayList<String> imprimeGrupo(String nomeGrupo) {
		if(nomeGrupo == null) {
			throw new NullPointerException("Entrada nula");
		} else if(nomeGrupo.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		for(Grupo grupo : grupos) {
			if(grupo.getNomeGrupo().equals(nomeGrupo)) {
				return grupo.getParticipantes();
			}
		}
		return null;
	}
	
	/**
	 * Registra os alunos que respondem perguntas na disciplina, em ordem, a partir da matr�cula do aluno. Caso seja passada uma matr�cula nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param matricula do aluno.
	 */
	public void registraAlunosQueRespondem(String matricula) {
		if(matricula == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		this.alunosQueRespondem.add(matricula);
	}
	
	/**
	 * Imprime uma lista, em ordem, com os alunos que respondem perguntas na disciplina.
	 * 
	 * @return lista com alunos que respondem.
	 */
	public ArrayList<String> imprimeAlunosQueRespondem() {
		return this.alunosQueRespondem;
	}
	
	/**
	 * Retorna uma String com os dados do aluno, a partir da sua matr�cula. Caso seja passada uma matr�cula nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param matricula do aluno.
	 * @return string com dados do aluno.
	 */
	public String aluno(String matricula) {
		return this.alunos.get(matricula).toString();
	}
}
