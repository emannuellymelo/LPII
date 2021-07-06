package controle;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Representa��o de um grupo, o qual armazena dados sobre seus participantes.
 * 
 * @author Emannuelly Larissa Freitas de Melo - 119210167.
 */
public class Grupo {
	
	/**
	 * Nome do grupo.
	 */
	private String nomeGrupo;
	
	/**
	 * Lista que armazena a matr�cula dos seus integrantes.
	 */
	private ArrayList<String> matricula;
	
	/**
	 * Cria um grupo, a partir de um nome dado. Caso seja passado um nome nulo ou vazio � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param nomeGrupo nome do grupo a ser criado.
	 */
	public Grupo(String nomeGrupo) {
		if(nomeGrupo == null) {
			throw new NullPointerException("Entrada nula");
		} else if(nomeGrupo.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		this.nomeGrupo = nomeGrupo;
		this.matricula = new ArrayList();
	}
	
	/**
	 * Adiciona um aluno no grupo, a partir da sua matr�cula. Caso seja passada uma matr�cula nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param matricula matr�cula do aluno a ser alocado.
	 */
	public void adicionaParticipante(String matricula) {
		if(matricula == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		this.matricula.add(matricula);
	}
	
	/**
	 * Retorna lista com matr�culas dos participantes do grupo.
	 * 
	 * @return lista com matr�culas dos participantes do grupo.
	 */
	public ArrayList<String> getParticipantes() {
		return this.matricula;
	}
	
	/**
	 * Verifica, a partir da matr�cula dada, se o aluno em quest�o est� presente no grupo. Caso seja passada uma matr�cula nula ou vazia � lan�ada uma exce��o que encerra o sistema.
	 * 
	 * @param matricula matr�cula do aluno.
	 * @return true, se o aluno faz parte do grupo; false, se o estudante n�o � integrante do grupo.
	 */
	public boolean existeAlocado(String matricula) {
		if(matricula == null) {
			throw new NullPointerException("Entrada nula");
		} else if(matricula.equals("")) {
			throw new IllegalArgumentException("Entrada inv�lida");
		}
		return this.matricula.contains(matricula);
	}

	/**
	 * Gera um n�mero inteiro que identifica unicamente um grupo.
	 * 
	 * @return n�mero inteiro que identifica um grupo de forma �nica.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		return result;
	}

	/**
	 * Compara se um objeto � igual ao grupo de refer�ncia.
	 * 
	 * @return true, caso o objeto comparado seja igual ao grupo em quest�o; false, caso os objetos comparados sejam diferentes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		return true;
	}
	
	/**
	 * Retorna o nome do grupo.
	 * 
	 * @return nome do grupo.
	 */
	public String getNomeGrupo() {
		return this.nomeGrupo;
	}
	


}
